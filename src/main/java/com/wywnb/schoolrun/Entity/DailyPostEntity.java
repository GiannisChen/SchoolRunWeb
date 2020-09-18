package com.wywnb.schoolrun.Entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "dailypost")
@Data
public class DailyPostEntity {
    @Id
    private ObjectId id;
    private String open_id;
    private String student_id;
    @Field("post_time")
    private Long postTime;
    private Double latitude;
    private Double longitude;
    private String ip;
}
