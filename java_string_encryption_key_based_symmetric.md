---
title: Java String Encryption with key generation using Google Tink
keywords: sample
summary: "Java String encryption with key generation using Google Tink"
permalink: java_tink_string_encryption_key_based_symmetric.html
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
last_updated: "2020-02-16"
tags: [Java, AES, GCM, AEAD]
---

## Use cases

- String encryption


## Java version

- openjdk8
- oraclejdk9
- openjdk9
- oraclejdk11
- openjdk11
- oraclejdk13
- openjdk13

## Example Code

```java
{% include_relative src/main/java/com/cryptoexamples/java/ExampleStringEncryptionKeyBasedInOneMethod.java %}
```

{% include links.html %}
