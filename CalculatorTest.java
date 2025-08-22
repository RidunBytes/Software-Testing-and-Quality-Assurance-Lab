import org.junit.Test;

import java.util.ArrayList;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

import static org.junit.Assert.*;

public class CalculatorTest{

    @Test
    public void test1(){
        Calculator calculator = new Calculator();
        long result = calculator.combination(5, 2);
        assertEquals(10, result);
    }

    @Test
    public void test2(){
        Calculator calculator = new Calculator();
        long result = calculator.combination(12, 10);
        assertEquals(66, result);
    }

    @Test
    public void test3(){
        Calculator calculator = new Calculator();
        long result = calculator.combination(6, 6);
        assertEquals(1, result);
    }

    @Test
    public void test4(){
        Calculator calculator = new Calculator();
        long result = calculator.combination(15, 2);
        assertEquals(105, result);
    }

    @Test
    public void test5(){
        Calculator calculator = new Calculator();
        long result = calculator.combination(15, 14);
        assertEquals(15, result);
    }

    @Test
    public void test6(){
        Calculator calculator = new Calculator();
        long result = calculator.combination(3, 0);
        assertEquals(1, result);
    }

    @Test
    public void testNonInteger(){
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.combination(2.5, 3));
    }

    @Test
    public void testZero(){
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.combination(0, 3));
    }

    @Test
    public void testNegative(){
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.combination(-14, 3));
    }

    @Test
    public void testTooLarge(){
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.combination(1000, 3));
    }

}
