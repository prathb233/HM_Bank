USE HMBank;

-- 1. Find the average account balance for all customers:
SELECT
    C.first_name,
    A.account_id,
    -- AVG(A.Balance)
    AVG(CASE 
			WHEN T.transaction_type = 'deposit' THEN T.amount 
            ELSE -T.amount 
		END) AS avg_balance
FROM Customers C
JOIN Accounts A ON C.customer_id = A.customer_id
JOIN Transactions T ON A.account_id = T.account_id
GROUP BY C.first_name, A.account_id;


-- 2. Retrieve the top 10 highest account balances:
SELECT customer_id, account_id, balance
FROM Accounts
ORDER BY balance DESC
LIMIT 10;


-- 3. Calculate Total Deposits for All Customers in a specific date:
SELECT account_id, SUM(amount) AS total_deposits, transaction_date
FROM Transactions T 
WHERE T.transaction_type = 'deposit' AND T.transaction_date = '2022-01-05'
GROUP BY account_id;


-- 4. Find the Oldest and Newest Customers:
SELECT MIN(DOB) AS oldest_customer_dob, MAX(DOB) AS newest_customer_dob
FROM Customers;
/* confused abt this Qs whether to find Oldest and Youngest customer based their age or account creation */


-- 5. Retrieve transaction details along with the account type:
SELECT T.*, A.account_type
FROM Transactions T
JOIN Accounts A ON T.account_id = A.account_id;


-- 6. Get a list of customers along with their account details:
SELECT CONCAT(first_name, ' ', last_name) AS Customers, A.*
FROM Customers C
JOIN Accounts A ON C.customer_id = A.customer_id;

-- 7. Retrieve transaction details along with customer information for a specific account:
SELECT C.*, T.*
FROM Customers C
JOIN Accounts A ON C.customer_id = A.customer_id
JOIN Transactions T ON A.account_id = T.account_id
WHERE T.account_id = 101;

-- 8. Identify customers who have more than one account:
SELECT C.customer_id, C.first_name, COUNT(account_id) AS num_accounts
FROM Customers C
JOIN Accounts A ON C.customer_id = A.customer_id
GROUP BY C.customer_id
HAVING num_accounts > 1;


-- 9. Calculate the difference in transaction amounts between deposits and withdrawals:
SELECT * FROM Accounts; -- this Qs triggered me to dynamically update balance column👨✌


-- 10. Calculate the average daily balance for each account over a specified period:
SELECT
    A.account_id,
    MONTHNAME(transaction_date) AS month,
    YEAR(transaction_date) AS year,
    AVG(balance / DAY(LAST_DAY(transaction_date))) AS avg_daily_balance
FROM
    Accounts A
JOIN
    Transactions T ON A.account_id = T.account_id
GROUP BY
    account_id, year, month;


-- 11. Calculate the total balance for each account type:
/* 
I think its same as Q.9) total balance = total deposits - total withdrawals
*/


-- 12. Identify accounts with the highest number of transactions order by descending order:
SELECT account_id, COUNT(transaction_id) AS total_txns -- better way is COUNT(*) since its counting all the Txns only 
FROM Transactions 
GROUP BY account_id
ORDER BY total_txns DESC;


-- 13. List customers with high aggregate account balances, along with their account types:
SELECT C.customer_id, C.first_name, C.last_name, A.account_type, A.balance AS aggregate_balance
FROM Customers C
JOIN Accounts A ON C.customer_id = A.customer_id
ORDER BY aggregate_balance DESC;


-- 14. Identify and list duplicate transactions based on transaction amount, date, and account:
SELECT account_id, amount AS duplicate_txn, transaction_date, COUNT(*) AS total_count
FROM Transactions T 
GROUP BY account_id, amount, transaction_date
HAVING COUNT(*) > 1;

-- Find 3rd highest balance account
SELECT account_id, balance
FROM Accounts
ORDER BY balance DESC
LIMIT 1 OFFSET 2;
/* 
	LIMIT 1 sets the no. of rows to be displayed as 1
    OFFSET clause is used to skip the first two rows.
*/

