package calculator;

import java.io.IOException;
import java.util.Formatter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CalcLogger {
    public final static Logger LOGGER = Logger.getLogger("Calculator");

    public static void initLogger(){

        try {
            SimpleFormatter formatter = new SimpleFormatter();
            FileHandler fileHandler = new FileHandler(Config.logFile);
            fileHandler.setFormatter(formatter);
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.INFO);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
