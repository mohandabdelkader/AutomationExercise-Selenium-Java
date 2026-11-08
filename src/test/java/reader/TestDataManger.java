package reader;

import data.clothingDataModel.ClothingModel;
import data.configDataModel.ConfigModel;
import data.loginDataModel.LoginModel;
import data.registerDataModel.RegisterModel;
import data.shoesDataModel.ShoesModel;

public class TestDataManger {
    private static final ReadDataFromJson jsonReader = new ReadDataFromJson();
    private static final String LOGIN_PATH = "src/data/loginData.json";
    private static final String REGISTER_PATH = "src/data/registerData.json";
    private static final String SHOES_PATH = "src/data/shoesData.json";
    private static final String CLOTHING_PATH = "src/data/clothingData.json";
    private static final String Config_PATH = "src/data/configData.json";

    private static <T> T getData(String filePath, Class<T> tClass) {
        try {
            return jsonReader.readJsonFile(filePath, tClass);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load JSON data from: " + filePath, e);
        }
    }
    // Getter

    public static LoginModel getLoginData() {
        return getData(LOGIN_PATH, LoginModel.class);
    }

    public static RegisterModel getRegisterData() {
        return getData(REGISTER_PATH, RegisterModel.class);
    }

    public static ShoesModel getShoesData() {
        return getData(SHOES_PATH, ShoesModel.class);
    }

    public static ClothingModel getClothingData() {
        return getData(CLOTHING_PATH, ClothingModel.class);
    }

    public static ConfigModel getConfigData() {
        return getData(Config_PATH, ConfigModel.class);
    }
}
