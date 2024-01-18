package Factory;

public abstract class Book {
    protected String title;

    protected String author;

    protected int price;

    protected String summary;

    public abstract String displayInfo();
 
    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getPrice(){
        return this.price;
    }

    public String getSummary(){
        return this.summary;
    }
}




