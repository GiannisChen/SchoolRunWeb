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
    private String permission;
    private String invitation_code;

    public UserInfoEntity() {}
    public UserInfoEntity(String username, String password) {
        this.username = username;
        this.password = password;
        this.permission = "user";
    }
}
