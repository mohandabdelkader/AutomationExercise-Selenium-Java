package data.registerDataModel;

import java.util.List;

public class RegisterModel {
    private ValidDataRegister validDataRegister;
    private List<InvalidDataRegister> invalidDataRegister;

    public ValidDataRegister getValidDataRegister() {
        return validDataRegister;
    }

    public List<InvalidDataRegister> getInvalidDataRegister() {
        return invalidDataRegister;
    }
}
