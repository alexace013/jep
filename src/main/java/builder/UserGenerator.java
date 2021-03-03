package builder;

import com.github.javafaker.Faker;
import entity.User;
import exeption.UserGeneratorException;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.json.JSONArray;
import org.json.JSONObject;

@Log4j
public class UserGenerator implements IJSONGenerator {

    private JSONArray jsonArray;

    @SneakyThrows
    public void buildJson(int userCount) {
        if (userCount <= 0) {
            UserGeneratorException userGeneratorException = new UserGeneratorException(
                    "Incorrect user count value!");
            log.error(userGeneratorException.getMessage());
            throw userGeneratorException;
        } else {
            jsonArray = new JSONArray();
            for (int count = userCount; count > 0; count--) {
                JSONObject jsonObject = new JSONObject();
                User user = new User();
                Faker faker = new Faker();
                user.setUsername(faker.name().username());
                user.setPassword(faker.finance().bic());
                user.setCountry(faker.address().country());
                user.setCity(faker.address().city());
                jsonObject.put(User.UserAttribute.USERNAME.getAttr(), user.getUsername());
                jsonObject.put(User.UserAttribute.PASSWORD.getAttr(), user.getPassword());
                jsonObject.put(User.UserAttribute.COUNTRY.getAttr(), user.getCountry());
                jsonObject.put(User.UserAttribute.CITY.getAttr(), user.getCity());
                log.info(jsonObject.toString());
                jsonArray.put(jsonObject);
            }
        }
    }

    @SneakyThrows
    public String printJSON() {
        if (jsonArray == null) {
            UserGeneratorException userGeneratorException = new UserGeneratorException(
                    "JSONArray is null!");
            log.error(userGeneratorException.getMessage());
            throw userGeneratorException;
        }
        return jsonArray.toString(jsonArray.length());
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }
}