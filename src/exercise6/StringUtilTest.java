package exercise6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    void testLtrim() {
        assertEquals("hola", StringUtil.ltrim("   hola"));
        assertEquals("hola  ", StringUtil.ltrim("hola  "));
    }

    @Test
    void testRtrim() {
        assertEquals("hola", StringUtil.rtrim("hola    "));
        assertEquals("  hola", StringUtil.rtrim("  hola"));
    }

    @Test
    void testTrim() {
        assertEquals("hola", StringUtil.trim("   hola"));
        assertEquals("hola", StringUtil.trim("hola  "));
        assertEquals("hola", StringUtil.trim("   hola  "));
    }

    @Test
    void testIndexOfN() {
        assertEquals(9, StringUtil.indexOfN("John|Paul|George|Ringo", '|', 2));
        assertEquals(21, StringUtil.indexOfN("John|Paul|George|Ringo", 'o', 3));
        assertEquals(1, StringUtil.indexOfN("another-string-example", 'n', 1));
    }

    @Test
    void lpad() {
        assertEquals("||||Ringo", StringUtil.lpad("Ringo", '|', 4));
        assertEquals("|||||Ringo", StringUtil.lpad("|Ringo", '|', 4));
    }

    @Test
    void rpad() {
        assertEquals("Ringo||||", StringUtil.rpad("Ringo", '|', 4));
        assertEquals("Ringo|||||", StringUtil.rpad("Ringo|", '|', 4));
    }
}