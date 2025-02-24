# Hotel Service Microservice

## Overview
This project is a Spring Boot microservice that connects to a MySQL database using Docker. It also includes a web client that connects to the Nationalize.io API to predict the nationality of a given name.

## Prerequisites
- Java 11
- Maven 3.6+
- Docker
- Postman (for testing the API)

## Running the Project

### Step 1: Start the MySQL Database
1. Navigate to the `hotel-service-ms/src/main/resources/mysql-docker` directory.
2. Run the following command to start the MySQL database using Docker Compose:
   ```sh
   docker-compose up -d