package com.app.todo.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Todo {
    private int id;
    private String title;
    private String content;
    private String status;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date currDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date deadLineDate;

    public Todo() {
    }

    public Todo(int id, String title, String content, String status, Date currDate, Date deadLineDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.currDate = currDate;
        this.deadLineDate = deadLineDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getCurrDate() {
        return currDate;
    }

    public void setCurrDate(Date currDate) {
        this.currDate = currDate;
    }

    public Date getDeadLineDate() {
        return deadLineDate;
    }

    public void setDeadLineDate(Date deadLineDate) {
        this.deadLineDate = deadLineDate;
    }

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", currDate=" + currDate +
                ", deadLineDate=" + deadLineDate +
                '}';
    }
}
