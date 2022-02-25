package co.com.sofka.crud.mapper;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.entity.Todo;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public class TodoMapper {

    @Autowired
    private ModelMapper mapper;

  public TodoDto todoToDto(Todo todo){
      TodoDto dto = new TodoDto();
      dto = mapper.map(todo, TodoDto.class);
      return dto;
  }

    public Todo dtoToTodo(TodoDto dto){
        Todo todo = mapper.map(dto, Todo.class);
        return todo;
    }

}
