package net.lvs.demo_graphql.service.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import net.lvs.demo_graphql.model.Author;
import net.lvs.demo_graphql.repository.AuthorRepository;
import net.lvs.demo_graphql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthorMutation implements GraphQLMutationResolver {


    @Autowired
    private AuthorRepository authorRepository;


    public Author createAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorRepository.save(author);
        return author;
    }


    public boolean deleteAuthor(String id) {
        authorRepository.deleteById(id);
        return true;
    }

    public Author updateAuthor(String firstName, String lastName, String id) {
        Optional<Author> opt = authorRepository.findById(id);
        if (opt.isPresent()) {
            Author author = opt.get();
            author.setFirstName(firstName);
            author.setLastName(lastName);
            authorRepository.save(author);
            return author;
        }
        return null;

    }
}