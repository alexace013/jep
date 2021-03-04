package builder;

import entity.User;
import exeption.UserGeneratorException;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.json.JSONObject;

@Log4j
public class UserGenerator extends JSONGenerator {

    @SneakyThrows
    @Override
    public void buildJsonWithData(int userCount) {
        if (userCount <= 0) {
            UserGeneratorException userGeneratorException = new UserGeneratorException(
                    "Incorrect user count value!");
            log.error(userGeneratorException.getMessage());
            throw userGeneratorException;
        } else {
            for (int count = userCount; count > 0; count--) {
                User user = new User();
                user.setUsername(faker.name().username());
                user.setPassword(faker.finance().bic());
                user.setCountry(faker.address().country());
                user.setCity(faker.address().city());
                log.info(user.toString());
                jsonObject = new JSONObject();
                jsonObject.put(User.UserAttribute.USERNAME.getAttr(), user.getUsername());
                jsonObject.put(User.UserAttribute.PASSWORD.getAttr(), user.getPassword());
                jsonObject.put(User.UserAttribute.COUNTRY.getAttr(), user.getCountry());
                jsonObject.put(User.UserAttribute.CITY.getAttr(), user.getCity());
                log.info(jsonObject.toString());
                jsonArray.put(jsonObject);
            }
        }
        log.info("User JSON was generated!");
    }
}