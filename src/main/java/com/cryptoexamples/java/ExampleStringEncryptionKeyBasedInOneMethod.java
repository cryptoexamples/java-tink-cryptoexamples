package com.cryptoexamples.java;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Config;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AeadFactory;
import com.google.crypto.tink.aead.AeadKeyTemplates;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * All in one example for symmetric encryption and decryption of a string in one method using Google Tink.
 * - Generation of a key
 * - AES-256 authenticated encryption (AEAD) using GCM
 * - BASE64 encoding as representation for the byte-arrays
 * - UTF-8 encoding of Strings
 * - Exception handling
 */
public class ExampleStringEncryptionKeyBasedInOneMethod {
  private static final Logger LOGGER = Logger.getLogger(ExampleStringEncryptionKeyBasedInOneMethod.class.getName());

  public static void main(String[] args) {
    String plainText = "Text that is going to be sent over an insecure channel and must be encrypted at all costs!";

    try {
      // Initialize Tink configuration
      Config.register(AeadConfig.TINK_1_1_0);

      // GENERATE key
      // TODO key should only be generated once and then stored in a secure location.
      KeysetHandle keysetHandle = KeysetHandle.generateNew(AeadKeyTemplates.AES256_GCM);

      // ENCRYPTION
      Aead aeadEncryption = AeadFactory.getPrimitive(keysetHandle);
      byte[] cipherTextBytes = aeadEncryption.encrypt(plainText.getBytes(StandardCharsets.UTF_8),null);
      // conversion of raw bytes to BASE64 representation
      String cipherText = new String(Base64.getEncoder().encode(cipherTextBytes));

      // DECRYPTION
      Aead aeadDecryption = AeadFactory.getPrimitive(keysetHandle);
      byte[] decryptedCipherTextBytes = aeadDecryption.decrypt(Base64.getDecoder().decode(cipherText), null);
      String decryptedCipherText = new String(decryptedCipherTextBytes,StandardCharsets.UTF_8);

      LOGGER.log(Level.INFO, () -> String.format("Decrypted and original plain text are the same: %b", decryptedCipherText.compareTo(plainText) == 0));
    } catch (GeneralSecurityException e) {
      LOGGER.log(Level.SEVERE, e.getMessage(), e);
    }
  }
}
