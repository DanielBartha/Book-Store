package Factory;

public class NonFictionBook extends Book {
    public NonFictionBook(String title,String author, int price, String summary) {
      this.title = title;
        this.type = "Non fiction Book";
        this.author = author;
        this.price = price;
        this.summary = summary;
    }
}