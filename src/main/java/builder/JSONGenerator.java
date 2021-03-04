package builder;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.json.JSONArray;
import org.json.JSONObject;

@Log4j
public abstract class JSONGenerator {

    protected JSONArray jsonArray = new JSONArray();
    protected JSONObject jsonObject;
    protected Faker faker = new Faker();

    abstract void buildJsonWithData(int entityCount);

    @SneakyThrows
    public String printJSON() {
        checkJSONArray();
        return jsonArray.toString(jsonArray.length());
    }

    @SneakyThrows
    public JSONArray getJsonArray() {
        checkJSONArray();
        return jsonArray;
    }

    private void checkJSONArray() throws Exception {
        if (jsonArray == null) {
            Exception exception = new Exception(
                    "JSONArray is null!");
            log.error(exception.getMessage());
            throw exception;
        }
    }
}