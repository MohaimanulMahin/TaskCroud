package com.example.taskcrudapp.modal;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String task_name;
    private String task_description;
    private String task_comment;
    private String task_status;

    public Task(int id, String task_name, String task_description, String task_comment, String task_status) {
        this.id = id;
        this.task_name = task_name;
        this.task_description = task_description;
        this.task_comment = task_comment;
        this.task_status = task_status;
    }
    public Task( String task_name, String task_description, String task_comment, String task_status) {

        this.task_name = task_name;
        this.task_description = task_description;
        this.task_comment = task_comment;
        this.task_status = task_status;
    }

    public Task() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public String getTask_comment() {
        return task_comment;
    }

    public void setTask_comment(String task_comment) {
        this.task_comment = task_comment;
    }

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }
}
