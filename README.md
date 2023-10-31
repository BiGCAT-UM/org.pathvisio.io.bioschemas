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
    "@id": "https://bioregistry.org/chebi:42977",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "MolecularEntity",
    "name": "25HC",
    "identifier": "chebi:42977",
    "taxonomicRange": "http://purl.obolibrary.org/obo/NCBITaxon_9606"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/chebi:39025",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "MolecularEntity",
    "name": "HDL",
    "identifier": "chebi:39025",
    "taxonomicRange": "http://purl.obolibrary.org/obo/NCBITaxon_9606"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/chebi:28815",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "MolecularEntity",
    "name": "heparan sulfate",
    "identifier": "chebi:28815",
    "taxonomicRange": "http://purl.obolibrary.org/obo/NCBITaxon_9606"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/chebi:16393",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "MolecularEntity",
    "name": "sphingosine",
    "identifier": "chebi:16393",
    "taxonomicRange": "http://purl.obolibrary.org/obo/NCBITaxon_9606"
  },
  {
    "@context": "https://schema.org/",
    "@id": "https://bioregistry.org/chebi:16113",
    "includedInDataset": {"@id": "https://identifiers.org/wikipathways:WP4846", "@type": "Dataset"},
    "@type": "MolecularEntity",
    "name": "cholesterol",
    "identifier": "chebi:16113",
    "taxonomicRange": "http://purl.obolibrary.org/obo/NCBITaxon_9606"
  },
  {}
]
```
