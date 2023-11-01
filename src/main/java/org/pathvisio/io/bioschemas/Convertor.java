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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bridgedb.DataSource;
import org.bridgedb.Xref;
import org.bridgedb.bio.Organism;
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

		StringBuffer results = new StringBuffer();
		results.append("[\n");
		results.append("  {\n");
		results.append("    \"@context\": \"https://schema.org/\",\n");
		results.append("    \"@id\": \"https://identifiers.org/wikipathways:").append(wpId).append("\",\n");
		results.append("    \"@type\": \"Dataset\",\n");
		results.append("    \"name\": \"").append(pathway.getTitle().replace("\"", "\\\"")).append("\",\n");
		results.append("    \"url\": \"https://wikipathways.github.io/pathways/").append(wpId).append(".html\",\n");
		results.append("    \"creator\": {\n");
		results.append("      \"@type\": \"Organization\",\n");
		results.append("      \"name\": \"WikiPathways\"\n");
		results.append("    },\n");
		if (pathway.getDescription() != null) {
			results.append("    \"description\": \"").append(pathway.getDescription().replace("\"", "\\\"")).append("\",\n");
		}
		results.append("    \"taxonomicRange\": \"").append(taxonURL).append("\",\n");
		results.append("    \"license\": \"CC0\"\n");
		results.append("  },\n");

		// taxon
		results.append("  {\n");
		results.append("    \"@context\": \"https://schema.org/\",\n");
		results.append("    \"@id\": \"").append(taxonURL).append("\",\n");
		results.append("    \"@type\": \"Taxon\",\n");
		results.append("    \"name\": \"").append(organism).append("\",\n");
		results.append("    \"identifier\": \"ncbitaxon:").append(taxonID).append("\"\n");
		results.append("  },\n");

		// datanodes
		Set<String> alreadyDone = new HashSet<>(); // only export unique nodes
		boolean justDidOne = false;
		Map<String,String> types = new HashMap<>();
		types.put("Metabolite", "MolecularEntity");
		types.put("Protein", "Protein");
		types.put("GeneProduct", "BioChemEntity");
		for (DataNode node : this.pathway.getDataNodes()) {
			String nodeType = node.getType().getName();
			if (types.containsKey(nodeType) && node.getXref() != null) {
				String bioreg = node.getXref().getBioregistryIdentifier();
				if (!alreadyDone.contains(bioreg)) {
					if (justDidOne) { results.append(",\n"); justDidOne = false; }
					results.append("  {\n");
					results.append("    \"@context\": \"https://schema.org/\",\n");
					results.append("    \"@id\": \"https://bioregistry.org/").append(node.getXref().getBioregistryIdentifier()).append("\",\n");
					results.append("    \"includedInDataset\": {\"@id\": \"https://identifiers.org/wikipathways:").append(wpId).append("\", \"@type\": \"Dataset\"},\n");
					String bsType = types.get(nodeType);
					results.append("    \"@type\": \"").append(bsType).append("\",\n");
					String nodeName = node.getTextLabel().replace("\"", "\\\"").replace("\n", " ").replace("\r", "");
					results.append("    \"name\": \"").append(nodeName).append("\",\n");
					results.append("    \"identifier\": \"").append(node.getXref().getBioregistryIdentifier()).append("\"\n");
					results.append("  }");
					alreadyDone.add(bioreg);
					justDidOne = true;
				}
			}
		}
		results.append("\n]\n");
		return results.toString();
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
