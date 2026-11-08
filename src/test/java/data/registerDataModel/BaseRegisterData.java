package data.registerDataModel;

public class BaseRegisterData {
    protected String testCase;
    protected String Gender;
    protected String FirstName;
    protected String LastName;
    protected String Email;
    protected String Password;
    protected String ConfirmPassword;
    protected String expectedMessage;

    public String getTestCase() {
        return testCase;
    }

    public String getGender() {
        return Gender;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public String getExpectedMessage() {
        return expectedMessage;
    }
}