package com.javas.mongodb.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="books")
public class Book implements Serializable {

    @Id
    private ObjectId id;
    private String bookName;
    private String author;
    private String email;
    private String description;

    @JsonGetter("_id")
    public String getObjectIdAsString() {
        return id.toString();
    }

}
