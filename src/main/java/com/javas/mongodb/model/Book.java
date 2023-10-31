package com.javas.mongodb.model;

import com.mongodb.lang.NonNull;
import lombok.*;
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
    @NonNull
    private int id;
    private String bookName;
    private String author;
    private String email;
    private String description;


}
