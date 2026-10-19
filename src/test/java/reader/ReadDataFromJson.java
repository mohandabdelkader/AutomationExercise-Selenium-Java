package reader;

import com.google.gson.Gson;
import data.DataModel;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadDataFromJson {

    public DataModel readJsonFile() throws FileNotFoundException {
        FileReader reader = new FileReader("src/data/testData.json");
        return new Gson().fromJson(reader, DataModel.class);
    }
}
