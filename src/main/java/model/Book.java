package model;

public class Book{

    private String name;
    private String author;
    private boolean isReedRoomOnly;

    public Book(String name, String author) {
        this(name, author, false);
    }

    public Book(String name, String author, boolean isReedRoomOnly) {
        this.name = name;
        this.author = author;
        this.isReedRoomOnly = isReedRoomOnly;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isReedRoomOnly() {
        return isReedRoomOnly;
    }

    public void setReedRoomOnly(boolean reedRoomOnly) {
        isReedRoomOnly = reedRoomOnly;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Book)){
            return false;
        }
        Book bookObj = (Book) obj;
        return  name.equals(bookObj.getName()) && author.equals(bookObj.getAuthor())
                && isReedRoomOnly == bookObj.isReedRoomOnly();
    }

    @Override
    public int hashCode(){
        return 13 + 17*name.hashCode() + 17* author.hashCode() + (isReedRoomOnly ? 1 : 0);
    }

}
