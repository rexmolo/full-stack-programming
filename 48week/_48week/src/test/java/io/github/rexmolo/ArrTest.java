package io.github.rexmolo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    void indexOf() {
        //Arrange
        String[] moreNames = {"Fredrik", "Erik", "Ulf", "Simon", "Kent"};
        int expectedIndex = 2;

        //Act
        int index = Arr.indexOf(moreNames, "ulf");

        assertEquals(expectedIndex, index);
    }

    @Test
    void copyOf(){
        int[] numberArr = {5,6};
        int[] exceptedArr = {5,6};

        int[] actual = Arr.copyOf(numberArr);
        assertEquals(Arrays.toString(numberArr), Arrays.toString(exceptedArr));
    }

}