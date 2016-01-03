import com.flextrade.jfixture.JFixture;
import lib.TodoRepository;
import lib.TodoService;
import lib.models.TodoModel;
import lib.impl.TodoServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {
    @Mock
    TodoRepository todoRepositoryMock;

    JFixture fixture;
    TodoService todoService;

    @Before
    public void setUp() {
        fixture = new JFixture();
        todoService = new TodoServiceImpl(todoRepositoryMock);
    }


    @Test
    public void save_test() {
        int expected = 1;
        TodoModel todoModel = fixture.create(TodoModel.class);

        when(todoRepositoryMock.create(any(TodoModel.class))).thenReturn(expected);

        int actual = todoService.create(todoModel);

        Assert.assertEquals(actual, expected);
        verify(todoRepositoryMock, times(1)).create(any(TodoModel.class));
    }

    @Test
    public void find_test_returns_null_when_todo_not_found_test() {

        int id = 1;

        when(todoRepositoryMock.find(id)).thenReturn(null);
        TodoModel actual = todoService.find(id);

        Assert.assertNull(actual);
        verify(todoRepositoryMock, times(1)).find(id);
    }

    @Test
    public void find_test() {
        int id = 1;

        TodoModel expected = fixture.create(TodoModel.class);

        when(todoRepositoryMock.find(id)).thenReturn(expected);

        TodoModel actual = todoService.find(id);

        Assert.assertEquals(actual, expected);
        verify(todoRepositoryMock, times(1)).find(id);
    }


    @Test
    public void findAll_returns_empty_set_when_todos_is_empty_test() {
        Set<TodoModel> expected = new HashSet<>();

        when(todoRepositoryMock.findAll()).thenReturn(expected);

        Set<TodoModel> actual = todoService.findAll();

        Assert.assertEquals(actual.size(), expected.size());
        verify(todoRepositoryMock, times(1)).findAll();
    }



    @Test
    public void findAll_test() {
        Set<TodoModel> expected = new HashSet<>();
        expected.add(fixture.create(TodoModel.class));

        when(todoRepositoryMock.findAll()).thenReturn(expected);

        Set<TodoModel> actual = todoService.findAll();

        Assert.assertEquals(actual.size(), expected.size());
        verify(todoRepositoryMock, times(1)).findAll();
    }

    @Test
    public void remove_returns_false_when_todos_is_empty_test() {
        int id = 1;

        boolean expected = false;
        when(todoRepositoryMock.remove(id)).thenReturn(expected);

        Boolean actual = todoService.remove(id);
        Assert.assertEquals(actual, expected);
        verify(todoRepositoryMock, times(1)).remove(id);
    }

    @Test
    public void remove_test() {
        int id = 1;

        boolean expected = true;
        when(todoRepositoryMock.remove(id)).thenReturn(expected);

        Boolean actual = todoService.remove(id);
        Assert.assertEquals(actual, expected);
        verify(todoRepositoryMock, times(1)).remove(id);
    }
}
