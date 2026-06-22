package com.parabank;

public class MainTest {

    public static void main(String[] args)
            throws InterruptedException {

        // Registration Scenarios
        RegistrationTest.validRegistration();

        RegistrationTest.missingFieldsRegistration();

        RegistrationTest.existingUsernameRegistration();

        Thread.sleep(5000);



        // Login Scenarios
        LoginTest.validLogin();

        LoginTest.invalidPasswordLogin();

        LoginTest.emptyUsernameOrPasswordLogin();

        Thread.sleep(5000);



        // Transfer Funds Scenarios
        TransferFundsTest.transferFunds();

        TransferFundsTest.invalidAmountTransfer();

        Thread.sleep(5000);



        // Bill Pay Scenarios
        BillPayTest.validBillPay();

        BillPayTest.invalidAccountNumberBillPay();

        Thread.sleep(5000);



        System.out.println("All Test Scenarios Executed");
    }
}