package Proxy;

import java.util.ArrayList;
import java.util.List;

import Factory.Book;
import Factory.BookFactory;
import Factory.FictionBookFactory;

public class BookBasedOnAgeProxy {
    private int age;

    private Object[][] booksInfo = {
            { "The Lord of the Rings", "J.R.R Tolkien", 60,
                    "The Lord of the Rings is the saga of a group of sometimes reluctant heroes who set forth to save their world from consummate evil. Its many worlds and creatures were drawn from Tolkien's extensive knowledge of philology and folklore." },
            { "Wolf Hall", "Hilary Mantel", 50,
                    "Thomas Cromwell proves he is an ambitious man by becoming the chief advisor to King Henry VII." },
            { "The Great Gatsby", "F. Scott Fitzgerald", 64,
                    "Millionaire Jay Gatsby longs to be with the woman he loves, even though she’s married to someone else." },
            { "Moby Dick", "Herman Melville", 35,
                    "Ishmael, a sailor, joins the crew of a whaling ship and sets sail under the direction of a captain who is obsessed with killing the famous whale, Moby Dick." },
            { "One Flew Over the Cuckoo’s", "Ken Kesey", 50,
                    "Chief Bromden narrates the story about how a new patient at the Oregon State mental hospital challenges the powers which aim to keep the patients imprisoned." },
            { "Catch-22", "Joseph Heller", 60,
                    "Stationed in the Mediterranean Sea toward the end of World War II, Yossarian sees no escape from the enemy or from the army he’s a part of." },
    };

    private Object[][] matureBooksInfo = {
            { "American Psycho", "Bret Easton Ellis", 55,
                    "Patrick Bateman appears to have the perfect life, but under the surface lurks a psychopath with a lesson for all of us." },
            { "The Road", "Cormac McCarthy", 40,
                    "A father and son walk through a post-apocalyptic America trying to survive." },
            { "To Kill a Mockingbird", "Harper Lee", 62,
                    "Scout Finch narrates the story of how her father defended a black man in a case where he was falsely accused of raping a white girl." },
            { "Nineteen Eighty-Four", "George Orwell", 70,
                    "In a dystopian society where Big Brother watches everyone, Winston Smith attempts to rebel against the Party in the name of liberty and truth." },
    };

    private List<Book> bookList = new ArrayList<>();
    private BookFactory bookFactory = new FictionBookFactory();

    public void setBooksBasedOnAge() {
        for (Object[] book : booksInfo) {
            this.bookList.add(bookFactory.createBook(book));
        }
        if (age >= 18) {
            for (Object[] book : matureBooksInfo) {
                this.bookList.add(bookFactory.createBook(book));
            }
        }
    }

    public String getInfo() {
        if (this.age >= 18)
            return "You are over 18, you have access to all the books.";
        return "You are underaged, you have limited access to the books.";
    }

    public List<Book> getListOfBooks() {
        return this.bookList;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
