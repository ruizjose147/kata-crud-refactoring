package co.com.sofka.crud.repository.dtoRepository;

import co.com.sofka.crud.dto.TodoDto;
import org.springframework.data.repository.CrudRepository;

public interface TodoDtoRepository extends CrudRepository<TodoDto, Long> {
}
