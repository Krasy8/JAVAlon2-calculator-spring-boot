package pl.sda.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.spring.exception.DivisionByZeroException;
import pl.sda.spring.operation.OperationType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CalculatorTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void shouldReturnFiveForGivenArgumentsOnAdditionOperation() {
        //given
        double arg1 = 2.0;
        double arg2 = 3.0;

        //when
        double actual = calculator.calculate(OperationType.ADDITION, arg1, arg2);

        //then
        Assert.assertEquals(5.0, actual, 0.00000001);
    }

    @Test
    public void shouldReturnTwoForGivenArgumentsOnSubtractionOperation() {
        // given
        double arg1 = 5.0;
        double arg2 = 3.0;

        //when
        double actual = calculator.calculate(OperationType.SUBTRACTION, arg1, arg2);

        //then
        Assert.assertEquals(2.0, actual, 0.00000001);
    }

    @Test
    public void shouldReturnSevenForGivenArgumentsOnMultiplicationOperation() {
        // given
        double arg1 = 3.5;
        double arg2 = 2.0;

        // when
        double actual = calculator.calculate(OperationType.MULTIPLICATION, arg1, arg2);

        // then
        Assert.assertEquals(7, actual, 0.00000001);
    }

    @Test
    public void shouldReturnTwoForGivenArgumentsOnDivisionOperation() {
        // given
        double arg1 = 7.0;
        double arg2 = 3.5;

        // when
        double actual = calculator.calculate(OperationType.DIVISION, arg1, arg2);

        // then
        Assert.assertEquals(2.0, actual, 0.00000001);
    }

    @Test(expected = DivisionByZeroException.class)
    public void shouldReturnExceptionOnDivisionOperationWhenDividingByZero() {
        // given
        double arg1 = 7.0;
        double arg2 = 0.0;

        // when
        calculator.calculate(OperationType.DIVISION, arg1, arg2);
    }

    @Test
    public void shouldReturnFiveOnPercentageOperation() {
        // given
        double arg1 = 25.00;
        double arg2 = 20.00;

        // when
        double actual = calculator.calculate(OperationType.PERCENTAGE, arg1, arg2);

        // then
        Assert.assertEquals(5.00, actual, 0.00000001);
    }

    @Test
    public void shouldReturnEightOnPowerOperation() {
        //given
        double arg1 = 2.0;
        double arg2 = 3.0;

        // when
        double actual = calculator.calculate(OperationType.POWER, arg1, arg2);

        // then
        Assert.assertEquals(8.0, actual, 0.00000001);
    }
}
