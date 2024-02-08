USE HMBank;

-- 1. Retrieve the customer(s) with the highest account balance:    
SELECT C.customer_id, C.first_name
FROM Customers C
WHERE C.customer_id IN (
	SELECT customer_id
    FROM Accounts 
    WHERE balance = (
		SELECT MAX(balance)
        FROM Accounts
        )
	);
		

-- Alt Code (displaying account info too):
SELECT 
	A.account_id, 
    A.balance, 
    C.customer_id 
FROM Accounts A
JOIN Customers C ON A.customer_id = C.customer_id
WHERE A.balance = (
	SELECT MAX(balance) 
    FROM Accounts
    );


-- 2. Calculate the average account balance for customers who have more than one account:    
SELECT
    C.customer_id,
    AVG(A.balance) AS avg_account_balance
FROM Customers C
JOIN Accounts A ON C.customer_id = A.customer_id
GROUP BY C.customer_id
HAVING COUNT(A.account_id) > 1;

-- Alt Code (Using Sub-query):
SELECT 
	customer_id, 
	AVG(balance) AS avg_account_balance
FROM Accounts 
WHERE customer_id IN (
	SELECT customer_id 
    FROM Accounts
    GROUP BY customer_id
    HAVING COUNT(account_id) > 1
    );


-- 3. Retrieve accounts with transactions whose amounts exceed the average transaction amount:
SELECT
    A.account_id,
    T.transaction_id,
    T.amount,
    overall_avg_txn_amount
FROM Accounts A
JOIN Transactions T ON A.account_id = T.account_id
JOIN (
	SELECT AVG(amount) AS overall_avg_txn_amount
    FROM Transactions
	) overall_avg_table
WHERE T.amount > overall_avg_table.overall_avg_txn_amount;


-- Alt Code
SELECT
    A.account_id,
    T.transaction_id,
    T.amount,
    (SELECT AVG(amount) FROM Transactions) AS overall_avg_txn_amount
FROM Accounts A
JOIN Transactions T ON A.account_id = T.account_id
WHERE T.amount > (SELECT AVG(amount) FROM Transactions);


-- 4. Identify customers who have no recorded transactions:
-- 5. Calculate the total balance of accounts with no recorded transactions:
SELECT
    C.customer_id,    
    CONCAT(C.first_name, ' ', C.last_name) AS Name,
    A.account_id,
    A.account_type,
    A.balance
FROM Customers C
LEFT JOIN Accounts A ON C.customer_id = A.customer_id
LEFT JOIN Transactions T ON A.account_id = T.account_id
WHERE T.transaction_id IS NULL;


-- 6. Retrieve transactions for accounts with the lowest balance:
SELECT T.*
FROM Transactions T
WHERE account_id IN (
	SELECT account_id
    FROM Accounts 
    WHERE balance = (
		SELECT MIN(balance)
        FROM Accounts
        )
	); -- Using JOINS the length of code can be reduced but nvm
    
    
-- 7. Identify customers who have accounts of multiple types:
SELECT 
	C.customer_id,
	C.first_name,
	A.account_id,
	A.account_type
FROM Customers C
JOIN Accounts A ON C.customer_id = A.customer_id
WHERE C.customer_id IN (
    SELECT customer_id
    FROM Accounts
    GROUP BY customer_id
    HAVING COUNT(account_type) > 1
);
-- SET SESSION sql_mode = '';


-- 8. Calculate the percentage of each account type out of the total number of accounts:
SELECT
    account_type,
    COUNT(*) AS account_count,
    (COUNT(*) / (SELECT COUNT(*) FROM Accounts)) * 100 AS percentage
FROM Accounts
GROUP BY account_type;


-- 9. Retrieve all transactions for a customer with a given customer_id:
SELECT T.*
FROM Transactions T
WHERE account_id IN (
    SELECT account_id
    FROM Accounts
    WHERE customer_id = 1 -- this logic gives set of acc_ids where c_id = 1 in this case (101, 116, 159)
);


-- 10. Calculate the total balance for each account type, including a subquery within the SELECT clause:
SELECT 
	account_type,
    SUM(balance)
FROM Accounts
WHERE account_type IN (
	SELECT account_type
    FROM Accounts
    )
GROUP BY account_type;

-- Alt Code:
SELECT
	account_type,
    (SELECT 
		SUM(balance) 
        FROM Accounts 
        WHERE account_type = A.account_type) AS total_balance 
    -- here alias A differentiates b/w the columns selected in main query and subquery
FROM Accounts A
GROUP BY account_type;


