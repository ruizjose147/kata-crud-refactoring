package co.com.sofka.crud.controller;

import co.com.sofka.crud.entity.TodoByCategory;
import co.com.sofka.crud.service.TodoByCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoByCategoryController {

    @Autowired
    private TodoByCategoryService categoryService;

    @GetMapping(value = "api/todosbycategory")
    public Iterable<TodoByCategory> list(){
        return categoryService.list();
    }

    @PostMapping(value = "api/todobycategory")
    public TodoByCategory save(@RequestBody TodoByCategory todoByCategory){
        return categoryService.save(todoByCategory);
    }

    @PutMapping(value = "api/todobycategory")
    public TodoByCategory update(@RequestBody TodoByCategory todoByCategory){
        if(todoByCategory.getId() != null){
            return categoryService.save(todoByCategory);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/todobycategory")
    public void delete(@PathVariable("id")Long id){
        categoryService.delete(id);
    }

    @GetMapping(value = "api/{id}/todobycategory")
    public TodoByCategory get(@PathVariable("id") Long id){
        return categoryService.get(id);
    }
}
