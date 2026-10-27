package data.login;

import java.util.List;

public class LoginDataModel {
    private ValidDataModel validData;
    private List<InvalidDataModel> invalidData;

    public ValidDataModel getValidData() {
        return validData;
    }

    public List<InvalidDataModel> getInvalidData() {
        return invalidData;
    }
}
