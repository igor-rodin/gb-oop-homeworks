package calculator;

import java.io.IOException;
import java.util.Formatter;
import java.util.logging.*;

public class CalcLogger {
    public final static Logger LOGGER = Logger.getLogger("Calculator");

    public static void initLogger(){

        try {
            LOGGER.setUseParentHandlers(false);
            SimpleFormatter formatter = new SimpleFormatter();
            FileHandler fileHandler = new FileHandler(Config.logFile);
            fileHandler.setFormatter(formatter);
            LOGGER.addHandler(fileHandler);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
