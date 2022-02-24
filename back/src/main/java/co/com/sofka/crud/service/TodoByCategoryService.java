package co.com.sofka.crud.service;

import co.com.sofka.crud.entity.TodoByCategory;
import co.com.sofka.crud.repository.TodoByCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoByCategoryService {
    @Autowired
    private TodoByCategoryRepository categoryRepository;

    public Iterable<TodoByCategory> list(){
        return categoryRepository.findAll();
    }

    public TodoByCategory save(TodoByCategory todoByCategory){
        return categoryRepository.save(todoByCategory);
    }

    public void delete(Long id){
        categoryRepository.delete(get(id));
    }

    public TodoByCategory get(Long id){
        return categoryRepository.findById(id).orElseThrow();
    }
}
