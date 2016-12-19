import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 Created by ${Ruslan} on 19.12.16.
 */
public class CellTest {
    private Cell testCell = new Cell(4, 6);
    @Test
    public void getPositionV() throws Exception {
    assertThat(testCell.getPositionV(), is(6));
    }

    @Test
    public void getPositionH() throws Exception {
    assertThat(testCell.getPositionH(), is(4));
    }

}