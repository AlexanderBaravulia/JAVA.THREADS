package runner;

import model.Book;
import model.Library;
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
                new Book("Moby Dick", "H. Melville"), new Book("A Clockwork Orange ", "A. Burgess"))));
    }

    public static void main(String[] args) {

        LibraryRequest libraryRequest1 = new LibraryRequest(library, new Visitor("1"), Arrays.asList(new Book("The Da Vinci Code", "D. Brown")), ServiceType.TAKING_HOME);
        LibraryRequest libraryRequest2 = new LibraryRequest(library, new Visitor("2"), Arrays.asList(new Book("A Clockwork Orange", "A. Burgess")), ServiceType.TAKING_HOME);
        libraryRequest1.start();
        libraryRequest2.start();
        libraryRequest1 = new LibraryRequest(library, new Visitor("3"), Arrays.asList(new Book("The Lord of the Rings", "R. Tolkien")), ServiceType.TAKING_HOME);

        LibraryRequest libraryRequest3 =  libraryRequest1;
        libraryRequest1.run();
        libraryRequest3.start();
        libraryRequest1.run();
    }
}
