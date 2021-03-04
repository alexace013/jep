package reader;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyboardReader {

    @SneakyThrows
    public static int getCount(String entityName) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(String.format("Please, input count of %s:", entityName));
        String count;
        if ((count = bufferedReader.readLine()) != null) {
            System.out.println(String.format("%s count: %s", entityName, count));
        }
        return Integer.parseInt(count);
    }
}