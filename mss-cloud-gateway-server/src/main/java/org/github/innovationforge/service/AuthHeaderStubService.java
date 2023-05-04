package org.github.innovationforge.service;

import com.nimbusds.jose.JOSEException;

public interface AuthHeaderStubService {
    public String createAuthHeader() throws JOSEException;
}
