package XXLChess;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import XXLChess.enums.Colour;
import XXLChess.exceptions.ConfigException;
import XXLChess.exceptions.ValidationException;
import processing.core.PApplet;
import processing.data.JSONObject;

/**
 * Config is the class used to parse and store the configuration settings from file. 
 * <p/>
 * Config needs to be instantiated once in the App class in order to parse the JSON params
 * and the parameters are stored within the class itself.
 * The Config class performs parsing once, and then exists as a buffer throughout the program 
 * interacting with various components as needed.
 */
public class Config {
    private Map<String, Integer> playerTimeSettings;
    private Map<String, Integer> cpuTimeSettings;
    private Colour playerColour;
    private Colour cpuColour;
    private boolean playAsCpu;

    public Config() {
        playerTimeSettings = new HashMap<>(2);
        cpuTimeSettings = new HashMap<>(2);
        playerColour = Colour.NULL;
        cpuColour = Colour.NULL;
        playAsCpu = false;
    }

    /**
     * The method used to parse the configuration settings from config.json. 
     * <p/>
     * This method retrieves the settings from the appropriate keys and stores the settings within the
     * Config object. 
     * @param configName - This must be a String and match the file name specified in App.class: "config.java"
     */
    public void parseFile(String configName) {
        try {
            if (configName != "config.json") {
                throw new ConfigException();
            }
        } catch (ConfigException ve) {
            System.err.println("config name within system has changed from \"config.json\".");
        }
        
        try {
            JSONObject conf = PApplet.loadJSONObject(new File(configName));
            parseTimeSettings(conf.getJSONObject("time_settings"));
            parsePlayerColour(conf.getJSONObject("colour_settings"));
            parseOtherSettings(conf.getJSONObject("other_settings"));
        } catch (NullPointerException npe) {
            System.err.println("No config name specified in program.");
            System.exit(1);
        } catch (RuntimeException re) {
            System.err.println("Error parsing JSON file. Check that filename matches \"config.json\" and file exists.");
            System.exit(1);
        }
    }

    private void parseTimeSettings(JSONObject timeSettings) {
        int[] playerBuffer = new int[2];
        int[] cpuBuffer = new int[2];

        // checks for approproate key as well as int type check.
        try {
            playerBuffer[0] = timeSettings.getJSONObject("player").getInt("seconds");
            playerBuffer[1] = timeSettings.getJSONObject("player").getInt("increment");
            cpuBuffer[0] = timeSettings.getJSONObject("cpu").getInt("seconds");
            cpuBuffer[1] = timeSettings.getJSONObject("cpu").getInt("increment");
        } catch (RuntimeException re) {
            System.err.println("Error parsing time settings in JSON file. (1/4)");
            System.err.println("Check parameters are \"player\" and \"cpu\". (2/4)");
            System.err.println("Check sub-parameters for each are \"seconds\" and \"increment\". (3/4)");
            System.err.println("Check the values of the sub-parameters are all integers. (4/4)");
            System.exit(1);
        }

        // check that int parameters are within expected range. 
        try {
            validateTimeSettings(playerBuffer);
            validateTimeSettings(cpuBuffer);
        } catch (ValidationException ve) {
            System.err.println(ve.getMessage());
            System.exit(1);
        }

        playerTimeSettings.put("seconds", playerBuffer[0]);
        playerTimeSettings.put("increment", playerBuffer[1]);
        cpuTimeSettings.put("seconds", cpuBuffer[0]);
        cpuTimeSettings.put("increment", cpuBuffer[1]);
    }

    private void validateTimeSettings(int[] timeSettings) throws ValidationException {
        if (timeSettings[0] <= 0 | timeSettings[1] < 0) {
            throw new ValidationException("Time parameters out of range. Valid range: (seconds > 0) and (increment >= 0).");
        }
    }

    private void parsePlayerColour(JSONObject colourSetting) {
        try {
            String playerColour = colourSetting.getString("player_colour");
            if (playerColour == "white") {
                this.playerColour = Colour.WHITE;
                this.cpuColour = Colour.BLACK;
            } else if (playerColour == "black") {
                this.playerColour = Colour.BLACK;
                this.cpuColour = Colour.WHITE;
            } else {
                throw new ValidationException("Colour parameter incorrect. Must be \"black\" or \"white\"");
        }
        } catch (RuntimeException re) {
            System.err.println("Error reading colour settings. (1/3)");
            System.err.println("Check \"player_colour\" is the name of the parameter. (2/3)");
            System.err.println("Check that the colour value is enclosed in \" \". (3/3)");
            System.exit(1);
        } catch (ValidationException ve) {
            System.err.println(ve.getMessage());
            System.exit(1);
        }
    }

    private void parseOtherSettings(JSONObject otherSettings) {
        try {
            playAsCpu = otherSettings.getBoolean("play_as_cpu");
        } catch (RuntimeException re) {
            System.err.println("Error reading other settings. (1/3)");
            System.err.println("Check \"play_as_cpu\" is the name of the parameter. (2/3)");
            System.err.println("Check that \"play_as_cpu\" is either \"true\" or \"false\". (3/3)");
            System.exit(1);
        }
    }

    /*
     * Welcome to Java...
     */

    /**
     * This method retrieves the intial value of the player clock.
     * The clock value is originally specified in the config file:
     * <p/>
     * "time_settings": { "player": { "seconds" } }
     * @return An Integer object with the total number of seconds alloted to the player for
     * the duration of the game. Return will be a positive number.
     */
    public Integer getPlayerClock() {
        return playerTimeSettings.get("seconds"); 
    }

    /**
     * This method retrieves the intial value of the cpu clock.
     * The clock value is originally specified in the config file:
     * <p/>
     * "time_settings": { "cpu": { "seconds" } }
     * @return An Integer object with the total number of seconds alloted to the cpu for
     * the duration of the game. Return will be a positive number.
     */
    public Integer getCpuClock() {
        return cpuTimeSettings.get("seconds"); 
    }

    /**
     * This method retrieves the value that is deducted from the player's clock each
     * turn. This value is originally specified in the config file:
     * <p/>
     * "time_settings": { "player": { "increment" } }
     * @return An Integer object with the number of seconds deincremented from the
     * player clock each turn. Return will be positive or equal to zero.
     */
    public Integer getPlayerIncrement() {
        return playerTimeSettings.get("increment");
    }

    /**
     * This method retrieves the value that is deducted from the cpu's clock each
     * turn. This value is originally specified in the config file:
     * <p/>
     * "time_settings": { "cpu": { "increment" } }
     * @return An Integer object with the number of seconds deincremented from the
     * cpu clock each turn. Return will be positive or equal to zero.
     */
    public Integer getCpuIncrement() {
        return cpuTimeSettings.get("increment");
    }

    /**
     * This method retrieves the colour that is assigned to the player. 
     * This value is originally specified in the config file:
     * <p/>
     * "colour_settings": { "player_colour" }
     * @return A value of the enumerator type "Colour".
     * * Specific values are either "BLACK", "WHITE", or "NULL".
     */
    public Colour getPlayerColour() {
        return playerColour;
    }

    /**
     * This method retrieves the colour that is assigned to the cpu. 
     * This value is determined by choosing the opposite colour
     * assigned to the player.
     * @return A value of the enumerator type "Colour".
     * Specific values are either "BLACK", or "WHITE".
     */
    public Colour getCpuColour() {
        return cpuColour;
    }

    /**
     * This method retrieves the special setting which turns 
     * the game into a cpu vs. cpu match. 
     * This value is originally specified in the config file:
     * <p/>
     * "other_settings": { "play_as_cpu" }
     * @return A boolean value. True, means the player will turn 
     * into a cpu. False means the player will play as normal. 
     */
    public boolean getPlayAsCpu() {
        return playAsCpu;
    }
}
