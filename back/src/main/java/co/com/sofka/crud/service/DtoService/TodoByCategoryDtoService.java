package co.com.sofka.crud.service.DtoService;

import co.com.sofka.crud.repository.dtoRepository.TodoByCategoryDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoByCategoryDtoService {
    @Autowired
    private TodoByCategoryDtoRepository byCategoryDtoRepository;

    public Iterable<TodoByCategoryDtoRepository> list(){
        return byCategoryDtoRepository.findAll();
    }

    public TodoByCategoryDtoRepository save(TodoByCategoryDtoRepository todoByCategoryDtoRepository){
        return byCategoryDtoRepository.save(todoByCategoryDtoRepository);
    }

    public void delete(Long id){
        byCategoryDtoRepository.delete(get(id));
    }

    public TodoByCategoryDtoRepository get(Long id){
        return byCategoryDtoRepository.findById(id).orElseThrow();
    }
}
