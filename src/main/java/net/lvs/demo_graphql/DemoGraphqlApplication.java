package net.lvs.demo_graphql;

import net.lvs.demo_graphql.repository.AuthorRepository;
import net.lvs.demo_graphql.repository.BookRepository;
import net.lvs.demo_graphql.service.mutation.BookMutation;
import net.lvs.demo_graphql.service.query.BookQuery;
import net.lvs.demo_graphql.service.resolve.BookResolve;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class DemoGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGraphqlApplication.class, args);
    }

}
