package com.yruns.pojo;

import lombok.Data;
import org.springframework.data.annotation.Version;

/**
 * Book
 */
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;

    public Book(int id, String type) {
        this.id = id;
        this.type = type;
    }
}
