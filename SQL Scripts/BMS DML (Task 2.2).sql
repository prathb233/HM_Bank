USE HMBank;

-- 1. Retrieve name, account type, and email of all customers:
SELECT first_name, last_name, account_type, email
FROM Customers
JOIN Accounts ON Customers.customer_id = Accounts.customer_id;


-- 2. List all transactions corresponding to a customer:
SELECT  T.*
FROM Transactions T
WHERE T.account_id = 101;


-- 3. Increase the balance of a specific account by a certain amount:
UPDATE Accounts
SET balance = balance + 2000
WHERE account_id = 113;
 

-- 4. Combine first and last names of customers as a full_name:
SELECT CONCAT(first_name, ' ', last_name) AS full_name
FROM Customers;

-- 5. Remove accounts with a balance of zero where the account type is savings:
DELETE FROM Accounts
WHERE balance IS NULL OR 0 AND account_type = 'savings';

-- 6. Find customers living in a specific city:
/* 
	So first of all the assignment didnt mention to create a City column specifically 
	rather it mentioned an Address column, so basically we need to filter city from the address column
    OR we just put city names in Address column that is the Qs????
*/
SELECT *
FROM Customers
WHERE city = 'YourCity'; 


-- 7. Get the account balance for a specific account:
SELECT 
	CONCAT(first_name, ' ', last_name) AS Name, 
    account_id, balance -- I cud hv just displayed balance of rqrd acc_id but i am डेढ़ शाणा  😐
FROM Accounts
JOIN Customers ON Customers.customer_id = Accounts.customer_id
WHERE account_id = 101; 

-- 8. List all current accounts with a balance greater than $1,000:
SELECT account_id, balance
FROM Accounts
WHERE account_type = 'current' AND balance > 1000;

-- 9. Retrieve all transactions for a specific account:
SELECT *
FROM Transactions
WHERE account_id = 101; 

-- 10. Calculate the interest accrued on savings accounts based on a given interest rate:
SELECT 
	account_id, 
	balance * (7.5 / 100) AS interest_accrued
FROM Accounts
WHERE account_type = 'savings';

-- 11. Identify accounts where the balance is less than a specified overdraft limit:
SELECT account_id, balance
FROM Accounts
WHERE balance < -500;

-- 12. Find customers not living in a specific city:
SELECT *
FROM Customers
WHERE city != 'ExcludedCity';




