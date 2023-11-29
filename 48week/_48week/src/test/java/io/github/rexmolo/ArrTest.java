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
        int[] expectedArr = {5,6};

        int[] actual = Arr.copyOf(numberArr);
        assertEquals(Arrays.toString(numberArr), Arrays.toString(expectedArr));
    }

    @Test
    void sort() {
        String[] sortArr = {"Paris", "London", "New York", "Stockholm"};
        String[] expected = {"London", "New York","Paris","Stockholm"};

        String[] actual = Arr.sort(sortArr);

        assertArrayEquals(expected, actual);
    }

//    @Test
//    void filter() {
//        int[] arr = {20, 20, 40, 20, 30, 40, 50, 60, 50};
//        int[] expectedArr = {20, 40, 30, 50, 60};
//
//        int[] actual = Arr.filter(arr);
//
//        assertArrayEquals(expectedArr, actual);
//    }

}