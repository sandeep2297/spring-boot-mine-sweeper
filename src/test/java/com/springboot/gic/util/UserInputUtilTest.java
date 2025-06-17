package com.springboot.gic.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserInputUtilTest {

    @Test
    void testValidInput() {
        int[] coords = UserInputUtil.parseUserInput("B2", 4);
        assertArrayEquals(new int[]{1, 1}, coords);
    }

    @Test
    void testLowerCaseInput() {
        int[] coords = UserInputUtil.parseUserInput("c3", 4);
        assertArrayEquals(new int[]{2, 2}, coords);
    }

    @Test
    void testInvalidInputFormat() {
        assertThrows(IllegalArgumentException.class, () -> UserInputUtil.parseUserInput("1A", 4));
        assertThrows(IllegalArgumentException.class, () -> UserInputUtil.parseUserInput("X", 4));
    }

    @Test
    void testOutOfBounds() {
        assertThrows(IllegalArgumentException.class, () -> UserInputUtil.parseUserInput("Z9", 3));
    }

}
