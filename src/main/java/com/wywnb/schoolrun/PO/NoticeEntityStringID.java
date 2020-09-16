package com.wywnb.schoolrun.PO;

import com.wywnb.schoolrun.Entity.NoticeEntity;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Calendar;
import java.util.Date;

@Data
public class NoticeEntityStringID {
    @Id
    private String id;
    private String title;
    private String content;
    private Date creatTime;
    private Boolean isValid;
    private String author;

    public NoticeEntityStringID(NoticeEntity notice) {
        this.id = notice.getId().toHexString();
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.author = notice.getAuthor();
        this.creatTime = notice.getCreatTime();
        this.isValid = notice.getIsValid();
    }
}
