package writer;

import builder.BookGenerator;
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
    private static final String USER_FILE_NAME = "user_data.json";
    private static final String BOOK_FILE_NAME = "book_data.json";

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
    public static void writeJSONFileIntoTargetDirectory(String fileName, JSONArray jsonArray) {
        writeFileIntoDirectory(TARGET_DIR_PATH, fileName, jsonArray);
    }

    @SneakyThrows
    public static void writeJSONFileIntoResourcesDirectory(String fileName, JSONArray jsonArray) {
        writeFileIntoDirectory(RESOURCES_DIR_PATH, fileName, jsonArray);
    }

    public static void main(String[] args) {
        int count = 5;
        UserGenerator userGenerator = new UserGenerator();
        userGenerator.buildJsonWithData(count);
        System.out.println("\n" + userGenerator.printJSON());
        writeJSONFileIntoTargetDirectory(USER_FILE_NAME, userGenerator.getJsonArray());
        writeJSONFileIntoResourcesDirectory(USER_FILE_NAME, userGenerator.getJsonArray());
        BookGenerator bookGenerator = new BookGenerator();
        bookGenerator.buildJsonWithData(count);
        System.out.println("\n" + bookGenerator.printJSON());
        writeJSONFileIntoTargetDirectory(BOOK_FILE_NAME, bookGenerator.getJsonArray());
        writeJSONFileIntoResourcesDirectory(BOOK_FILE_NAME, bookGenerator.getJsonArray());
    }
}