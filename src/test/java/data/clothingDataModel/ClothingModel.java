package data.clothingDataModel;

import java.util.List;

public class ClothingModel {
    private List<ValidDataClothing> validDataClothing;
    private List<InValidDataClothing> invalidDataClothing;

    public List<ValidDataClothing> getValidDataClothing() {
        return validDataClothing;
    }

    public List<InValidDataClothing> getInvalidDataClothing() {
        return invalidDataClothing;
    }
}
