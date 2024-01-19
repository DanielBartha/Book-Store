package Factory;

public abstract class Book {
    protected String title;

    protected String author;

    protected int price;

    protected String summary;

    protected Boolean isWrapped = false;

    public abstract String displayInfo();

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPrice() {
        return this.price;
    }

    public String getSummary() {
        return this.summary;
    }

    public Boolean getIsWrapped() {
        return this.isWrapped;
    }

    public void setIsWrapped(Boolean bool) {
        this.isWrapped = bool;
    }
}
