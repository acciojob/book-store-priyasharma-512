package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    List<Book> bookList;

    static int id = 0;
    public BookRepository(){
        bookList = new ArrayList();
    }

    public Book save(Book book){
        id++;
        book.setId(id);
        bookList.add(book);
        return book;
    }

    public Book findBookById(int id){
        for (Book b:bookList)
        {
            if(b.getId() == id)
                return b;
        }
        return null;
    }

    public List<Book> findAll(){
        return bookList;
    }

    public void deleteBookById(int id){
        for (Book b: bookList) {
            if(b.getId() == id) {
                bookList.remove(b);
                break;
            }
        }
    }

    public void deleteAll(){
        bookList.clear();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> authorList = new ArrayList<>();
        for (Book b: bookList) {
            if(b.getAuthor().equals(author))
                authorList.add(b);
        }
        return authorList;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> genreList = new ArrayList<>();
        for (Book b: bookList) {
            if(b.getGenre().equals(genre))
                genreList.add(b);
        }
        return genreList;
    }
}
