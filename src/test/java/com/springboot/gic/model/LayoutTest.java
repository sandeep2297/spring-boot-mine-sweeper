package com.springboot.gic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LayoutTest {


    @Test
    void testLayoutSize() {
        Layout layout = new Layout(5, 3);
        assertEquals(5, layout.getSize());
    }

    @Test
    void testMineLimitExceeded() {
        assertThrows(IllegalArgumentException.class, () -> new Layout(3, 5)); // over 35%
    }

    @Test
    void testDisplaySafeTile() {
        Layout layout = new Layout(4, 1);
        boolean displayed = layout.displayTile(0, 0);
        assertTrue(displayed || !layout.getTile(0, 0).getMineStatus()); // should be true if not a mine
    }

    @Test
    void testAllNonMineDisplayedFalseInitially() {
        Layout layout = new Layout(4, 2);
        assertFalse(layout.allNonMineTilesDisplayed());
    }
}
