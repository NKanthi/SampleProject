package com.qs.trainings.main;

import org.junit.Assert;
import org.junit.Test;

/*
 * This test class is written for testing the StringCalculator class functionality,
 * an example requirement taken from the below site.
 * https://technologyconversations.com/2013/12/20/test-driven-development-tdd-example-walkthrough/
 *
 */
public class StringCalculatorTest {

    @Test
    public final void whenTwoNumbersAreUsedThenNoExceptionIsThrown(){
        String twoNumberString = "1,2";
        int result = StringCalculator.add(twoNumberString);
        Assert.assertEquals(3, result);
    }
    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown(){
        String nonNumberInString = "A,2";
        StringCalculator.add(nonNumberInString);
    }
    @Test
    public final void whenEmptyStringWithNoNumbersIsUsedThenZeroIsReturned(){
        String emptyString = "";
        int result = StringCalculator.add(emptyString);
        Assert.assertEquals(0, result);
    }
    @Test
    public final void whenOneNumbersIsUsedThenTheSameIsReturned(){
        String oneNumberInString = "2";
        int result = StringCalculator.add(oneNumberInString);
        Assert.assertEquals(2, result);
    }
    @Test
    public final void whenTwoNumbersIsUsedThenTheirSumIsReturned(){
        String twoNumberString = "1,2";
        int expectedResult = 1+2;
        int result = StringCalculator.add(twoNumberString);
        Assert.assertEquals(expectedResult, result);
    }
    @Test
    public final void whenMoreThanTwoNumbersAreUsedThenSumOfAllValuesIsReturned(){
        String moreThanTwoNumberString = "1,2,3,4,5,6,7,8,9,10";
        int expectedResult = 1+2+3+4+5+6+7+8+9+10;
        int result = StringCalculator.add(moreThanTwoNumberString);
        Assert.assertEquals(expectedResult, result);
    }
    @Test
    public final void whenNewLinesAreUsedAsNumSeparatorsThenSumOfAllValuesIsReturned(){
        String numberStringWithNewlineSeparators = "1\n2\n3";
        int expectedResult = 1+2+3;
        int result = StringCalculator.add(numberStringWithNewlineSeparators);
        Assert.assertEquals(expectedResult, result);
    }

}