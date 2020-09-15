package com.wywnb.schoolrun.Entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class NoticeEntity {

    @Id
    private ObjectId id;
    private String title;
    private String content;
    private Date creatTime;
    private Boolean isValid;
    private String author;
}
