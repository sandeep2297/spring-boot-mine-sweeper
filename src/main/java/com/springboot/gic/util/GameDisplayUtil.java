package com.springboot.gic.util;

import com.springboot.gic.model.Layout;
import com.springboot.gic.model.Tile;

public class GameDisplayUtil {

    public static void displayLayout(Layout layout, boolean displayMines) {
        int size = layout.getSize();

        // Print header
        System.out.print("  ");
        for (int col = 1; col <= size; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        // Print rows
        for (int row = 0; row < size; row++) {
            char rowLabel = (char) ('A' + row);
            System.out.print(rowLabel + " ");
            for (int col = 0; col < size; col++) {
                Tile tile = layout.getTile(row, col);
                if (tile.getDisplayStatus()) {
                    if (tile.getMineStatus()) {
                        System.out.print("* ");
                    } else {
                        System.out.print(tile.getNeighborMines() + " ");
                    }
                } else if (displayMines && tile.getDisplayStatus()) {
                    System.out.print("* ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}
