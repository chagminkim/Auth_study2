package study.auth_study2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoResponseDto createTodo(CreateTodoRequestDto requestDto) {
        TodoEntity todo = new TodoEntity(requestDto.getTitle(), requestDto.getDescription(), false);

        TodoEntity todoEntity = todoRepository.save(todo);

        return new TodoResponseDto(todoEntity.getId(), todoEntity.getTitle(), todoEntity.getDescription(), todoEntity.isCompleted());
    }

    public TodoResponseDto getTodo(Long id) {
        TodoEntity todo = todoRepository.findById(id).get();

        return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isCompleted());
    }

    public List<TodoResponseDto> getAllTodos() {
        List<TodoEntity> todos = todoRepository.findAll();

        List<TodoResponseDto> todoResponseDtos = new ArrayList<>();

        for (TodoEntity todo : todos) {
            todoResponseDtos.add(new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isCompleted()));
        }

        return todoResponseDtos;
    }

    public void deleteTodo(Long id) {

        todoRepository.deleteById(id);
    }

    public void toggleCompleted(Long id){

        TodoEntity todo = todoRepository.findById(id).get();
        if(todo.isCompleted()){
            todo.setCompleted(false);
        }else{
            todo.setCompleted(true);
        }
    }
}
