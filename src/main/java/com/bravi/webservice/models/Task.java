package com.bravi.webservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private int id;

    @Column()
    private String title;

    @Column()
    private String description;

    @Column()
    private LocalDateTime doInAt;

    @Column()
    private LocalDateTime doneAt;

    @Column
    private Integer spendTime;

    public Task(String title, String description, LocalDateTime doInAt)
    {
        this.title = title;
        this.description = description;
        this.doInAt = doInAt;
    }

    public Task() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDoInAt() {
        return doInAt;
    }

    public void setDoInAt(LocalDateTime doInAt) {
        this.doInAt = doInAt;
    }

    public LocalDateTime getDoneAt() {
        return doneAt;
    }

    public void setDoneAt(LocalDateTime doneAt) {
        this.doneAt = doneAt;
    }

    public int getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(int spendTime) {
        this.spendTime = spendTime;
    }
}
