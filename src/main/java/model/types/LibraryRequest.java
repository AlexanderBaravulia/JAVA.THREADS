package model.types;

import model.Book;
import model.Library;
import model.Visitor;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LibraryRequest extends Thread{

    private static int requestIdCounter = 0;
    private int requestId;
    private Visitor visitor;
    private ServiceType serviceType;
    private List<Book> bookList;
    private Library library;
    private ReentrantLock lock = new ReentrantLock();
    private static Logger logger = Logger.getLogger(LibraryRequest.class);

    public LibraryRequest(Library library, Visitor visitor, List<Book> bookList, ServiceType serviceType) {
        this.library = library;
        this.visitor = visitor;
        this.bookList = bookList;
        this.serviceType = serviceType;
        this.requestId = requestIdCounter;
        requestIdCounter++;
        logger.info("New Library request #" + requestId);
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public void run() {
        logger.info("Processing of Library request #" + requestId);
        try {
            if (lock.tryLock(10, TimeUnit.SECONDS)) {
                if (library.giveBookList(bookList)) {
                    visitor.setBooks(bookList);
                } else {
                    logger.error("Couldn't satisfy your request");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
