import com.google.gson.Gson;
import lib.ITodoService;
import lib.impl.InMemoryTodoRepository;
import lib.models.TodoModel;
import lib.impl.TodoService;

import java.util.Date;

public class Main {

    private static final String API_CONTEXT = "/api/v1";

    public static void main(String[] args) {

        ITodoService todoService = new TodoService(new InMemoryTodoRepository());
        seedSampleData(todoService);

        final Gson gson = new Gson();

        new TodoResource(todoService, gson);
    }

    private static void seedSampleData(ITodoService todoService) {
        TodoModel model = new TodoModel();

        model.setTitle("Clean your room!");
        model.setCreatedDate(new Date());
        model.setCompleted(false);

        todoService.create(model);
    }
}