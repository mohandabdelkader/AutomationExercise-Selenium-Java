package data.register;

import java.util.List;

public class RegisterDataModel {
    private ValidRegisterDataModel validData;
    private List<InValidRegisterDataModel> invalidData;

    public ValidRegisterDataModel getValidData() {
        return validData;
    }

    public List<InValidRegisterDataModel> getInvalidData() {
        return invalidData;
    }
}
