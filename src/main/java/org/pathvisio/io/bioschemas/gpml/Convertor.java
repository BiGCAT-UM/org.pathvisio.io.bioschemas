// Copyright (c) 2023 Egon Willighagen <egon.willighagen@gmail.com>
// 
// Conversion from GPML pathways to RDF
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
package org.pathvisio.io.bioschemas.gpml;

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

		StringBuffer results = new StringBuffer();
		results.append("[\n");
		results.append("  {\n");
		results.append("    \"@context\": \"https://schema.org/\",\n");
		results.append("    \"@id\": \"https://wikipathways.github.io/pathways/").append(wpId).append(".html\",\n");
		results.append("    \"@type\": \"Dataset\",\n");
		results.append("    \"creator\": {\n");
		results.append("      \"@type\": \"Organization\",\n");
		results.append("      \"name\": \"WikiPathways\",\n");
		results.append("    },\n");
		if (pathway.getDescription() != null) {
			results.append("    \"description\": \"").append(pathway.getDescription().replace("\"", "\\\"")).append("\",\n");
		}
		results.append("    \"license\": \"CC0\",\n");
		results.append("    \"name\": \"").append(pathway.getTitle().replace("\"", "\\\"")).append("\",\n");
		results.append("  }\n");
		results.append("]\n");
		return results.toString();
	}

}
