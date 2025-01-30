DROP database hotel_db;

CREATE DATABASE hotel_db;

USE hotel_db;

CREATE TABLE customer (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE room (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      room_number VARCHAR(10) NOT NULL UNIQUE,
                      type VARCHAR(50) NOT NULL,
                      price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE booking (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         customer_id BIGINT NOT NULL,
                         room_id BIGINT NOT NULL,
                         booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (customer_id) REFERENCES customer(id),
                         FOREIGN KEY (room_id) REFERENCES room(id)
);

CREATE TABLE payment (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         booking_id BIGINT NOT NULL,
                         amount DECIMAL(10, 2) NOT NULL,
                         payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (booking_id) REFERENCES booking(id)
);