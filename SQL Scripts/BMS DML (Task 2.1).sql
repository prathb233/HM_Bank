USE HMBank;

-- Customers Table
INSERT INTO Customers (first_name, last_name, DOB, email, phone_number, address)
VALUES

('Bhupendra', 'Jogi', '1985-05-15', 'naam.bataaiye@email.com', '9876543210', 'Prayagraj, Bihar'),
('Aayein!', 'Baigan', '1988-09-20', 'baigan.aayein!@email.com', '8765432109', 'Kashi Lane, Delhi'),
('Mogambo', 'Khush Hua', '1970-01-01', 'mogambo.khushhua@email.com', '7654321098', 'Action Road, Lucknow'),
('Cazual', 'Singh', '1985-08-22', 'likhne_ka_tareeka.thoda@cazualhai.com', '8765472109', '456 Drishti IAS, OLD Rajendra Nagar, Delhi'),
('Geet', 'Kaur', '1992-03-08', 'geet.kaur@email.com', '6543210987', 'Adventure Avenue, Amritsar'),
('Kaalen', 'Bhaiyya', '1982-07-25', 'munna.patel@email.com', '5432109876', 'Mirzapur, Bihar'),
('Munna', 'Bhaiyya', '1965-11-12', 'baburao.apte@email.com', '4321098765', 'Comedy Road, Mumbai');

-- Accounts Table
INSERT INTO Accounts (customer_id, account_type)
VALUES
(1, 'current');


-- Transactions Table
INSERT INTO Transactions (account_id, transaction_type, amount, transaction_date)
VALUES
(101, 'Deposit', 500.00, '2022-01-05');



