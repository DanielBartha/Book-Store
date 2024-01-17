package Factory;

public class NonFictionBookFactory implements BookFactory {
    @Override
    public Book createBook(Object[] bookInfo) {
        String title = (String)bookInfo[0];
        String author =(String)bookInfo[1];
        int price = (int)bookInfo[2];
        String summary=(String)bookInfo[3];
        return new NonFictionBook(title, author, price, summary);
    }
}