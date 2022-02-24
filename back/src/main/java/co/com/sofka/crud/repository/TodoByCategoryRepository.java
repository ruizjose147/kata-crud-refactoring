package co.com.sofka.crud.repository;


import co.com.sofka.crud.entity.TodoByCategory;
import org.springframework.data.repository.CrudRepository;

public interface TodoByCategoryRepository extends CrudRepository<TodoByCategory, Long> {
}
