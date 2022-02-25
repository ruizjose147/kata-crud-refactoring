package co.com.sofka.crud.dto;

import co.com.sofka.crud.entity.Todo;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class TodoDto {

    private Long id;
    private String name;
    private boolean completed;
    private Long groupListId;



}
