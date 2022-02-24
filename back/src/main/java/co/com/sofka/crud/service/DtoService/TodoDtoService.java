package co.com.sofka.crud.service.DtoService;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.entity.Todo;
import co.com.sofka.crud.repository.TodoRepository;
import co.com.sofka.crud.repository.dtoRepository.TodoDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoDtoService {

    @Autowired
    private TodoDtoRepository repositoryDto;

    public Iterable<TodoDto> list(){
        return repositoryDto.findAll();
    }

    public TodoDto save(TodoDto todoDto){
        return repositoryDto.save(todoDto);
    }

    public void delete(Long id){
        repositoryDto.delete(get(id));
    }

    public TodoDto get(Long id){
        return repositoryDto.findById(id).orElseThrow();
    }
}
