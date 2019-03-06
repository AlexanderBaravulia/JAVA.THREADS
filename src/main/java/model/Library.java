package model;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;


/*
Маленькая библиотека.
Доступны для чтения несколько книг. Одинаковых книг в библиотеке нет.
Некоторые выдаются на руки, некоторые только в читальный зал.
Читатель может брать на руки и в читальный зал несколько книг.
 */
public class Library {

    private List<Book> availableBookList;

    private static Logger logger = Logger.getLogger(Library.class);

    public Library(List<Book> bookList) {
        this.availableBookList = bookList;
    }

    public List<Book> getAvailableBookList() {
        return availableBookList;
    }

    public void setAvailableBookList(List<Book> availableBookList) {
        this.availableBookList = availableBookList;
    }

   public void returnBook(Book book){
        availableBookList.add(book);
   }

   public boolean giveBook(Book book){
        logger.info("Attempt to give the book: " + book.getName());
        if (availableBookList.contains(book)) {
            logger.info("The Book " + book.getName() + "is handed out.");
            return availableBookList.remove(book);
        }
        else {
            logger.error("The Book " + book.getName() + "is not available!");
            return false;
        }
   }

    public boolean giveBookList(List<Book> books) {
        for (Book book : books) {
           return giveBook(book);
        }
        return false;
    }


}
