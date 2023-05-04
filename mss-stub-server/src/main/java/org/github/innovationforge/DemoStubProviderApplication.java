package org.github.innovationforge;

import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.core.Options;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.cloud.contract.wiremock.WireMockSpring;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AutoConfigureWireMock
public class DemoStubProviderApplication {
	@Value("${stub.server.port}")
	private int port;

	@Value("${stub.server.files}")
	private String path;

	public static void main(String[] args) {
		new SpringApplicationBuilder(DemoStubProviderApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
	}

	@Bean
	public Options wireMockOptions() {
		final WireMockConfiguration options = WireMockSpring.options();
		options.port(port);
		options.disableRequestJournal();
		options.asynchronousResponseEnabled(true);
		options.asynchronousResponseThreads(10);
		ClasspathFileSource fileSource = new ClasspathFileSource(path);
		if (fileSource.getUri().getPath() == null) {
			options.usingFilesUnderClasspath("BOOT-INF/classes/" + path);
		} else {
			options.usingFilesUnderClasspath(path);
		}
		return options;
	}

}
