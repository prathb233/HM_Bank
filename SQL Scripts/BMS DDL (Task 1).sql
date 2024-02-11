CREATE DATABASE HMBank;
USE HMBank;
-- DROP DATABASE hmbank;

-- Create the Customers table
CREATE TABLE Customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    DOB DATE,
    email VARCHAR(100),
    phone_number VARCHAR(20),
    address VARCHAR(255)
    -- UNIQUE KEY unique_customer (phone_number)
) AUTO_INCREMENT = 01;


-- Create the Accounts table
CREATE TABLE Accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    account_type VARCHAR(20),
    balance DECIMAL(10, 2),
    UNIQUE KEY unique_account (customer_id, account_type),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
) AUTO_INCREMENT = 101;


-- Create the Transactions table
CREATE TABLE Transactions (
	transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    transaction_type VARCHAR(20),
    amount DECIMAL(10, 2),
    transaction_date DATE,
    FOREIGN KEY (account_id) REFERENCES Accounts(account_id)
) AUTO_INCREMENT = 1001;


-- Create a trigger to dynamically update the Account Balance
DELIMITER //
CREATE TRIGGER update_balance
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    DECLARE current_balance DECIMAL(10, 2);
    
    -- Get the current balance of the account
    SELECT COALESCE(balance, 0) INTO current_balance 
    FROM Accounts A
	WHERE A.account_id = NEW.account_id; -- NEW.account_id indicates the newly inserted account_id in the Txns table
    
    -- Update the balance based on the transaction type
    IF NEW.transaction_type LIKE '%deposit' or NEW.transaction_type LIKE '%credit'THEN
        SET current_balance = current_balance + NEW.amount; -- NEW.amount indicates the newly inserted amount in the Txns table
    ELSE
        SET current_balance = current_balance - NEW.amount;
    END IF;
    
    -- Update the balance in the Accounts table
    UPDATE Accounts SET balance = current_balance WHERE account_id = NEW.account_id;
END;
//
DELIMITER ;


