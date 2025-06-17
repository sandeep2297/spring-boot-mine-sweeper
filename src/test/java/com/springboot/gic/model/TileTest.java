package com.springboot.gic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TileTest {

    @Test
    void testInitialState() {
        Tile tile = new Tile();
        assertFalse(tile.getMineStatus());
        assertFalse(tile.getDisplayStatus());
        assertEquals(0, tile.getNeighborMines());
    }

    @Test
    void testPlaceMine() {
        Tile tile = new Tile();
        tile.setMineStatus();
        assertTrue(tile.getMineStatus());
    }

    @Test
    void testDisplay() {
        Tile tile = new Tile();
        tile.setDisplayStatus();
        assertTrue(tile.getDisplayStatus());
    }

    @Test
    void testIncrementAdjacentMines() {
        Tile tile = new Tile();
        tile.setNeighborMines(tile.getNeighborMines() + 1);
        tile.setNeighborMines(tile.getNeighborMines() + 1);
        assertEquals(2, tile.getNeighborMines());
    }


}
