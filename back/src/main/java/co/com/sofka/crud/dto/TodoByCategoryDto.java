package co.com.sofka.crud.dto;

import co.com.sofka.crud.entity.Todo;
import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.List;

public class TodoByCategoryDto {

    public Long id;
    public String name;
    public boolean completed;
    private List<Todo> todos = new ArrayList<>();

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

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
