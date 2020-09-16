package com.wywnb.schoolrun.Entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Calendar;
import java.util.Date;

@Document(collection = "notice")
@Data
public class NoticeEntity {

    @Id
    private ObjectId id;
    private String title;
    private String content;
    private Date creatTime;
    private Boolean isValid;
    private String author;

    public NoticeEntity() {}

    public NoticeEntity(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.author = username;
        this.creatTime = Calendar.getInstance().getTime();
        this.isValid = true;
    }
}
