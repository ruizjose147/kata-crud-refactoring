package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.entity.Todo;
import co.com.sofka.crud.mapper.TodoMapper;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        if(dto.getName()==null){
            throw new DuplicateKeyException("Es necesario poner un nombre a la tarea");
        }
        Todo todo = mapper.dtoToTodo(dto);
        return mapper.todoToDto(repository.save(todo));
    }

    public void delete(Long id){
        Todo todo = new Todo();
        todo = mapper.dtoToTodo(get(id));
        repository.delete(todo);
    }

    public TodoDto get(Long id){
        Optional<Todo> optionalListTodo = repository.findById(id);
        if(optionalListTodo.isEmpty()){
            throw new NoSuchElementException("No existe una tarea con el id " + id);
        }
        return  mapper.todoToDto(optionalListTodo.get());
    }
}
