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
('Munna', 'Bhaiyya', '1965-11-12', 'baburao.apte@email.com', '4321098765', 'Comedy Road, Mumbai'),
('Aarav', 'Verma', '1990-03-15', 'aarav.verma@email.com', '9876543219', '123 ABC Street, City'),
('Arjun', 'Gupta', '1998-02-10', 'arjun.gupta@email.com', '7654821098', '789 PQR Street, City'),
('Isha', 'Sharma', '1982-11-30', 'isha.sharma@email.com', '6543200987', '321 LMN Street, City'),
('Rohan', 'Patel', '1995-04-18', 'rohan.patel@email.com', '5432809876', '654 GHI Street, City'),
('Anaya', 'Joshi', '1989-07-25', 'anaya.joshi@email.com', '4321998765', '987 DEF Street, City'),
('Vihaan', 'Chopra', '1993-09-12', 'vihaan.chopra@email.com', '3210987654', '234 KLM Street, City'),
('Aanya', 'Shah', '1980-01-05', 'aanya.shah@email.com', '2109876543', '876 MNO Street, City'),
('Advait', 'Kumar', '1997-06-28', 'advait.kumar@email.com', '1098765432', '543 JKL Street, City'),
('Aisha', 'Singh', '1987-12-08', 'aisha.singh@email.com', '9876543220', '765 RST Street, City');


-- Accounts Table
INSERT INTO Accounts (customer_id, account_type)
VALUES
(12, 'current');


-- Transactions Table
INSERT INTO Transactions (account_id, transaction_type, amount, transaction_date)
VALUES
(101, 'IMPS tnf credit', 5.00, '2022-01-05');



