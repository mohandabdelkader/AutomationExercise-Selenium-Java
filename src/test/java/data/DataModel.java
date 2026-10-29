package data;

import data.login.LoginDataModel;
import data.register.RegisterDataModel;
import data.shoesItem.ShoesCustomizationDataModel;

public class DataModel {
    private String URL;
    private LoginDataModel login;
    private RegisterDataModel register;
    private ShoesCustomizationDataModel shoesCustomization;

    // Getter
    public String getUrl() {
        return URL;
    }

    // Login Getter
    public LoginDataModel getLogin() {
        return login;
    }

    // register Getter
    public RegisterDataModel getRegister() {
        return register;
    }

    // shoes option Getter
    public ShoesCustomizationDataModel getShoesCustomization() {
        return shoesCustomization;
    }


}

