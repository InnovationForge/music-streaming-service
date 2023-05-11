# Music Streaming Service (MSS)
`music-streaming-service` is a music streaming rest api that allows users to search and stream music tracks from various artists and genres.

## MSS Solution Design overview
Developing a Music Streaming Service using Spring Boot and WebFlux can be an exciting project. Here's an outline of the steps you can follow to implement the desired features:
* **Data Modeling**: Design the data models for your application. This might include entities like User, Song, Playlist, and any other related entities you may need.
* **Data Storage**: Choose a database solution to store your data. Spring Boot supports various databases, such as MySQL, PostgreSQL, or MongoDB. Select the one that suits your needs and configure the data source.
* **User Management**: Implement user registration, login, and authentication functionality. You can use Spring Security to handle user authentication and authorization.
* **Song Management**: Create endpoints to handle song-related operations, such as uploading songs, retrieving song information, and searching for songs based on various criteria (title, artist, genre, etc.). You may also need to handle audio file storage and streaming.
* **Playlist Management**: Develop endpoints to manage playlists. Users should be able to create, update, and delete playlists. Additionally, implement functionality to add or remove songs from playlists.
* **Audio Streaming**: Implement a streaming mechanism to allow users to listen to music on demand. You can utilize WebFlux to handle the asynchronous streaming of audio files.
* **Integration with External APIs**: Consider integrating your service with external APIs to enrich the user experience. For example, you can integrate with an API that provides song recommendations or album artwork.
* **User Interface**: Develop a user interface to interact with your Music Streaming Service. You can create a web-based frontend using HTML, CSS, and JavaScript frameworks like React or Angular. Alternatively, you can create a mobile app using frameworks like React Native or Flutter.
* **Testing**: Write unit tests and integration tests to ensure the functionality of your application. You can use tools like JUnit and Mockito for testing in Spring Boot.
* **Deployment**: Deploy your application to a hosting platform or a cloud provider. You can use services like AWS, Google Cloud, or Heroku for deployment.

Remember to follow best practices, such as modularizing your code, handling error cases, and securing your endpoints.

This outline should give you a starting point for developing your Music Streaming Service. Feel free to explore Spring Boot and WebFlux documentation for detailed implementation guidance. Good luck with your project!

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

