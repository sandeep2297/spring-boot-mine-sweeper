package com.springboot.gic.util;

public class UserInputUtil {

    private UserInputUtil() {

    }

    public static int[] parseUserInput(String input, int layoutSize) {
        input = input.trim().toUpperCase();
        if (input.length() < 2) {
            throw new IllegalArgumentException("Invalid input format");
        }

        char rowChar = input.charAt(0);
        int row = rowChar - 'A';
        int col;

        try {
            col = Integer.parseInt(input.substring(1)) - 1;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid column number");
        }

        if (row < 0 || row >= layoutSize || col < 0 || col >= layoutSize) {
            throw new IllegalArgumentException("Input out of bounds");
        }

        return new int[]{row, col};
    }
}
