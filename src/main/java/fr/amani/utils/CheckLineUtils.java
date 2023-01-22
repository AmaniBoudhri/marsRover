package fr.amani.utils;

public class CheckLineUtils {
    public static boolean checkLineForGridSize(String line) {
        return line.matches("^[0-9] [0-9]$");
    }

    public static boolean checkLineForPosition(String line) {
        return line.matches("^[0-9] [0-9] ([NSEW])$");
    }

    public static boolean checkLineForCommand(String line) {
        return line.matches("^[MLR]+$");
    }

}
