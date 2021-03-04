package builder;

import com.github.javafaker.Faker;
import entity.Book;
import entity.User;
import exeption.BookGeneratorException;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.json.JSONObject;

@Log4j
public class BookGenerator extends JSONGenerator {

    @SneakyThrows
    @Override
    public void buildJsonWithData(int bookCount) {
        if (bookCount <= 0) {
            BookGeneratorException bookGeneratorException = new BookGeneratorException(
                    "Incorrect book count value!");
            log.error(bookGeneratorException.getMessage());
            throw bookGeneratorException;
        } else {
            for (int count = bookCount; count > 0; count--) {
                JSONObject jsonObject = new JSONObject();
                Book book = new Book();
                Faker faker = new Faker();
                book.setAuthor(faker.book().author());
                book.setGenre(faker.book().genre());
                book.setPublisher(faker.book().publisher());
                book.setTitle(faker.book().title());
                jsonObject.put(Book.BookAttribute.AUTHOR.getAttr(), book.getAuthor());
                jsonObject.put(Book.BookAttribute.GENRE.getAttr(), book.getGenre());
                jsonObject.put(Book.BookAttribute.PUBLISHER.getAttr(), book.getPublisher());
                jsonObject.put(Book.BookAttribute.TITLE.getAttr(), book.getTitle());
                log.info(jsonObject.toString());
                jsonArray.put(jsonObject);
            }
        }
    }
}