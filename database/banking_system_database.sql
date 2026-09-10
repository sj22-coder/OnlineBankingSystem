CREATE DATABASE banking_system;
SHOW DATABASES;
USE banking_system;
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    full_name VARCHAR(100) NOT NULL
);
CREATE TABLE accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    account_number VARCHAR(20) UNIQUE,
    balance DECIMAL(12,2) DEFAULT 0.00,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
CREATE TABLE transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    transaction_type VARCHAR(20),
    amount DECIMAL(12,2),
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);
SHOW tables;
SELECT * FROM users;
DELETE FROM users
WHERE username = 'john2';
UPDATE users
SET user_id = 2
WHERE user_id = 3;
UPDATE accounts
SET account_id = 3
WHERE account_id = 6;
SELECT * FROM accounts;
SELECT * FROM transactions;
INSERT INTO accounts(user_id, account_number, balance)
VALUES (1, 'ACC1002', 0);