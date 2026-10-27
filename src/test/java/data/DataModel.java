package data;

import data.login.LoginDataModel;
import data.register.RegisterDataModel;

public class DataModel {
    private String URL;
    private LoginDataModel login;
    private RegisterDataModel register;

    // Getter
    public String getUrl() {
        return URL;
    }
// Login Getter
    public LoginDataModel getLogin() {
        return login;
    }

    public RegisterDataModel getRegister() {
        return register;
    }


}

