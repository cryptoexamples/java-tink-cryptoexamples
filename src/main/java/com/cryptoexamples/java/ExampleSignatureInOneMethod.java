package com.cryptoexamples.java;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.signature.PublicKeySignFactory;
import com.google.crypto.tink.signature.PublicKeyVerifyFactory;
import com.google.crypto.tink.signature.SignatureConfig;
import com.google.crypto.tink.signature.SignatureKeyTemplates;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * All in one example for cryptographic signing of a string in one method using Google Tink.
 * - Generation of public and private elliptic curve key pair
 * - BASE64 encoding as representation for the byte-arrays
 * - UTF-8 encoding of Strings
 * - Exception handling
 */
public class ExampleSignatureInOneMethod {
  private static final Logger LOGGER = Logger.getLogger(ExampleSignatureInOneMethod.class.getName());

  public static void main(String[] args) {
    String plainText = "Text that should be signed to prevent unknown tampering with its content.";
    try {
      // Initialize Tink configuration
      Config.register(SignatureConfig.TINK_1_1_1);

      // GENERATE NEW KEYPAIR
      KeysetHandle privateKeysetHandle = KeysetHandle.generateNew(SignatureKeyTemplates.ED25519);
      PublicKeySign signer = PublicKeySignFactory.getPrimitive(privateKeysetHandle);

      // SIGN DATA/STRING
      byte[] signatureBytes = signer.sign(plainText.getBytes(StandardCharsets.UTF_8));
      String signatureForPlainTextString = new String(Base64.getEncoder().encode(signatureBytes), StandardCharsets.UTF_8);
      LOGGER.log(Level.INFO, () -> String.format("Signature: %s", signatureForPlainTextString));

      // VERIFY JUST CREATED SIGNATURE USING PUBLIC KEY
      KeysetHandle publicKeysetHandle = privateKeysetHandle.getPublicKeysetHandle();
      PublicKeyVerify verifier = PublicKeyVerifyFactory.getPrimitive(publicKeysetHandle);

      // verify does NOT return anything, instead it will throw an exception if the signature is incorrect!
      verifier.verify(signatureBytes, plainText.getBytes(StandardCharsets.UTF_8));
      LOGGER.log(Level.INFO, "Signature is correct, because no exception has been thrown during verification.");
    } catch (java.security.GeneralSecurityException e) {
      LOGGER.log(Level.SEVERE, e.getLocalizedMessage(), e);
    }
  }
}
