package co.com.sofka.crud.dto;

import co.com.sofka.crud.entity.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoDto {

    private Long id;
    private String name;
    private boolean completed;
    private String groupListId;


    public Long getId() {
        return id;
    }

    public String getGroupListId() {
        return groupListId;
    }

    public void setGroupListId(String groupListId) {
        this.groupListId = groupListId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
