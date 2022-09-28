package com.yruns.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.PrinterLocation;

/**
 * Book
 */
@Component
@Data
@ConfigurationProperties(prefix = "testrandomcase.book")
public class BookCase {
    private int id;
    private String name;
    private String uuid;
    private long publishTime;
}
