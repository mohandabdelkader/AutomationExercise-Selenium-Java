package reader;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadDataFromJson {

    public <T> T readJsonFile(String filePath, Class<T> tClass) throws FileNotFoundException {
        try {
            FileReader reader = new FileReader(filePath);
            return new Gson().fromJson(reader, tClass);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
