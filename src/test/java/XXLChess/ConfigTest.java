package XXLChess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import XXLChess.enums.Colour;

class ConfigTest {
    final String testConfig = "testconfig.json";
    
    @Test
    void TestConstructor() {
        Config config = new Config();
        assertNull(config.getPlayerClock());
        assertNull(config.getPlayerIncrement());
        assertNull(config.getCpuClock());
        assertNull(config.getCpuIncrement());

        assertEquals(Colour.NULL, config.getPlayerColour());
        assertEquals(Colour.NULL, config.getCpuColour());

        assertFalse(config.getPlayAsCpu());
    }

    /*
     * The following set of tests pertain to the parseFile method. 
     */

    @Test
    void TestParseTimeSettings() {
        Config config = new Config();
        config.parseFile(testConfig);
        assertEquals(120, config.getPlayerClock());
        assertEquals(51, config.getCpuClock());
        assertEquals(5, config.getPlayerIncrement());
        assertEquals(2, config.getCpuIncrement());
    }

    @Test
    void TestParseColour() {
        Config config = new Config();
        config.parseFile(testConfig);
        assertEquals(Colour.BLACK, config.getPlayerColour());
        assertNotEquals(config.getPlayerColour(), config.getCpuColour());
        assertNotEquals(Colour.NULL, config.getCpuColour());
    }

    @Test
    void TestParseOtherSettings() {
        Config config = new Config();
        config.parseFile(testConfig);
        assertEquals(true, config.getPlayAsCpu());
    }
}
