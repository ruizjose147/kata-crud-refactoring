package co.com.sofka.crud.mapper;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.entity.Todo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TodoDto mapperDto(Todo todo){
        TodoDto todoDto = new TodoDto();
        todoDto = modelMapper.map(todo, TodoDto.class);
        return todoDto;
    }

    public Todo mapperTodo(TodoDto todoDto){
        Todo todo = new Todo();
        todo = modelMapper.map(todoDto, Todo.class);
        return todo;
    }
}
