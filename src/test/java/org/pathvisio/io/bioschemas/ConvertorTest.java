// Copyright (c) 2023 Egon Willighagen <egon.willighagen@gmail.com>
//
//Conversion from GPML pathways to RDF
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.
//
package org.pathvisio.io.bioschemas;

import java.io.InputStream;

import org.bridgedb.DataSource;
import org.bridgedb.Xref;
import org.junit.Assert;
import org.junit.Test;
import org.pathvisio.io.bioschemas.Convertor;
import org.pathvisio.libgpml.model.PathwayModel;

public class ConvertorTest {

	@Test
	public void convert() throws Exception {
		// read the pathway
		PathwayModel pathway = new PathwayModel();
		InputStream gpmlStream = getClass().getResourceAsStream("/WP4846.gpml"); 
		pathway.readFromXml(gpmlStream, true);
		DataSource wpSource = DataSource.register("Wp", "WikiPathways").asDataSource();
		pathway.getPathway().setXref(new Xref("WP4846", wpSource));

		String json = new Convertor(pathway).asBioschemas();
		Assert.assertNotNull(json);
		System.out.println(json);
	}
	
}
