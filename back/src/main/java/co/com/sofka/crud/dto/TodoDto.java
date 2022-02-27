package co.com.sofka.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDto {

    private Long id;
    private String name;
    private boolean completed;
    private Long groupListId;

}
