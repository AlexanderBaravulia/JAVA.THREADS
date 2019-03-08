package model;

import org.apache.log4j.Logger;

import java.util.Random;

public class Visitor implements Runnable {
    private String visitorID;
    private Book book;
    private ReadingRoom readingRoom;
    private static Logger logger = Logger.getLogger(Visitor.class);

    public Visitor(String visitorID, ReadingRoom readingRoom) {
        this.visitorID = visitorID;
        this.readingRoom = readingRoom;
    }

    public String getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(String visitorID) {
        this.visitorID = visitorID;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void run() {
        readingRoom.takeSeat(this);
        logger.info("Visitor " + visitorID + " is reading  " + book.toString());
        try {
            Thread.sleep((new Random().nextInt(10000)));
            logger.info("Visitor " + visitorID + " has finished reading.");
            readingRoom.leaveSeat(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
