package StreamAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SomeLambdaTest {

//    @Rule
//    public ExpectedException thrown = ExpectedException.none();

    //    @InjectMocks
    public Thrower thrower;

    @BeforeEach
    public void initMocks() {
        thrower = new Thrower();
    }

    @Test
    public void shouldTransposeMatrix() {
        //given
        final int[][] original = new int[][]{
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}};

        //when
        SomeLambda.transposeMatrix(original);
        assertArrayEquals(original, new int[][]{
                {1, 5, 9},
                {2, 6, 10},
                {3, 7, 11}});
        //expected
    }

    @Test
    @DisplayName("ArithmeticException expecting")
    public void testExpectedException() {

        NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("One");
        }, "NumberFormatException was expected");

        Assertions.assertEquals("For input string: \"One\"", thrown.getMessage());
    }

    @Test
    public void verifiesTypeAndMessage() {
//        thrown.expect(StreamAPI.MyRuntimeException.class);
//        thrown.expectMessage("My custom runtime exception");
        final MyRuntimeException my_custom_ruasdasntime_exceptions = assertThrows(MyRuntimeException.class, () -> {
            thrower.throwsRuntime();
        });
        assertEquals(my_custom_ruasdasntime_exceptions.getMessage(), "My custom runtime exception");
    }

    @Test
    @DisplayName("Custom exception return MyCheckedException!")
    public void shouldVerifyThrowingCustomException() throws MyCheckedException {

//        thrower = new Thrower();
        StreamAPI.MyCheckedException thrown = Assertions.assertThrows(StreamAPI.MyCheckedException.class, () -> {
            thrower.throwsMyCheckedException();
        }, "My custom runtime exception");
    }
}
