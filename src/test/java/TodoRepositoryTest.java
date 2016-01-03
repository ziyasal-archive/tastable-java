import com.flextrade.jfixture.JFixture;
import lib.TodoRepository;
import lib.impl.InMemoryTodoRepositoryImpl;
import lib.models.TodoModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class TodoRepositoryTest {

    JFixture fixture = new JFixture();

    TodoRepository todoRepository;

    @Before
    public void setUp() {
        todoRepository = new InMemoryTodoRepositoryImpl();
    }

    @Test
    public void save_test() {

        int firstId = 1;

        TodoModel todoModel = fixture.create(TodoModel.class);
        int id = todoRepository.create(todoModel);

        Assert.assertEquals(id, firstId);
    }


    @Test
    public void find_returns_null_when_todos_is_empty_test() {
        int id = 1;

        TodoModel result = todoRepository.find(id);

        Assert.assertNull(result);
    }

    @Test
    public void find_returns_null_when_item_doesnt_exist_test() {

        TodoModel saveModel = fixture.create(TodoModel.class);
        todoRepository.create(saveModel);

        TodoModel result = todoRepository.find(666);

        Assert.assertNull(result);
    }

    @Test
    public void find_test() {

        TodoModel saveModel = fixture.create(TodoModel.class);
        int id = todoRepository.create(saveModel);

        TodoModel result = todoRepository.find(id);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getId(), id);
    }

    @Test
    public void findAll__returns_empty_set_when_todos_is_empty_test() {

        Set<TodoModel> actual = todoRepository.findAll();

        Assert.assertNotNull(actual);
        Assert.assertEquals(actual.size(), 0);
    }

    @Test
    public void findAll_test() {

        TodoModel saveModel = fixture.create(TodoModel.class);
        todoRepository.create(saveModel);

        Set<TodoModel> actual = todoRepository.findAll();

        Assert.assertNotNull(actual);
        Assert.assertEquals(actual.size(), 1);
    }


    @Test
    public void remove_returns_false_when_todos_is_empty_test() {
        int id = 1;

        Boolean result = todoRepository.remove(id);
        Assert.assertFalse(result);

    }

    @Test
    public void remove_returns_false_when_todo_doesnt_exist_test() {
        int id = 666;
         Boolean result = todoRepository.remove(id);
        Assert.assertFalse(result);

    }

    @Test
    public void remove_test() {
        boolean expected = true;

        TodoModel saveModel = fixture.create(TodoModel.class);
        int id = todoRepository.create(saveModel);

        Boolean result = todoRepository.remove(id);
        Assert.assertEquals(result, expected);
    }
}
