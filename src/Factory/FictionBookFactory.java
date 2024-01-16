package Factory;

public class FictionBookFactory implements BookFactory {
    @Override
    public Book createBook() {
        return new FictionBook();
    }
}