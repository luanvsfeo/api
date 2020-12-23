package com.luan.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "challenge")
public class Challenge {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE,
            generator = "challenge_id_seq")
    @SequenceGenerator(
            name = "challenge_id_seq",
            sequenceName = "challenge_id_sequence",
            allocationSize = 1
    )
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SLUG")
    private String slug;

    @Column(name = "CREATED_AT")
    private Date createdAt = new Date();


    public Challenge(){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
