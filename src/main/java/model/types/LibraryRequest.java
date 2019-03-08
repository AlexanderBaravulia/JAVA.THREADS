package model.types;

import model.Book;
import model.Library;
import model.Visitor;
import org.apache.log4j.Logger;

public class LibraryRequest extends Thread{

    private static int requestIdCounter = 0;
    private int requestId;
    private Visitor visitor;
    private ServiceType serviceType;
    private Book book;
    private Library library;
    private static Logger logger = Logger.getLogger(LibraryRequest.class);

    public LibraryRequest(Library library, Visitor visitor, Book book, ServiceType serviceType) {
        this.library = library;
        this.visitor = visitor;
        this.book = book;
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

    @Override
    public void run() {
        logger.info("Processing of Library request #" + requestId);
        if (library.giveBook(book, visitor)) {
            visitor.setBook(book);
            if (book.isReedRoomOnly()) {
                new Thread(visitor).start();
            }
        } else {
            logger.error("Couldn't satisfy your request");
        }
    }
}
