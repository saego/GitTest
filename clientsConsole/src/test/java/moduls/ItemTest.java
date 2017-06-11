package moduls;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

/**
 Created by ${Ruslan} on 19.09.16.

 */
public class ItemTest {
    private String clientName = "Viktor";
    private long dateAdd = 32;
    private String description = "repair my TV pls";
    private Item item = new Item(clientName, dateAdd, description);
    //String comm = "my comment";
    //Comment comment = new Comment(comm);

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
        Comment [] comments = new Comment[2];
        comments[0] = new Comment("first comment");
        comments[1] = new Comment("second comment");
        for(Comment commentars:
                comments){
            item.addComment(commentars);
        }
        assertThat(getCommentsWithoutNull(item.getComments()), comments);
    }

    private Comment[] getCommentsWithoutNull(Comment[] comments){
        int lenthCommentWithoutNull = 0;
        for (Comment comment:
             comments) {
            if(comment != null){
                lenthCommentWithoutNull++;
            }
        }
        Comment []commentsWithoutNull = new Comment[lenthCommentWithoutNull];
        int temp = 0;
        for (Comment comment:
             comments) {
            if(comment != null){
                commentsWithoutNull[temp] = comment;
                temp++;
            }
        }
        return commentsWithoutNull;
    }
}