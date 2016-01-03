package lib.impl;

import lib.models.TodoModel;
import lib.ITodoRepository;
import lib.ITodoService;

import java.util.Set;

public class TodoService implements ITodoService {
    private ITodoRepository repository;

    public TodoService(ITodoRepository repository) {
        this.repository = repository;
    }

    public int create(TodoModel todoModel) {
        return repository.create(todoModel);
    }

    public TodoModel find(int id) {
        return repository.find(id);
    }

    public Boolean remove(int id) {
        return repository.remove(id);
    }

    public Set<TodoModel> findAll() {
        return repository.findAll();
    }
}
