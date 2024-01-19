package Factory;

import java.text.MessageFormat;

public abstract class Book {
    protected String title;

    protected String author;

    protected int price;

    protected String type;

    protected String summary;

    public String displayInfo() {
        return MessageFormat.format("Book title: {0}\nType: {1}\nAuthor: {2}\nPrice: {3}€\nSummary: {4}" , this.title,this.type,this.author,this.price,this.summary);
    }
 
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

    public String getType(){
        return this.type;
    }

    public void setPrice(int price){
        this.price = price;
    }
}




