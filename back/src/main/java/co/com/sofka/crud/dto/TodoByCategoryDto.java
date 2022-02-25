package co.com.sofka.crud.dto;

import co.com.sofka.crud.entity.Todo;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TodoByCategoryDto {

    public Long id;
    public String name;
    public boolean completed;
    private List<Todo> todos = new ArrayList<>();

}
