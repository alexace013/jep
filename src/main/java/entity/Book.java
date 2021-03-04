package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Book {

    private String author;
    private String genre;
    private String publisher;
    private String title;

    @Getter
    @AllArgsConstructor
    public enum BookAttribute {
        AUTHOR("author"), GENRE("genre"),
        PUBLISHER("publisher"), TITLE("title");

        private String attr;
    }
}