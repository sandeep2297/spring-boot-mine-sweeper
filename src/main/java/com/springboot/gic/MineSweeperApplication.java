package com.springboot.gic;

import com.springboot.gic.model.Layout;
import com.springboot.gic.util.GameDisplayUtil;
import com.springboot.gic.util.UserInputUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MineSweeperApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Minesweeper!");

        System.out.print("Enter the size of the grid (e.g. 4 for a 4x4 grid): ");
        int size = Integer.parseInt(scanner.nextLine());

        int maxMines = (int) Math.floor(size * size * 0.35);
        System.out.print("Enter the number of mines to place on the grid (maximum is " + maxMines + "): ");
        int mines = Integer.parseInt(scanner.nextLine());

        Layout layout = new Layout(size, mines);

        boolean gameRunning = true;

        while (gameRunning) {
            System.out.println("\nHere is your minefield:");
            GameDisplayUtil.displayLayout(layout, false);

            System.out.print("\nSelect a tile to display (e.g. A1): ");
            String input = scanner.nextLine();

            int[] coordinates;
            try {
                coordinates = UserInputUtil.parseUserInput(input, size);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
                continue;
            }

            boolean safe = layout.displayTile(coordinates[0], coordinates[1]);

            if (!safe) {
                System.out.println("Oh no, you detonated a mine! Game over.");
                GameDisplayUtil.displayLayout(layout, true);
                break;
            }

            if (layout.allNonMineTilesDisplayed()) {
                GameDisplayUtil.displayLayout(layout, false);
                System.out.println("Congratulations, you have won the game!");
                break;
            }
        }

        System.out.println("Press Enter to exit...");
        scanner.nextLine();
    }

}
