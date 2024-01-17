package Factory;

import java.text.MessageFormat;

public class FictionBook extends Book {
    public FictionBook(String title, String author, int price, String summary) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.summary = summary;
    }

    @Override
    public String displayInfo() {
        return MessageFormat.format("Book title: {0}\n", this.title);
    }

   
}
