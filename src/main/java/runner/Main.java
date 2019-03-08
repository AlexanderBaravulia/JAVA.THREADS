package runner;

import model.Book;
import model.Library;
import model.ReadingRoom;
import model.Visitor;
import model.types.LibraryRequest;
import model.types.ServiceType;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static Library library;
    static {
        library = new Library(new ArrayList(Arrays.asList(new Book("The Lord of the Rings", "R. Tolkien"),
                new Book("1984", "G. Orwell", true),
                new Book("The Hobbit", "R. Tolkien", true),
                new Book("War and Peace", "L. Tolstoy", true),
                new Book("Crime and Punishment", "F. Dostoevsky", true),
                new Book("Anna Karenina","L. Tolstoy"), new Book("The Da Vinci Code", "D. Brown"),
                new Book("Moby Dick", "H. Melville"), new Book("A Clockwork Orange", "A. Burgess"))));
    }

    public static void main(String[] args) {

        ReadingRoom readingRoom = new ReadingRoom(2);
        LibraryRequest libraryRequest1 = new LibraryRequest(library, new Visitor("0", readingRoom), new Book("The Da Vinci Code", "D. Brown", true), ServiceType.TAKING_HOME);
        LibraryRequest libraryRequest2 = new LibraryRequest(library, new Visitor("1", readingRoom), new Book("A Clockwork Orange", "A. Burgess", true), ServiceType.READING_ROOM);
        libraryRequest1.start();
        libraryRequest2.start();

        LibraryRequest libraryRequest3 = new LibraryRequest(library, new Visitor("2",readingRoom), new Book("Crime and Punishment", "F. Dostoevsky", true), ServiceType.READING_ROOM);
        LibraryRequest libraryRequest4 = new LibraryRequest(library, new Visitor("3",readingRoom), new Book("The Lord of the Rings", "R. Tolkien", true), ServiceType.TAKING_HOME);
        libraryRequest4.start();
        libraryRequest3.start();
        libraryRequest1.run();
    }
}
