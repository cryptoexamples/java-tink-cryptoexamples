---
title: Java String Encryption with key generation using Google Tink
keywords: sample
summary: "String encryption in Java with key generation using Google Tink"
permalink: java_tink_string_encryption_key_based_symmetric.html
folder: Java Tink
references: [
    # Place a list of references used to create and/or understand this example.
    {
        url: "https://github.com/google/tink/blob/master/doc/JAVA-HOWTO.md",
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
last_updated: "2018-05-12"
tags: [Java, AES, GCM, AEAD]
---

## Use cases

- String encryption

## Sample Code

```java
{% include_relative src/main/java/com/cryptoexamples/java/ExampleStringEncryptionKeyBasedInOneMethod.java %}
```

{% include links.html %}
