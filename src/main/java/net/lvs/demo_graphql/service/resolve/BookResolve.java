package net.lvs.demo_graphql.service.resolve;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import net.lvs.demo_graphql.model.Author;
import net.lvs.demo_graphql.model.Book;
import net.lvs.demo_graphql.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class BookResolve implements GraphQLQueryResolver {

    private AuthorRepository authorRepository;

    public BookResolve(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor()
                        .getId())
                .orElseThrow(null);
    }
}