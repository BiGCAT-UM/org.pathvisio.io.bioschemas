# libGPML plugin for Bioschemas

Allows exporting a GPML as Bioschemas annotation.

Example Bioschemas JSON:

```json
[
  {
    "@context": "https://schema.org/",
    "@id": "https://identifiers.org/wikipathways:WP4846",
    "@type": "Dataset",
    "name": "SARS-CoV-2 and COVID-19 pathway",
    "url": "https://wikipathways.github.io/pathways/WP4846.html",
    "creator": {
      "@type": "Organization",
      "name": "WikiPathways"
    },
    "description": "Collaborative project for curation biological processes involved in the COVID-19 disease after SARS-Cov-2 infection. It focuses on experimental evidence and plays with improved annotation of complexes and with the Evidence and Conclusion Ontology. The complexes link to EBI's Complex Portal, resulting from a collaboration with that database at the recent online ELIXIR biohackathon. Editing this pathway is (at this moment) coordinated via the wikipathways.slack.com #sarscov2 channel. Additionally, please feel free to add suggestions to the discussion page (see the tab at the top of this page). The large viral Spike protein (S or surface glycoprotein) forms trimers. It interacts with the host's ACE2 receptor to establish binding (Hoffmann et al 2020). There are suggestions for more than one cell entry mechanism, with the evidence for ACE2/TMPRSS2 entry being most clear now. Lack of expression of TMPRSS2 may explain age differences in COVID19 severity. In this mechanism, to enter the virus needs to be primed by the host protease TMPRSS2 that splits the Spike protein into 2 peptides S1 and S2. S1 contains the ACE2 receptor binding site, S2 binds to the host cell membrane which leads to membrane fusion, the start of the uptake process. The ACE2 receptor interaction was also suggested as the start of specific lung-damaging effects. Other human genes that may be involved in alternative cell uptake mechanisms include CTSL and SLC6A19.",
    "taxonomicRange": "http://purl.obolibrary.org/obo/NCBITaxon_9606",
    "license": "CC0"
  },
  {
    "@context": "https://schema.org/",
    "@id": "http://purl.obolibrary.org/obo/NCBITaxon_9606",
    "@type": "Taxon",
    "name": "Homo sapiens",
    "identifier": "ncbitaxon:9606"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/uniprot:P0DTC2",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "surface glycoprotein S",
    "identifier": "uniprot:P0DTC2"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/ensembl:ENSG00000073060",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "BioChemEntity",
    "name": "SCARB1",
    "identifier": "ensembl:ENSG00000073060"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/ensembl:ENSG00000174358",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "BioChemEntity",
    "name": "SLC6A19",
    "identifier": "ensembl:ENSG00000174358"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q90038952",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "nsp1",
    "identifier": "wikidata:Q90038952"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/uniprot:P07711",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "CTSL",
    "identifier": "uniprot:P07711"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/chebi:42977",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "MolecularEntity",
    "name": "25HC",
    "identifier": "chebi:42977"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/uniprot:Q9NYK1",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "TLR7",
    "identifier": "uniprot:Q9NYK1"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/uniprot:Q9NRS4",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "TMPRSS4",
    "identifier": "uniprot:Q9NRS4"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/chebi:39025",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "MolecularEntity",
    "name": "HDL",
    "identifier": "chebi:39025"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/uniprot:P09958",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "FURIN",
    "identifier": "uniprot:P09958"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/ensembl:ENSG00000075239",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "BioChemEntity",
    "name": "ACAT",
    "identifier": "ensembl:ENSG00000075239"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/chebi:28815",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "MolecularEntity",
    "name": "heparan sulfate",
    "identifier": "chebi:28815"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/chebi:16393",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "MolecularEntity",
    "name": "sphingosine",
    "identifier": "chebi:16393"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q106020384",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "S2 subunit",
    "identifier": "wikidata:Q106020384"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q82069695",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "SARS-CoV-2 proteins",
    "identifier": "wikidata:Q82069695"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/uniprot:P0DTC1",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "orf1a",
    "identifier": "uniprot:P0DTC1"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/uniprot:O15393",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "TMPRSS2",
    "identifier": "uniprot:O15393"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/uniprot:P0DTD1",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "orf1ab",
    "identifier": "uniprot:P0DTD1"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/uniprot:Q9BYF1",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "ACE2",
    "identifier": "uniprot:Q9BYF1"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/uniprot:P0DTC3",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "ORF3a",
    "identifier": "uniprot:P0DTC3"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q89226299",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "ORF6",
    "identifier": "wikidata:Q89226299"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q88658500",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "ORF7a",
    "identifier": "wikidata:Q88658500"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q89225654",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "ORF8",
    "identifier": "wikidata:Q89225654"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/uniprot:P0DTC9",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "nucleocapsid protein",
    "identifier": "uniprot:P0DTC9"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/uniprot:P0DTC5",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "membrane glycoprotein",
    "identifier": "uniprot:P0DTC5"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/uniprot:P0DTC4",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "envelope protein",
    "identifier": "uniprot:P0DTC4"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/ncbigene:43740578",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "BioChemEntity",
    "name": "orf1",
    "identifier": "ncbigene:43740578"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/ncbigene:43740569",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "BioChemEntity",
    "name": "ORF3a",
    "identifier": "ncbigene:43740569"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/ncbigene:43740572",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "BioChemEntity",
    "name": "ORF6",
    "identifier": "ncbigene:43740572"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/ncbigene:43740573",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "BioChemEntity",
    "name": "ORF7a",
    "identifier": "ncbigene:43740573"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/ncbigene:43740577",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "BioChemEntity",
    "name": "ORF8",
    "identifier": "ncbigene:43740577"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/ncbigene:43740576",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "BioChemEntity",
    "name": "ORF10",
    "identifier": "ncbigene:43740576"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/ncbigene:43740575",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "BioChemEntity",
    "name": "nucleocapsid phosphoprotein",
    "identifier": "ncbigene:43740575"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/ncbigene:43740571",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "BioChemEntity",
    "name": "membrane glycoprotein",
    "identifier": "ncbigene:43740571"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/ncbigene:43740570",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "BioChemEntity",
    "name": "envelope protein",
    "identifier": "ncbigene:43740570"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/ncbigene:43740568",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "BioChemEntity",
    "name": "surface glycoprotein",
    "identifier": "ncbigene:43740568"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q89006922",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "nsp2",
    "identifier": "wikidata:Q89006922"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q87917581",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "PL2-PRO",
    "identifier": "wikidata:Q87917581"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q87917582",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "3CL-PRO",
    "identifier": "wikidata:Q87917582"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q90038956",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "nsp4",
    "identifier": "wikidata:Q90038956"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q90038963",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "nsp7",
    "identifier": "wikidata:Q90038963"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q88659350",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "nsp8",
    "identifier": "wikidata:Q88659350"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q89686805",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "nsp9",
    "identifier": "wikidata:Q89686805"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q87917572",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "nsp10",
    "identifier": "wikidata:Q87917572"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q94647436",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "nsp12",
    "identifier": "wikidata:Q94647436"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q94648377",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "nsp13",
    "identifier": "wikidata:Q94648377"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q94648393",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "ExoN",
    "identifier": "wikidata:Q94648393"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q87917579",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "nsp15",
    "identifier": "wikidata:Q87917579"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q88656943",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "nsp6",
    "identifier": "wikidata:Q88656943"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q89227548",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "ORF10",
    "identifier": "wikidata:Q89227548"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/wikidata:Q88089438",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "ORF7b",
    "identifier": "wikidata:Q88089438"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/ncbigene:43740574",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "BioChemEntity",
    "name": "ORF7b",
    "identifier": "ncbigene:43740574"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/uniprot:P0DTD3",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "ORF14",
    "identifier": "uniprot:P0DTD3"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/uniprot:O14786",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "Protein",
    "name": "NRP1",
    "identifier": "uniprot:O14786"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/chebi:16113",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "MolecularEntity",
    "name": "cholesterol",
    "identifier": "chebi:16113"
  }
]
```
