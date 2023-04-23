# Music Streaming Service (MSS)
`music-streaming-service` is a music streaming rest api that allows users to search and stream music tracks from various artists and genres.

## MSS Maven Project Structure
MSS Rest API application is a multi-module Maven project that contains more than one module or sub-project. The main benefit of using a multi-module Maven project is that it allows you to divide a large project into smaller, more manageable modules. Each module can have its own dependencies, build configurations, and release cycles, which makes it easier to manage and maintain the project `music-streaming-service`.  <br>Here is the maven project structure : 
```bash
music-streaming-service
    ├───mss-application
    ├───mss-library
    ├───mss-gateway-server
    ├───mss-config-server
    ├───mss-stub-server
    ├───.gitignore
    ├───pom.xml
    └───README.md
```
### mss-application module
`mss-application module` is the application module, that implements the business functionality of weather API that provides current weather information and forecasts for various locations.
### mss-library module
`mss-library` is the library module created with the vision of re-usability of its functionality in other applications/modules, One or more library modular design is a best practice to improve the design process by allowing better re-usability, workload handling, and easier debugging processes.
### mss-gateway-server module
`mss-gateway-server` is an application, that works as an API Gateway built on top of Spring WebFlux. It is meant to provide a simple, yet effective way to route to APIs and provide cross cutting concerns to them such as: security, monitoring/metrics, and resiliency.
### mss-config-server module
`mss-config-server module` is an application built on Spring Cloud Config. It provides support for externalized configuration. With the Config Server you have a central place to manage external properties for applications across all environments.
* dev
* test
* prod
### mss-stub-server module
`mss-stub-server module` is an application built using WireMock and Spring Boot. it helps in Service virtualization. I believe , haveing a stub server as part of the application offers a great best practice to simulate the behavior of external or integrated services on which the system is dependent. It ensures that the system to be tested is isolated by minimizing dependencies. The virtualization of these dependent services, which are beyond our control, will greatly speed up the testing and development processes. In addition to this, possible data-based problems are prevented. Thus, both system dependencies and effects on associated systems are minimized.

