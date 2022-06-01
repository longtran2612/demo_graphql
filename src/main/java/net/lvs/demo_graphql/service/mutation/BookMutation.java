package net.lvs.demo_graphql.service.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import net.lvs.demo_graphql.model.Author;
import net.lvs.demo_graphql.model.Book;
import net.lvs.demo_graphql.repository.AuthorRepository;
import net.lvs.demo_graphql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookMutation implements GraphQLMutationResolver {

    @Autowired
    private BookRepository bookRepository;

    public BookMutation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book newBook(String name, Integer page, String authorId) {
        Book book = new Book();
        book.setAuthor(new Author());
        book.setName(name);
        book.setPage(page != null ? page : 0);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(String id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBook(Integer pageCount, String id) {
        Optional<Book> opt = bookRepository.findById(id);
        if (opt.isPresent()) {
            Book book = opt.get();
            book.setPage(pageCount);
            bookRepository.save(book);
            return book;
        }
        return null;
    }
}