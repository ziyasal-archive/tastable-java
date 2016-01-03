package lib.impl;

import lib.models.TodoModel;
import lib.ITodoRepository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InMemoryTodoRepository implements ITodoRepository {

    Set<TodoModel> todoModels = new HashSet<TodoModel>();

    int lastId = 0;

    public int create(TodoModel todoModel) {
        lastId += 1;

        todoModel.setId(lastId);
        todoModels.add(todoModel);

        return lastId;
    }

    public TodoModel find(int id) {
        for (TodoModel next : todoModels) {
            if (next.getId() == id) {
                return next;
            }
        }

        return null;
    }

    public Boolean remove(int id) {

        Iterator<TodoModel> iterator = todoModels.iterator();

        while (iterator.hasNext()) {
            TodoModel next = iterator.next();
            if (next.getId() == id) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public Set<TodoModel> findAll() {
        return todoModels;
    }
}
