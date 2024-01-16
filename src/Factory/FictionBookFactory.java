package Factory;

public class FictionBookFactory implements BookFactory {
    @Override
    public Book createBook(String title, int price, String summary) {
        return new FictionBook(title, price, summary);
    }
}