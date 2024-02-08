/*
While working on:
-- To achieve a dynamically updated balance column in the Accounts table whenever a new transaction is added
=> I learnt:

1. TRIGGER Syntax:
	In MySQL, a trigger is a set of instructions that are automatically executed (or "triggered")
	in response to the specific events on a particular table.
	The basic syntax for creating a trigger is as follows:
		CREATE TRIGGER trigger_name
		[BEFORE | AFTER] [INSERT | UPDATE | DELETE]
		ON table_name
		FOR EACH ROW
		BEGIN
			-- Trigger body (SQL statements)
		END;
			
	In MySQL triggers, when you use the AFTER INSERT ON table_name syntax, 
	the NEW keyword allows you to access the values of the columns being inserted into the specified table. 
	In this case, you are using the trigger AFTER INSERT ON Transactions, so NEW refers to the newly inserted row in the Transactions table.

2. DELIMITER:
	The DELIMITER command is used to change the default statement delimiter (;) in MySQL.
	Since the trigger definition includes semicolons (;) inside the BEGIN ... END block, 
	changing the delimiter is necessary to avoid confusion with the semicolons used within the trigger body.
	The DELIMITER // command sets the delimiter to //, and DELIMITER ; resets it back to the default.

3. FOR EACH ROW:
	This clause indicates that the trigger should be executed once for each row affected by the triggering event.
	In this case, the trigger is designed to execute for each row inserted into the Transactions table.

4. BEGIN ... END:
	The BEGIN ... END block contains the body of the trigger, which consists of one or more SQL statements.
	These statements define the actions to be taken when the trigger is fired.

5. COALESCE Function:
	The COALESCE function is used to handle NULL values. It returns the first non-NULL expression among its arguments.
		Syntax: COALESCE(expression1, expression2, ...)
	In this context, it ensures that if there are no deposits or withdrawals for an account, the result is 0 instead of NULL.
	But I have not used it coz I felt the table was working fine even w/o it.

6. CASE:
	The CASE statement is used for conditional logic in SQL.
	Syntax:
		CASE
			WHEN condition1 THEN result1
			WHEN condition2 THEN result2
			...
			ELSE else_result
		END
	It allows you to perform different actions based on specified conditions.
	In this query, it's used to conditionally sum amounts based on the transaction type ('deposit' or 'withdrawal').

7. EXISTS: 
	This is a logical operator that returns a boolean value, in our case it checks whether the specified subquery returns any rows 
	in the Transactions table (T) where the account_id matches the account_id in the Accounts table (A).
	If the subquery returns at least one row, EXISTS evaluates to TRUE; otherwise, it evaluates to FALSE.
*/


/*
While working on (Task 3):

-- 8. Identify customers who have more than one account:
=> I learnt:
The combination of GROUP BY and HAVING in SQL is used to group rows that have the same values in specified columns 
(specified in the GROUP BY clause) and apply a condition to filter the groups based on aggregate functions (specified in the HAVING clause). 
This combination is particularly useful when you want to filter the results based on aggregate values.

Here's a breakdown of how GROUP BY and HAVING work together:
GROUP BY:
	The GROUP BY clause is used to group rows based on the values in one or more columns.
	When you use GROUP BY, you are essentially creating subsets (groups) of rows where the values in the specified columns are the same.
    
    The GROUP BY function not only helps in displaying the results but also plays a critical role in aggregation. 
    When you use GROUP BY in combination with aggregate functions like AVG(), 
    it instructs the database to group the rows based on the specified columns and then calculate the aggregate function for each group separately.
    
     "invalid use of group function," typically occurs when there is an attempt to use an aggregate function, 
     such as SUM, within another aggregate function like AVG, without proper grouping. 
     This kind of error often arises when there's confusion about where the grouping should occur in complex queries.
     If you were to use SUM within AVG without proper grouping, it might lead to the error of invalid use of GROUP fxn. 
     The key is to ensure that aggregate functions are used appropriately 
     and that the columns in the SELECT clause are either part of the GROUP BY clause or are used within an aggregate function.

HAVING:
	The HAVING clause is used to filter the grouped rows based on aggregate functions (like COUNT, SUM, AVG, etc.).
	It acts as a filter for the groups created by the GROUP BY clause.

-- 10. Calculate the average daily balance for each account over a specified period:
=> I learnt:
	LAST_DAY() function is used to get the last dates of the month for a given date or date/time expression.
    Eg: 
		SELECT LAST_DAY('2022-01-15');
        Output: '2022-01-31'
        
    DAY() function is used to extract the day of the month from a given date or date/time expression.
	Eg:
		SELECT DAY('2022-01-15');
        Output: 15
*/

/*
While working on (Task 4):

-- 1. Retrieve the customer(s) with the highest account balance:
=> I learnt: (Rules of WHERE clause)
	That you cannot directly use the result of an aggregate function like MAX() in the WHERE clause to filter rows based on that aggregate value. 
    The WHERE clause is typically used for conditions involving individual column values, 
    and using an aggregate function directly within it can lead to unexpected results.
    
	In SQL, aggregate functions like MAX() are meant for use in the SELECT clause or HAVING clause, 
    where they operate on sets of values. For filtering based on aggregate results, you often need to use subqueries or other constructs.

	Also you cannot directly use an alias defined in the SELECT clause within the WHERE clause. 
    The logical processing order of SQL queries specifies that the WHERE clause is evaluated before the SELECT clause, 
    and aliases defined in the SELECT clause are not visible to the WHERE clause.
    
-- 3. Retrieve accounts with transactions whose amounts exceed the average transaction amount:
=> I learnt:
	CROSS JOIN operation in SQL combines each row from the first table with every row from the second table, 
    resulting in a Cartesian product of the two tables. 
    It does not require any specific condition for matching rows, and it simply combines all rows from both tables.
    
    
-- 6. Retrieve transactions for accounts with the lowest balance:
=> I learnt:
	We cant use aggregator fxns like SUM, MIN, MAX, AVG etc inside the GROUP BY, WHERE etc clauses
    and we have to use them inside a sub-query
    
-- 7. Identify customers who have accounts of multiple types:
=> I learnt:
	Error Code: 1055. Expression #3 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'hmbank.A.account_id' 
    which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
    
    due to the strict mode of the MySQL server, which enforces the "ONLY_FULL_GROUP_BY" mode
	In this mode, all columns in the SELECT clause must either be aggregated (using functions like COUNT, SUM, AVG, etc.) 
    or included in the GROUP BY clause.
    
    To resolve this issue, we can either disable the "ONLY_FULL_GROUP_BY" mode for your session or adjust the query to comply with the strict mode.
    To disable strict mode, SET SESSION sql_mode = '';
    
-- 8. Calculate the percentage of each account type out of the total number of accounts:
=> I learnt:
	conditions in GROUP BY or any other clause doesnt appply to Subqueries



