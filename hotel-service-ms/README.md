# Hotel Application

This is a Spring Boot application for managing hotel operations, built using Spring Reactor and a MySQL database. The application provides functionalities for managing bookings, customers, rooms, and payments.

## Project Structure

```
hotel-application
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── hotel
│   │   │               ├── HotelApplication.java
│   │   │               ├── controller
│   │   │               │   └── HotelController.java
│   │   │               ├── model
│   │   │               │   ├── Booking.java
│   │   │               │   ├── Customer.java
│   │   │               │   ├── Room.java
│   │   │               │   └── Payment.java
│   │   │               ├── repository
│   │   │               │   ├── BookingRepository.java
│   │   │               │   ├── CustomerRepository.java
│   │   │               │   ├── RoomRepository.java
│   │   │               │   └── PaymentRepository.java
│   │   │               └── service
│   │   │                   ├── BookingService.java
│   │   │                   ├── CustomerService.java
│   │   │                   ├── RoomService.java
│   │   │                   └── PaymentService.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── schema.sql
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── hotel
│                       └── HotelApplicationTests.java
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd hotel-application
   ```

2. **Configure the database:**
   Update the `src/main/resources/application.properties` file with your MySQL database connection details.

3. **Run the application:**
   Use the following command to start the application:
   ```
   ./mvnw spring-boot:run
   ```

4. **Access the API:**
   The application exposes RESTful endpoints for managing hotel operations. You can use tools like Postman or curl to interact with the API.

## Dependencies

- Spring Boot 3.4.2
- Spring Data R2DBC
- Lombok
- MySQL Driver

## License

This project is licensed under the MIT License.