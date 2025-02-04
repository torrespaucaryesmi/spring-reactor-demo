use hotel_db;
-- Insert data into customer table only if it is empty
INSERT INTO customer (name, email, phone_number)
SELECT 'John Doe', 'john.doe@example.com', '123-456-7890'
WHERE NOT EXISTS (SELECT 1 FROM customer)
UNION ALL
SELECT 'Jane Smith', 'jane.smith@example.com', '098-765-4321'
WHERE NOT EXISTS (SELECT 1 FROM customer);

-- Insert data into room table only if it is empty
INSERT INTO room (room_number, type, price)
SELECT '101', 'Single', 100.00
WHERE NOT EXISTS (SELECT 1 FROM room)
UNION ALL
SELECT '102', 'Double', 150.00
WHERE NOT EXISTS (SELECT 1 FROM room)
UNION ALL
SELECT '103', 'Suite', 250.00
WHERE NOT EXISTS (SELECT 1 FROM room);