package data.loginDataModel;

import java.util.List;

public class LoginModel {
    private ValidDataLogin validDataLogin;
    private List<InvalidDataLogin> invalidDataLogin;

    public ValidDataLogin getValidData() {
        return validDataLogin;
    }

    public List<InvalidDataLogin> getInvalidData() {
        return invalidDataLogin;
    }
}