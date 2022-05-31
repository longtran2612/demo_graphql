//package net.lvs.demo_graphql.api;
//
//import net.lvs.demo_graphql.model.Book;
//import net.lvs.demo_graphql.repository.BookRepository;
//import org.springframework.data.mongodb.repository.Query;
//import org.springframework.stereotype.Controller;
//
//import java.util.List;
//
//@Controller
//public class BookAPI {
//
//    private BookRepository bookRepository;
//
//    public BookAPI(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//
//    @SchemaMapping(typeName = "Query", value = "allBooks")
//    public List<Book> findAll() {
//        return bookRepository.findAll();
//    }
//
//    @QueryMapping
//    public Book findOne(@Argument Integer id) {
//        return bookRepository.findOne(id);
//    }
//}