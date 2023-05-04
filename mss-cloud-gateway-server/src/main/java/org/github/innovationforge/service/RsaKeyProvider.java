package org.github.innovationforge.service;

import lombok.Getter;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Getter
@Component
public class RsaKeyProvider {

    private final String keyId = "keyid";

    @Value("${publickey.path:/rsa-keys/public_rsa_key}")
    private String publicKeyPath;

    @Value("${privatekey.path:/rsa-keys/private_rsa_key}")
    private String privateKeyPath;

    private RSAPublicKey rsaPublicKey;
    private RSAPrivateKey rsaPrivateKey;

    @PostConstruct
    public void afterInit() {
        try {
            final byte[] keyBytes = Base64.getDecoder().decode(IOUtils.resourceToByteArray(publicKeyPath));
            final X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            final KeyFactory kf = KeyFactory.getInstance("RSA");
            rsaPublicKey = (RSAPublicKey) kf.generatePublic(spec);
        } catch (final NoSuchAlgorithmException | InvalidKeySpecException | IOException e) {
            throw new IllegalArgumentException(e);
        }

        try {
            final byte[] keyBytes = Base64.getDecoder().decode(IOUtils.resourceToByteArray(privateKeyPath));
            final PKCS8EncodedKeySpec spec =
                    new PKCS8EncodedKeySpec(keyBytes);
            final KeyFactory kf = KeyFactory.getInstance("RSA");
            rsaPrivateKey = (RSAPrivateKey) kf.generatePrivate(spec);
        } catch (final NoSuchAlgorithmException | InvalidKeySpecException | IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
