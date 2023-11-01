// Copyright (c) 2023 Egon Willighagen <egon.willighagen@gmail.com>
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
package org.pathvisio.io.bioschemas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bridgedb.DataSource;
import org.bridgedb.Xref;
import org.bridgedb.bio.Organism;
import org.json.JSONArray;
import org.json.JSONObject;
import org.pathvisio.libgpml.model.DataNode;
import org.pathvisio.libgpml.model.Pathway;
import org.pathvisio.libgpml.model.PathwayModel;

/**
 * Tool to convert a {@link Pathway} model into a Bioschemas JSON.
 */
public class Convertor {

	PathwayModel pathway;

	public Convertor(PathwayModel pathway) {
		this.pathway = pathway;
	}

	public String asBioschemas() {
		Pathway pathway = this.pathway.getPathway();
		String wpId = pathway.getXref().getId();
		String organism = pathway.getOrganism();
		String taxonID = Organism.fromLatinName(organism).taxonomyID().getId();
		String taxonURL = "http://purl.obolibrary.org/obo/NCBITaxon_" + taxonID;

		JSONArray root = new JSONArray(new ArrayList<>());

		JSONObject shortDataset = new JSONObject();
		shortDataset.put("@id", "https://identifiers.org/wikipathways:" + wpId);
		shortDataset.put("@type", "Dataset");

		JSONObject dataset = new JSONObject();
		dataset.put("@context", "https://schema.org/");
		dataset.put("@id", "https://identifiers.org/wikipathways:" + wpId);
		dataset.put("@type", "Dataset");
		dataset.put("name", pathway.getTitle());
		dataset.put("url", "https://wikipathways.github.io/pathways/" + wpId);
		Map<String,String> creator = new HashMap<>();
		creator.put("@type", "Organization");
		creator.put("name", "WikiPathways");
		dataset.put("creator", creator);
		if (pathway.getDescription() != null) {
			String description = pathway.getDescription();
			dataset.put("description", description);
		}
		dataset.put("taxonomicRange", taxonURL);
		dataset.put("license", "CC0");
		root.put(dataset);

		// taxon
		JSONObject taxon = new JSONObject();
		taxon.put("@context", "https://schema.org/");
		taxon.put("@id", taxonURL);
		taxon.put("@type", "Taxon");
		taxon.put("name", "organism");
		taxon.put("identifier", "ncbitaxon:" + taxonID);
		root.put(taxon);

		// datanodes
		Set<String> alreadyDone = new HashSet<>(); // only export unique nodes
		Map<String,String> types = new HashMap<>();
		types.put("Metabolite", "MolecularEntity");
		types.put("Protein", "Protein");
		types.put("GeneProduct", "BioChemEntity");
		for (DataNode node : this.pathway.getDataNodes()) {
			String nodeType = node.getType().getName();
			if (types.containsKey(nodeType) && node.getXref() != null) {
				String bioregPrefix = node.getXref().getDataSource().getBioregistryPrefix();
				String bioreg = node.getXref().getBioregistryIdentifier();
				if (!alreadyDone.contains(bioreg) && bioregPrefix != null && !bioregPrefix.isEmpty()) {
					bioreg = bioreg.trim();
					String bsType = types.get(nodeType);
					String nodeName = node.getTextLabel().trim();
					JSONObject datanode = new JSONObject();
					datanode.put("@context", "https://schema.org/");
					datanode.put("@id", "https://bioregistry.org/" + bioreg);
					datanode.put("includedInDataset", shortDataset);
					datanode.put("@type", bsType);
					datanode.put("name", nodeName);
					datanode.put("identifier", bioreg);
					root.put(datanode);
					alreadyDone.add(bioreg);
				}
			}
		}
		return root.toString(2);
	}

	public static void main(String[] args) throws Exception {
        String gpmlFile = args[0];
        String outFile  = args[1];
        int index = gpmlFile.indexOf("WP");
        String localFile = gpmlFile.substring(index);
        String wpid     = localFile.substring(0,localFile.indexOf("."));

        PathwayModel pathway = new PathwayModel();
		InputStream gpmlStream = new FileInputStream(new File(gpmlFile));
		pathway.readFromXml(gpmlStream, false);
		DataSource wpSource = DataSource.register("Wp", "WikiPathways").asDataSource();
		pathway.getPathway().setXref(new Xref(wpid, wpSource));

		Convertor convertor = new Convertor(pathway);

		FileOutputStream output = new FileOutputStream(outFile);
		output.write(convertor.asBioschemas().getBytes());
        output.flush();
        output.close();
	}

}
