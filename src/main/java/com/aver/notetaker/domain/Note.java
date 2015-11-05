package com.aver.notetaker.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.aver.util.CustomJsonDateDeserializer;
import com.aver.util.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Document(collection = "notes")
public class Note implements Serializable {

    private static final long serialVersionUID = -312511371620173348L;

    @Id
    private String id;

    private String message;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "MM/dd/yyyy")
    private Date createdOnDate;

    public Note() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonSerialize(using = CustomJsonDateSerializer.class)
    public Date getCreatedOnDate() {
        return createdOnDate;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setCreatedOnDate(Date createdOnDate) {
        this.createdOnDate = createdOnDate;
    }

}
