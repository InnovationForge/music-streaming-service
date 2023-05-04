package org.github.innovationforge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DemoCloudConfigProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCloudConfigProviderApplication.class, args);
	}

}
