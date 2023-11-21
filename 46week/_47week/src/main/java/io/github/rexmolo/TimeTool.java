package io.github.rexmolo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import static java.time.temporal.ChronoField.DAY_OF_WEEK;

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

    public static void printLastMondayAndLoopEntireWeek() {
        LocalDate ld = LocalDate.now();
        LocalDate lastMonday = ld.minusWeeks(1).with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
//        System.out.println(lastMonday);
        System.out.println("Last Monday is: " + lastMonday);

        System.out.println("The entire week is :");
        for (int i = 0; i < 7; i++) {
            LocalDate nextDay = lastMonday.plusDays(i);
            String dayOfWeek = nextDay.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
            System.out.printf("%s is: %s%n", dayOfWeek, nextDay.format(DateTimeFormatter.ISO_LOCAL_DATE));
        }

    }

}
