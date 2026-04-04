package com.example.productservice.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/*
    How Spring know that BaseModel is just a super/parent class used for mapping in its child/subclass
    to avoid redundant code and no need to create/insert this table in database?

    We can use @MappedSuperClass to avoid this.

    @Id is used to make it Primary key
 */
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    private long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean isDeleted;
}
