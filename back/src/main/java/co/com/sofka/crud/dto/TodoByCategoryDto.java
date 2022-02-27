package co.com.sofka.crud.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TodoByCategoryDto {

    public Long id;
    public String name;
    private List<TodoDto> todos = new ArrayList<>();

}
