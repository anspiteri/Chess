package XXLChess;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import XXLChess.enums.Colour;
import XXLChess.exceptions.ValidationException;
import processing.core.PApplet;
import processing.data.JSONObject;

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

    public void parseFile(String configName) {
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

    public Integer getPlayerClock() {
        return playerTimeSettings.get("seconds"); 
    }

    public Integer getCpuClock() {
        return cpuTimeSettings.get("seconds"); 
    }

    public Integer getPlayerIncrement() {
        return playerTimeSettings.get("increment");
    }

    public Integer getCpuIncrement() {
        return cpuTimeSettings.get("increment");
    }

    public Colour getPlayerColour() {
        return playerColour;
    }

    public Colour getCpColour() {
        return cpuColour;
    }

    public boolean getPlayAsCpu() {
        return playAsCpu;
    }
}
