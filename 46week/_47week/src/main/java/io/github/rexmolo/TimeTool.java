package io.github.rexmolo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeTool {


    public static void printCtl(int signal) {
        switch (signal) {
            case 1:
                System.out.println(getCurrentDay());
                break;
            case 2:
                System.out.println(getCurrentDaySpecialFormat());
                break;
            case 3:
                System.out.println(getCurrentDaySpecialFormat());
                break;
            default:
                System.out.println(getCurrentDaySpecialFormat());
        }
    }

    /**
     *
     * @return example: 2023-11-20
     */
    public static LocalDate getCurrentDay() {
        return LocalDate.now();
    }


    public static String getCurrentDaySpecialFormat(){
        LocalDateTime ldt = LocalDateTime.now();
        return ldt.format(DateTimeFormatter.ofLocalizedPattern("E d M"));
    }

}
