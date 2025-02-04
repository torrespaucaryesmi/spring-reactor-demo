# My Maven Project

This project is a Spring Boot application that connects to the Nationalize API using WebClient and Spring Reactor. It is built with Java 17 and uses Lombok for reducing boilerplate code.

## Project Structure

```
ationalize-service
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           ├── MyApplication.java
│   │   │           ├── config
│   │   │           │   └── WebClientConfig.java
│   │   │           ├── service
│   │   │           │   └── NationalizeService.java
│   │   │           └── model
│   │   │               └── NationalizeResponse.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── MyApplicationTests.java
│       └── resources
├── .gitignore
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd my-maven-project
   ```

2. **Build the project:**
   ```
   mvn clean install
   ```

3. **Run the application:**
   ```
   mvn spring-boot:run
   ```

## Usage

To use the Nationalize API, send a request to the appropriate endpoint defined in the `NationalizeService` class. The application will return the predicted nationalities based on the provided name.

## Dependencies

- Spring Boot
- WebClient
- Lombok
- Java 17

## License

This project is licensed under the MIT License.