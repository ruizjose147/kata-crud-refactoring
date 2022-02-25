package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoByCategoryDto;
import co.com.sofka.crud.entity.TodoByCategory;
import co.com.sofka.crud.mapper.TodoByCategoryMapper;
import co.com.sofka.crud.repository.TodoByCategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        TodoByCategory todoByCategory = new TodoByCategory();
        todoByCategory = mapper.mapperTodo(dto);
        return mapper.mapperCategoryDto(categoryRepository.save(todoByCategory));
    }

    public void delete(Long id){
        TodoByCategory todoByCategory = new TodoByCategory();
        todoByCategory = mapper.mapperTodo(get(id));
        categoryRepository.delete(todoByCategory);
    }

    public TodoByCategoryDto get(Long id){
        return categoryRepository.findById(id).map(todoByCategory -> mapper.mapperCategoryDto(todoByCategory)).orElseThrow();
    }
}
