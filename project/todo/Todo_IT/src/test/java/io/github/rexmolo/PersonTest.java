package io.github.rexmolo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;


class PersonTest {


    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", ""})
    void testFirstNameNotNull(String firstName){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Person(firstName, "M", "ttt@aa.com");
        });

        Assertions.assertEquals("firstName Not allowed to be null", thrown.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", ""})
    void testLastNameNotNull(String lastname){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Person("jackie", lastname, "ttt@aa.com");
        });

        Assertions.assertEquals("lastName Not allowed to be null", thrown.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", ""})
    void testEmailNotNull(String email){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Person("jackie", "M", email);
        });

        Assertions.assertEquals("email Not allowed to be null", thrown.getMessage());
    }

//    static Stream<Arguments> personExceptionTestDataProvider(){
//        return Stream.of(
//                arguments("", "Ma", null),
//                arguments("jackie", null, null),
//                arguments("jackie", null, "ttt@aa.com"),
//                arguments(" ", " ", "ttt@aa.com")
//        );
//    }
}