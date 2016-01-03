package lib.models;

import java.util.Date;

public class TodoModel {
    private String title;
    private Boolean completed;
    private int id;
    private Date createdDate;

    public void setTitle(String content) {
        this.title = content;
    }

    public String getTitle() {
        return title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
