package builder;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.json.JSONArray;

@Log4j
public abstract class JSONGenerator {

    protected JSONArray jsonArray;

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