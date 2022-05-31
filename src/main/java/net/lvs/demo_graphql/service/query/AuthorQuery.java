package net.lvs.demo_graphql.service.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import net.lvs.demo_graphql.model.Author;
import net.lvs.demo_graphql.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class AuthorQuery implements GraphQLQueryResolver {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorQuery(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return authorRepository.count();
    }

}