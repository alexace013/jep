package writer;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
        log.info(String.format("File was saved successfully:\ndirectory: %s\nfile name: %s",
                dirPath, fileName)
        );
    }

    @SneakyThrows
    public static void writeJSONFileIntoTargetDirectory(String fileName, JSONArray jsonArray) {
        writeFileIntoDirectory(TARGET_DIR_PATH, fileName, jsonArray);
    }

    @SneakyThrows
    public static void writeJSONFileIntoResourcesDirectory(String fileName, JSONArray jsonArray) {
        writeFileIntoDirectory(RESOURCES_DIR_PATH, fileName, jsonArray);
    }

    @Getter
    @AllArgsConstructor
    public enum FileName {
        USER_FILE_NAME("user_data.json"),
        BOOK_FILE_NAME("book_data.json");

        private String fileName;
    }
}