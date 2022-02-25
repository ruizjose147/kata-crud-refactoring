package co.com.sofka.crud.mapper;

import co.com.sofka.crud.dto.TodoByCategoryDto;
import co.com.sofka.crud.entity.TodoByCategory;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public class TodoByCategoryMapper {

    @Autowired
    private ModelMapper mapper;

    public TodoByCategoryDto mapperCategoryDto(TodoByCategory todoByCategory){
        TodoByCategoryDto todoByCategoryDto = new TodoByCategoryDto();
        todoByCategoryDto = mapper.map(todoByCategory, TodoByCategoryDto.class);
        return todoByCategoryDto;
    }

    public TodoByCategory mapperTodo(TodoByCategoryDto todoByCategoryDto){
        TodoByCategory todoByCategory = new TodoByCategory();
        todoByCategory = mapper.map(todoByCategoryDto, TodoByCategory.class);
        return todoByCategory;
    }
}