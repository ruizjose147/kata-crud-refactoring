package co.com.sofka.crud.mapper;

import co.com.sofka.crud.dto.TodoByCategoryDto;
import co.com.sofka.crud.entity.TodoByCategory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoByCategoryMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TodoByCategoryDto mapperCategoryDto(TodoByCategory todoByCategory){
        TodoByCategoryDto todoByCategoryDto = new TodoByCategoryDto();
        todoByCategoryDto = modelMapper.map(todoByCategory, TodoByCategoryDto.class);
        return todoByCategoryDto;
    }

    public TodoByCategory mapperTodo(TodoByCategoryDto todoByCategoryDto){
        TodoByCategory todoByCategory = new TodoByCategory();
        todoByCategory = modelMapper.map(todoByCategoryDto, TodoByCategory.class);
        return todoByCategory;
    }
}