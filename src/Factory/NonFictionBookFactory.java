package Factory;

public class NonFictionBookFactory implements BookFactory {
    @Override
    public Book createBook() {
        return new NonFictionBook();
    }
}