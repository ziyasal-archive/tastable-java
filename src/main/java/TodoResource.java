import com.google.gson.Gson;
import lib.ITodoService;
import lib.models.TodoModel;

import static spark.Spark.get;
import static spark.Spark.post;

public class TodoResource {

    private static final String API_CONTEXT = "/api/v1";

    public TodoResource(ITodoService todoService, Gson gson) {

        post(API_CONTEXT + "/todos", "application/json",
                (request, response) -> {

                    TodoModel todoModel = gson.fromJson(request.body(), TodoModel.class);
                    todoService.create(todoModel);
                    response.status(201);

                    return response;
                }, new JsonTransformer());

        get(API_CONTEXT + "/todos/:id", "application/json",
                (request, response) -> {

                    String idParam = request.params(":id");

                    try {
                        int id = Integer.parseInt(idParam);
                        return todoService.find(id);
                    } catch (NumberFormatException e) {
                        response.status(400);
                        return response;
                    }

                }, new JsonTransformer());

        get(API_CONTEXT + "/todos", "application/json", (request, response) -> todoService.findAll(), new JsonTransformer());
    }
}


