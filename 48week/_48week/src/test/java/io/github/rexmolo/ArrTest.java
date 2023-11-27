package io.github.rexmolo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrTest {

    @Test
    void mergeTwoStringArray() {

        //Arrange
        String[] names = {"Fredrik"};
        String[] moreNames = {"Erik", "Ulf", "Simon", "Kent"};
        String[] expected = {"Fredrik", "Erik", "Ulf", "Simon", "Kent"};


        //Act
        String[] actual = Arr.merge(names, moreNames);

        //Assert
        assertArrayEquals(expected, actual);

    }
}