package com.hexaware.bankmgmtsys.Task_14.dao;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class AccountDAOTest {

    private AccountDAO accDAO;

    @Before
    public void setUp() {
        // Initialize the AccountDAO or use a mocking framework to create a mock instance.
        accDAO = new AccountDAO();
        // Additional setup if needed, like initializing a database connection or mock data.
    }

    @Test
    public void testGetAccountBalance() {
        // Assuming you have a test account number and its corresponding expected balance.
        int testAccountNumber = 101; // Replace with your test account number
        double expectedBalance = 4105.0; // Replace with your expected balance

        // Call the method to get the actual balance.
        double actualBalance = accDAO.getAccountBalance(testAccountNumber);

        // Assert that the actual balance matches the expected balance.
        assertEquals(expectedBalance, actualBalance, 0.001); // 0.001 is the delta for double comparison.
    }
}
