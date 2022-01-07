package com.dataprovider;

import com.opencart.utilities.StringFunctions;
import org.testng.annotations.DataProvider;

public class SignUpDataProvider {

    int n = 15;

    @DataProvider(name = "valid data")
    public Object[][] validData() {
        return new Object[][]{
                {"luis", "ferrari", StringFunctions.randomEmail(n), "123456", "password123", "password123"}

        };
    }

    @DataProvider(name = "missing fields")
    public Object[][] missingField() {
        return new Object[][]{
                {null, "ferrari", StringFunctions.randomEmail(n), "123456", "password123", "password123"},
                {"luis", null, StringFunctions.randomEmail(n), "123456", "password123", "password123"},
                {"luis", "ferrari", null, "123456", "password123", "password123"},
                {"luis", "ferrari", StringFunctions.randomEmail(n), null, "password123", "password123"},
                {"luis", "ferrari", StringFunctions.randomEmail(n), "123456", null, "password123"},
                {"luis", "ferrari", StringFunctions.randomEmail(n), "123456", "password123", null},
        };
    }

    @DataProvider(name = "email missing at")
    public Object[][] emailMissingAt() {
        return new Object[][]{
                {"luis", "ferrari", "test_123.com", "123456", "password123", "password123"},
                {"jorge", "torres", "test_456.com", "654321", "password123", "password123"},
                {"carlos", "fernandez", "test_678.com", "987654", "password123", "password123"},
        };
    }

    @DataProvider(name = "email missing dot com")
    public Object[][] emailMissingDotCom() {
        return new Object[][]{
                {"luis", "ferrari", "test_123@gmail", "123456", "password123", "password123"},
                {"jorge", "torres", "test_456@gmail", "654321", "password123", "password123"},
                {"carlos", "fernandez", "test_678@gmail", "987654", "password123", "password123"},
        };
    }

    @DataProvider(name = "different passwords")
    public Object[][] differentPasswords() {
        return new Object[][]{
                {"luis", "ferrari", StringFunctions.randomEmail(n), "123456", "password123", "password"},
                {"jorge", "torres", StringFunctions.randomEmail(n), "654321", "password666", "password123"},
                {"carlos", "fernandez", StringFunctions.randomEmail(n), "987654", "password444", "password123"},
        };
    }

    @DataProvider(name = "edit valid info")
    public Object[][] editValidInfo() {
        return new Object[][]{
                {"jorge", "perez", "12347"},
                {"juan", "torres", "99999"},
                {"camilo", "quispe", "22222"},
        };
    }

    @DataProvider(name="missing at email info edit")
    public Object[][] editEmailMissingAt() {
        return new Object[][]{
                {"test.com"}
        };
    }

    @DataProvider(name="missing dot com info edit")
    public Object[][] editEmailMissingDotCom() {
        return new Object[][]{
                {"test@gmail"}
        };
    }

}