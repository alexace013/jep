package entity;

import lombok.*;

@Getter
@Setter
@ToString
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