package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.entity.Todo;
import co.com.sofka.crud.mapper.TodoMapper;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    @Autowired
    private TodoMapper mapper;

    public Iterable<TodoDto> list(){
        List<TodoDto> dtos = new ArrayList<>();
        repository.findAll().forEach(todo -> dtos.add(mapper.todoToDto(todo)));
        return dtos;
    }

    public TodoDto save(TodoDto dto){
        Todo todo= new Todo();
        todo = mapper.dtoToTodo(dto);
        return mapper.todoToDto(repository.save(todo));
    }

    public void delete(Long id){
        Todo todo = new Todo();
        todo = mapper.dtoToTodo(get(id));
        repository.delete(todo);
    }

    public TodoDto get(Long id){
        return repository.findById(id).map(todo -> mapper.todoToDto(todo)).orElseThrow();
    }

}
