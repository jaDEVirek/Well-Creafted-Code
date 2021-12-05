package StreamAPI;

import org.junit.jupiter.api.Test;

public class Thrower {

    public Thrower() {
    }

    public void throwsRuntime() {
        throw new MyRuntimeException();
    }

    public void throwsRuntimeWithCause() {
        throw new MyRuntimeException(new IllegalStateException("Illegal state"));
    }

    public void throwsRuntimeWithCode(int code) {
        throw new MyRuntimeException(code);
    }

    public void throwsMyCheckedException() throws MyCheckedException {
        throw new MyCheckedException();
    }
    public int returnInt(){
        return  11;
    }
}

class MyRuntimeException extends  RuntimeException{

    public MyRuntimeException(IllegalStateException illegal_state) {
        super(illegal_state.getMessage(), illegal_state.getCause());
    }

    public MyRuntimeException(int code) {
        super("Error "+ code);
    }

    public MyRuntimeException() {
        super("My custom runtime exception");
    }
}
