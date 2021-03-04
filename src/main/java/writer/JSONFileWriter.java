package writer;

import builder.UserGenerator;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.json.JSONArray;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Log4j
public class JSONFileWriter {

    private static final String TARGET_DIR_PATH = "target/";
    private static final String RESOURCES_DIR_PATH = "src/test/resources/";
    private static final String FILE_NAME = "data.json";

    private static void writeFileIntoDirectory(String dirPath,
                                               String fileName,
                                               JSONArray jsonArray) throws IOException {
        File file = new File(dirPath + fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(jsonArray.toString(jsonArray.length()));
        bufferedWriter.close();
    }

    @SneakyThrows
    public static void writeJSONFileIntoTargetDirectory(JSONArray jsonArray) {
        writeFileIntoDirectory(TARGET_DIR_PATH, FILE_NAME, jsonArray);
    }

    @SneakyThrows
    public static void writeJSONFileIntoResourcesDirectory(JSONArray jsonArray) {
        writeFileIntoDirectory(RESOURCES_DIR_PATH, FILE_NAME, jsonArray);
    }

    public static void main(String[] args) {
        UserGenerator userGenerator = new UserGenerator();
        userGenerator.buildJsonWithData(5);
        System.out.println("\n" + userGenerator.printJSON());
        writeJSONFileIntoTargetDirectory(userGenerator.getJsonArray());
        writeJSONFileIntoResourcesDirectory(userGenerator.getJsonArray());
    }
}