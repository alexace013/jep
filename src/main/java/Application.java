import builder.BookGenerator;
import builder.UserGenerator;
import reader.KeyboardReader;
import writer.JSONFileWriter;

import java.io.IOException;

import static writer.JSONFileWriter.FileName.BOOK_FILE_NAME;
import static writer.JSONFileWriter.FileName.USER_FILE_NAME;

public class Application {

    public static void main(String[] args) throws IOException {
        UserGenerator userGenerator = new UserGenerator();
        userGenerator.buildJsonWithData(KeyboardReader.getCount("users"));
        System.out.println("\n" + userGenerator.printJSON());
        JSONFileWriter.writeJSONFileIntoTargetDirectory(
                USER_FILE_NAME.getFileName(), userGenerator.getJsonArray())
        ;
        JSONFileWriter.writeJSONFileIntoResourcesDirectory(
                USER_FILE_NAME.getFileName(), userGenerator.getJsonArray()
        );

        BookGenerator bookGenerator = new BookGenerator();
        bookGenerator.buildJsonWithData(KeyboardReader.getCount("books"));
        System.out.println("\n" + bookGenerator.printJSON());
        JSONFileWriter.writeJSONFileIntoTargetDirectory(
                BOOK_FILE_NAME.getFileName(), bookGenerator.getJsonArray()
        );
        JSONFileWriter.writeJSONFileIntoResourcesDirectory(
                BOOK_FILE_NAME.getFileName(), bookGenerator.getJsonArray()
        );
    }
}