package study.auth_study2;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/api/v2/create")
    public TodoResponseDto createTodo(@RequestBody CreateTodoRequestDto requestDto) {
        return todoService.createTodo(requestDto);
    }

    @GetMapping({"/api/v2/getTodos"})
    public List<TodoResponseDto> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/api/v2/getTodo/{id}")
    public TodoResponseDto getTodo(@PathVariable Long id) {
        return todoService.getTodo(id);
    }

    @DeleteMapping("/api/v2/delete/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

    @PostMapping("/api/v2/toggle/{id}")
    public void toggleCompleted(@PathVariable Long id){
        todoService.toggleCompleted(id);
    }
}
