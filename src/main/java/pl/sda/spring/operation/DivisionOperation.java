package pl.sda.spring.operation;

import org.springframework.stereotype.Component;
import pl.sda.spring.exception.DivisionByZeroException;

@Component
public class DivisionOperation implements Operation {
    @Override
    public double calculate(double arg1, double arg2) {

        if(arg2 == 0) {
            throw new DivisionByZeroException();
        }
        return arg1 / arg2;
    }

    @Override
    public OperationType getSupportedOperationType() {
        return OperationType.DIVISION;
    }
}
