package moduls;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 Created by ${Ruslan} on 19.09.16.

 */
public class ItemTest {
    private String clientName = "Viktor";
    private long dateAdd = 32;
    private String description = "repair my TV pls";
    private Item item = new Item(clientName, dateAdd, description);

    @org.junit.Test
    public void testSetName() throws Exception {
        String testName = "Nick";
        this.item.setName(testName);
        assertThat(item.getName(), is(testName));
    }

    @org.junit.Test
    public void testSetDateAdd() throws Exception {
        long testDateAdd = 48;
        this.item.setDateAdd(testDateAdd);
        assertThat(item.getDateAdd(),is(testDateAdd));
    }

    @org.junit.Test
    public void testSetDescription() throws Exception {
        String testDescription = "repair my iphone";
        this.item.setDescription(testDescription);
        assertThat(item.getDescription(),is(testDescription));
    }

    @org.junit.Test
    public void testGetName() throws Exception {
        assertThat(item.getName(), is(clientName));
    }

    @org.junit.Test
    public void testGetDateAdd() throws Exception {
        assertThat(item.getDateAdd(), is(dateAdd));
    }

    @org.junit.Test
    public void testGetDescription() throws Exception {
        assertThat(item.getDescription(), is(description));
    }

    @Test
    public void testSetClientId() throws Exception {
        String testClientId = "123";
        item.setClientId(testClientId);
        assertThat(item.getClientId(), is(testClientId));
    }

    @Test
    public void testGetClientId() throws Exception {
        String testClientId = "123";
        item.setClientId(testClientId);
        assertThat(item.getClientId(), is(testClientId));
    }

    @Test
    public void testAddComment() throws Exception {
        List<Comment> comments = new ArrayList<Comment>();
        comments.add(new Comment("first comment"));
        comments.add(new Comment("second comment"));
        for(Comment commentary:
                comments){
            item.addComment(commentary);
        }
        assertThat(item.getComments(), is(comments));
    }

}