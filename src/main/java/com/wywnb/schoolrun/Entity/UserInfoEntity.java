package com.wywnb.schoolrun.Entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "web_users")
@Data
public class UserInfoEntity implements Serializable {

    @Id
    private ObjectId id;
    private String username;
    private String password;
    private String email;
    private Boolean isAdmin;
}
