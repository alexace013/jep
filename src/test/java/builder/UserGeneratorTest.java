package builder;

import exeption.UserGeneratorException;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserGeneratorTest {

    private UserGenerator userGenerator;

    @Test
    @DisplayName("Throw UserGeneratorException when printJSON as JSONArray is null")
    public void printJSON_EXCEPTION() {
        userGenerator = new UserGenerator();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThatThrownBy(() -> userGenerator.printJSON())
                .isInstanceOf(Exception.class)
                .hasMessage("JSONArray is null!");
        softly.assertAll();
    }

    @Test
    @DisplayName("Throw UserGeneratorException when build JSON with length is 0")
    public void buildJSON_with_0_length() {
        userGenerator = new UserGenerator();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThatThrownBy(() -> userGenerator.buildJsonWithData(0))
                .isInstanceOf(UserGeneratorException.class)
                .hasMessage("Incorrect user count value!");
        softly.assertAll();
    }

    @Test
    @DisplayName("Throw UserGeneratorException when build JSON with length is -1")
    public void buildJSON_with_minus_1_length() {
        userGenerator = new UserGenerator();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThatThrownBy(() -> userGenerator.buildJsonWithData(-1))
                .isInstanceOf(UserGeneratorException.class)
                .hasMessage("Incorrect user count value!");
        softly.assertAll();
    }
}