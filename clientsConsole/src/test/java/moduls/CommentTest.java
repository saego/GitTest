package moduls;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 Created by ${Ruslan} on 03.10.16.

 */
public class CommentTest {
    private String comm = "some comments";
    private Comment comment;

    public CommentTest() {
        comment = new Comment(comm);
    }

    @Test
    public void testGetComment() throws Exception {
        assertThat(comment.getComment(), is(comm));
    }

    @Test
    public void testSetComment() throws Exception {
        String testComment = "other comment";
        comment.setComment(testComment);
        assertThat(comment.getComment(), is(testComment));
    }
}