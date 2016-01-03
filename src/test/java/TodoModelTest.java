import lib.models.TodoModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TodoModelTest {

    TodoModel todoModel;

    @Before
    public void setUp() {
        todoModel = new TodoModel();
    }

    @Test
    public void title_test() {
        String expected = "Do Homework";
        todoModel.setTitle(expected);
        String result = todoModel.getTitle();

        Assert.assertEquals(result, expected);
    }

    @Test
    public void completed_test() {
        Boolean expected = true;

        todoModel.setCompleted(expected);
        Boolean result = todoModel.getCompleted();

        Assert.assertEquals(result, expected);
    }

    @Test
    public void id_test() {
        int expected = 1;

        todoModel.setId(expected);
        int result = todoModel.getId();

        Assert.assertEquals(result, expected);
    }

    @Test
    public void createdDate_test() {
        Date expected = new Date();;

        todoModel.setCreatedDate(expected);
        Date result = todoModel.getCreatedDate();

        Assert.assertEquals(result, expected);
    }
}
