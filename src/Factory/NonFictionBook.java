package Factory;

public class NonFictionBook extends Book {
    public NonFictionBook(String title,String author, int price, String summary) {
        this.title = title;
        this.price = price;
        this.summary = summary;
    }
    @Override
    public String displayInfo() {
        return "Non-Fiction Book Info";
    }
}