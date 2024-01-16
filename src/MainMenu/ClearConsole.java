package MainMenu;

import java.awt.*;
import java.awt.event.KeyEvent;
public class ClearConsole
{
    public static void clearConsole() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_1);
        } catch (AWTException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
