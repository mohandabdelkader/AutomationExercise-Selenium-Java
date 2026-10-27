package data.register;

public class InValidRegisterDataModel {
    private String testCase;
    private String Gender;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private String ConfirmPassword;
    private String expectedMessage;

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
