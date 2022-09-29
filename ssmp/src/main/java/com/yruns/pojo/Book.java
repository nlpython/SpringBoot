package com.yruns.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * Book
 */
@Data
@TableName("tb_book")
public class Book implements Serializable {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String type;
    @TableField(value = "name")
    private String name;
    private String description;

    @TableField(exist = false)
    private String online;

    @TableLogic(value = "0", delval = "1")  // 默认0，表示未删，1表示删除
    private Integer deleted;

    // 乐观锁
    @Version
    private Integer version;
}
