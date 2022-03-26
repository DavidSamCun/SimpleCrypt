import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ROT13Test {


    @Test
    public void rotateStringTest0() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "ABCDEF";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'A');

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest1() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "DEFABC";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'D');
        System.out.println(actual);

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest2() {
        // Given
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = "NOPQRSTUVWXYZABCDEFGHIJKLM";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'N');
        System.out.println(s1);
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void cryptTest1() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        String A1 = "Jul qvq gur puvpxra pebff gur ebnq?";

        String Q2 = "Gb trg gb gur bgure fvqr!";
        String A2 = "To get to the other side!";

        // When
        String actual = cipher.encrypt(Q1);
        System.out.println(Q1);
        System.out.println(A1);
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(A1));

        // When
        String actual2 = cipher.decrypt(Q2);
        System.out.println(Q2);
        System.out.println(A2);
        System.out.println(actual2);
        // Then
        assertTrue(actual2.equals(A2));
    }
    @Test
    public void cryptTest2() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        System.out.println(Q1);
        String hold = cipher.crypt(Q1);

        // When
        String actual = cipher.crypt(cipher.crypt(Q1));
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(Q1));
    }





    //Test Methods


    @Test
    public void reWriteTest1(){

        //Given
        String test = "abcd";
        int shift = 0;
        ROT13 rotTest = new ROT13();


        //When
        String output = rotTest.reWriteCode(test, shift);
        String expected = "abcd";

        assertTrue(output.equals(expected));

    }

    @Test
    public void reWriteTest2(){

        //Given
        String test = "ABcd";
        int shift = 1;
        ROT13 rotTest = new ROT13();


        //When
        String output = rotTest.reWriteCode(test, shift);
        String expected = "BCde";

        assertTrue(output.equals(expected));

    }

    @Test
    public void reWriteTest3(){

        //Given
        String test = "ab cd";
        int shift = 1;
        ROT13 rotTest = new ROT13();


        //When
        String output = rotTest.reWriteCode(test, shift);
        String expected = "bc de";

        assertTrue(output.equals(expected));

    }

}