package lib.impl;

import lib.models.TodoModel;
import lib.TodoRepository;
import lib.TodoService;

import java.util.Set;

public class TodoServiceImpl implements TodoService {
    private TodoRepository repository;

    public TodoServiceImpl(TodoRepository repository) {
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
