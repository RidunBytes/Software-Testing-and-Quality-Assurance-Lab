import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CanvasTest {

    @Test
    void TestArray(){
        Canvas c = new Canvas();
        String expected = "circle\n"+"rectangle\n"+"triangle\n"+"circle\n";
        String str="";
        Canvas canvas= new Canvas();
        for(String s:c.arr)
        {
            switch (s){
                case "circle":
                case "rectangle":
                case "triangle": {
                    str = str + s+"\n";
                    break;
                }
            }
        }
        assertEquals(expected,str);
    }
    @Test
    void circle1() {
        String expected = "circle\n";
        Canvas canvas= new Canvas();
        assertEquals(expected,canvas.DrawCircle(1));
    }

    @Test
    void circle2() {
        String expected = "circle\n"+"circle\n";
        Canvas canvas= new Canvas();
        assertEquals(expected,canvas.DrawCircle(2));
    }

    @Test
    void Rectangle1() {
        String expected = "rectangle\n";
        Canvas canvas= new Canvas();
        assertEquals(expected,canvas.DrawRectangle(1));
    }

    @Test
    void Rectangle2() {
        String expected = "rectangle\n"+"rectangle\n";
        Canvas canvas= new Canvas();
        assertEquals(expected,canvas.DrawRectangle(2));
    }

    @Test
    void Triangle1() {
        String expected = "triangle\n";
        Canvas canvas= new Canvas();
        assertEquals(expected,canvas.DrawTriangle(1));
    }

    @Test
    void Triangle2() {
        String expected = "triangle\n"+"triangle\n";
        Canvas canvas= new Canvas();
        assertEquals(expected,canvas.DrawTriangle(2));
    }
}
