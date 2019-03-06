package model;

//  Читатель может брать на руки и в читальный зал несколько книг.

import model.types.ServiceType;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Visitor  {

    private String visitorID;
    private List<Book> books;
    private static Logger logger = Logger.getLogger(Visitor.class);

    public Visitor(String visitorID) {
        logger.info("Create new Visitor " + visitorID);
        this.books = new ArrayList<Book>();
        this.visitorID = visitorID;
    }

    public String getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(String visitorID) {
        this.visitorID = visitorID;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
