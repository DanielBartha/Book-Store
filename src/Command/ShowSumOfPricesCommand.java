package Command;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import Factory.Book;

public class ShowSumOfPricesCommand implements ShoppingCartCommand{
    private List<Book> bookList = new ArrayList<>();
    private int numberOfBooksWrapped=0;

    public void setBookList(List<Book> books){
    this.bookList = books;
    }


    @Override
    public void execute() {
        if(bookList.size() != 0){
            int bookPrice = getPrice();
            System.out.println(MessageFormat.format("Sum of prices: {0}€", bookPrice));
        }
    }

    public int getPrice(){
        int bookPrice =0;
        for(Book book :bookList){
            bookPrice +=book.getPrice();
        }
        return bookPrice +(numberOfBooksWrapped*10) ;
    }
    public void setNumberOfBooksWrapped(int amount){
        this.numberOfBooksWrapped= amount;
    }
    
}
