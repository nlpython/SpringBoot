package com.yruns;

import com.yruns.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

/**
 * MongoDBTest
 */
@SpringBootTest
public class MongoDBTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void testSave() {
        Book book = new Book(1, "science");
        mongoTemplate.save(book);
    }

    @Test
    void testFind() {
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all);
    }
}
