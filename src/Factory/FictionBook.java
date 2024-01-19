package Factory;


public class FictionBook extends Book {
    public FictionBook(String title, String author, int price, String summary) {
        this.title = title;
        this.type = "Fiction Book";
        this.author = author;
        this.price = price;
        this.summary = summary;
    }
}
