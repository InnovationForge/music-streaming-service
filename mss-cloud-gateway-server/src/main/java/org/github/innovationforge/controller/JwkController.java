package org.github.innovationforge.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import org.github.innovationforge.service.AuthHeaderStubService;
import org.github.innovationforge.service.RsaKeyProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
class JwkController {
    private final RsaKeyProvider rsaKeyProvider;
    private final AuthHeaderStubService authHeaderService;

    @GetMapping("/jwk")
    public ResponseEntity getJsonWebKey() {
        final JWK jwk = new RSAKey
                .Builder(rsaKeyProvider.getRsaPublicKey())
                .keyID(rsaKeyProvider.getKeyId())
                .build();
        log.info("Edge router responded JWK request");
        return ResponseEntity.ok(new JWKSet(jwk).toJSONObject());
    }

    @GetMapping("/jwt")
    public ResponseEntity getJsonWebToken() throws JOSEException {
        log.info("Edge router responded JWK request");
        return ResponseEntity.ok().body(authHeaderService.createAuthHeader());
    }
}
