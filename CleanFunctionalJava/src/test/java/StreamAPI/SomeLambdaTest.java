package StreamAPI;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class SomeLambdaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    void shouldTransposeMatrix(){
        //given
        final int[][] original = new int[][]{
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}};

        //when
        SomeLambda.transposeMatrix(original);
        assertArrayEquals(original,new int[][]{
                {1, 5, 9},
                {2, 6, 10},
                {3, 7, 11}});
        //expected

    }

    @Test
    void testExpectedException() {

        NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("One");
        }, "NumberFormatException was expected");

        Assertions.assertEquals("For input string: \"One\"", thrown.getMessage());
    }


}
