package co.com.sofka.crud.dto;

import co.com.sofka.crud.entity.Todo;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
//@Getter
//@Setter
public class TodoDto {

    private Long id;
    private String name;
    private boolean completed;
    private Long groupListId;

    public Long getId() {
        return id;
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

    public Long getGroupListId() {
        return groupListId;
    }

    public void setGroupListId(Long groupListId) {
        this.groupListId = groupListId;
    }
}
