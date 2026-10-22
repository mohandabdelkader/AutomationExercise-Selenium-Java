package reader;

import com.google.gson.Gson;
import data.DataModel;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadDataFromJson {

    public DataModel readJsonFile() throws FileNotFoundException {
        try {
            FileReader reader = new FileReader("src/data/testData.json");
           return new Gson().fromJson(reader, DataModel.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
