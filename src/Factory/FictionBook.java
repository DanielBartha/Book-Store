package Factory;

public class FictionBook extends Book {
    public FictionBook(String title, int price, String summary) {
        this.title = title;
        this.price = price;
        this.summary = summary;
    }

    @Override
    public String displayInfo() {
        return "Fiction Book Info";
    }
}
