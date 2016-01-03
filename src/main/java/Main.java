import com.google.gson.Gson;
import lib.TodoService;
import lib.impl.InMemoryTodoRepositoryImpl;
import lib.models.TodoModel;
import lib.impl.TodoServiceImpl;

import java.util.Date;

import static spark.Spark.*;

public class Main {

    private static final String API_CONTEXT = "/api/v1";

    public static void main(String[] args) {

        TodoService todoService = new TodoServiceImpl(new InMemoryTodoRepositoryImpl());
        seedSampleData(todoService);

        final Gson gson = new Gson();

        new TodoResource(todoService, gson);
    }

    private static void seedSampleData(TodoService todoService) {
        TodoModel model = new TodoModel();

        model.setTitle("Clean your room!");
        model.setCreatedDate(new Date());
        model.setCompleted(false);

        todoService.create(model);
    }
}