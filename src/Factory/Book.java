package Factory;

public abstract class Book {
    protected String title;

    protected String author;

    protected int price;

    protected String summary;

    public abstract String displayInfo();
 
    public String displayTitle(){
        return this.title;
    }

    public String displayAuthor(){
        return this.author;
    }

    public int displayPrice(){
        return this.price;
    }

    public String displaySummary(){
        return this.summary;
    }
}




