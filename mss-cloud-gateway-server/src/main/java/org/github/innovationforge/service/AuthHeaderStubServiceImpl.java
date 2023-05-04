package org.github.innovationforge.service;

import lombok.AllArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class AuthHeaderStubServiceImpl implements AuthHeaderStubService {
    private static final int EXPIRATION_TIME_SIGNATURE = 300;
    private final RsaKeyProvider rsaKeyProvider;

    public String createAuthHeader() throws JOSEException {
        JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS512).keyID(rsaKeyProvider.getKeyId()).build();
        SignedJWT signedJWT = new SignedJWT(header, getFixedJWTClaimsSet());
        JWSSigner jwsSigner = new RSASSASigner(rsaKeyProvider.getRsaPrivateKey());
        signedJWT.sign(jwsSigner);
        return signedJWT.serialize();
    }

    private JWTClaimsSet getJWTClaimsSet() {
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
//        String edoKlid = fakeValuesService.regexify("KLID[0-9]{32}ZBJ94");
        String edoAgreementId = fakeValuesService.regexify("000[1-9]{6}");
        String edoUserId = fakeValuesService.regexify("[0-9]{8}");
        String siebelUserRelationId = fakeValuesService.regexify("0000000[1-9]{8}");
        String siebelCustomerRelationId = fakeValuesService.regexify("0000000[1-9]{8}");
        String authDeviceId = fakeValuesService.regexify("[1-9]{8}");
        String authUserId = fakeValuesService.regexify("X[0-9]{18}");
        String authSessionId = UUID.randomUUID().toString();

        String edoKlid = "KLID" + edoUserId + edoAgreementId + siebelCustomerRelationId + "ZBJ94";

        return new JWTClaimsSet.Builder()
                .issueTime(new Date())
                .expirationTime(Date.from(ZonedDateTime.now().plusDays(EXPIRATION_TIME_SIGNATURE).toInstant()))
                .claim("authUserId", authUserId)
                .claim("authUserLevel", "3")
                .claim("authTicket", "CUSTOMER:3:"+edoKlid)
                .claim("authSessionId", authSessionId)
                .claim("authDeviceId", authDeviceId)
                .claim("siebelCustomerRelationId", siebelCustomerRelationId)
                .claim("siebelUserRelationId", siebelUserRelationId)
                .claim("edoKlid", edoKlid)
                .claim("edoAgreementId", edoAgreementId)
                .claim("edoUserId", edoUserId)
                .claim("sources", Arrays.asList("RASS", "TA"))
                .build();
    }

    private JWTClaimsSet getFixedJWTClaimsSet() {
        return new JWTClaimsSet.Builder()
                .issueTime(new Date())
                .expirationTime(Date.from(ZonedDateTime.now().plusDays(EXPIRATION_TIME_SIGNATURE).toInstant()))
                .claim("authUserId", "X847222960796125253")
                .claim("authUserLevel", "3")
                .claim("authTicket", "CUSTOMER:3:KLID43310613000771957000000067145714ZBJ94")
                .claim("authSessionId", "8752e043-583e-4061-a35f-03384a8c418c")
                .claim("authDeviceId", "98325666")
                .claim("siebelCustomerRelationId", "000000031338914")
                .claim("siebelUserRelationId", "000000031338914")
                .claim("edoKlid", "KLID43310613000771957000000067145714ZBJ94")
                .claim("edoAgreementId", "000771957")
                .claim("edoUserId", "43310613")
                .claim("sources", Arrays.asList("RASS", "TA"))
                .build();
    }
}
