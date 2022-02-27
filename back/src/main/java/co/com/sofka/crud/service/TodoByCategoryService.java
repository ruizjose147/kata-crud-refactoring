package co.com.sofka.crud.service;
import co.com.sofka.crud.dto.TodoByCategoryDto;
import co.com.sofka.crud.entity.TodoByCategory;
import co.com.sofka.crud.mapper.TodoByCategoryMapper;
import co.com.sofka.crud.repository.TodoByCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TodoByCategoryService {
    @Autowired
    private TodoByCategoryRepository categoryRepository;

    @Autowired
    private TodoByCategoryMapper mapper;

    public Iterable<TodoByCategoryDto> list(){
        List<TodoByCategoryDto> dtos =new ArrayList<>();
        categoryRepository.findAll().forEach(todoByCategory -> dtos.add(mapper.mapperCategoryDto(todoByCategory)));
        return dtos;
    }

    public TodoByCategoryDto save(TodoByCategoryDto dto){
        if(dto.getNameList()==null){
            throw new DuplicateKeyException("Es necesario poner un nombre a la categoria");
        }
        TodoByCategory categoryTodo = mapper.mapperTodo(dto);
        return mapper.mapperCategoryDto(categoryRepository.save(categoryTodo));
    }

    public void delete(Long id){
        TodoByCategory todoByCategory = new TodoByCategory();
        todoByCategory = mapper.mapperTodo(get(id));
        categoryRepository.delete(todoByCategory);
    }

    public TodoByCategoryDto get(Long id){
        Optional<TodoByCategory> optionalListTodo = categoryRepository.findById(id);
        if(optionalListTodo.isEmpty()){
            throw new NoSuchElementException("No existe una categoria con el id " + id);
        }
        return  mapper.mapperCategoryDto(optionalListTodo.get());
    }
}
