package lib;

import lib.models.TodoModel;

import java.util.Set;

public interface TodoRepository {

    int create(TodoModel todoModel);

    TodoModel find(int id);

    Boolean remove(int id);

    Set<TodoModel> findAll();
}
