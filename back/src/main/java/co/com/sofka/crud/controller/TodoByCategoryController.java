package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.TodoByCategoryDto;
import co.com.sofka.crud.service.TodoByCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoByCategoryController {

    @Autowired
    private TodoByCategoryService categoryService;

    @GetMapping(value = "api/todosbycategory")
    public Iterable<TodoByCategoryDto> list(){
        return categoryService.list();
    }

    @PostMapping(value = "api/todobycategory")
    public TodoByCategoryDto save(@RequestBody TodoByCategoryDto dto){
        return categoryService.save(dto);
    }

    @PutMapping(value = "api/todobycategory")
    public TodoByCategoryDto update(@RequestBody TodoByCategoryDto dto){
        if(dto.getId() != null){
            return categoryService.save(dto);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/todobycategory")
    public void delete(@PathVariable("id")Long id){
        categoryService.delete(id);
    }

    @GetMapping(value = "api/{id}/todobycategory")
    public TodoByCategoryDto get(@PathVariable("id") Long id){
        return categoryService.get(id);
    }
}

