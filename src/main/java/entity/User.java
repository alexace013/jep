package entity;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private String country;
    private String city;

    @Getter
    @AllArgsConstructor
    public enum UserAttribute {
        USERNAME("username"), PASSWORD("password"),
        COUNTRY("country"), CITY("city");

        private String attr;
    }
}