---
title: Java String Signing using Google Tink
keywords: sample
summary: "Java string signing using Google Tink"
permalink: java_tink_string_sign.html
folder: Java Tink
references: [
    # Place a list of references used to create and/or understand this example.
    {
        url: "https://github.com/google/tink/blob/master/docs/JAVA-HOWTO.md",
        description: "Google Tink Java Howto"
    }
]
authors: [
    {
        name: "Kai Mindermann",
        url: "https://github.com/kmindi"
    }
]
# List all reviewers that reviewed this version of the example. When the example is updated all old reviews
# must be removed from the list below and the code has to be reviewed again. The complete review process
# is documented in the main repository of CryptoExamples
current_reviews: [

]
# Indicates when this example was last updated/created. Reviews don't change this.
last_updated: "2018-06-28"
tags: [Java]
---

## Use cases

- Verifying if a string has been changed

## Example Code

```java
{% include_relative src/main/java/com/cryptoexamples/java/ExampleSignatureInOneMethod.java %}
```

{% include links.html %}
