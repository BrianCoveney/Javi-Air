package model;

/**
 * Created by brian on 18/01/17.
 */
public enum Day{


    MONDAY(DayType.WEEKDAY), TUESDAY(DayType.WEEKDAY),
    WEDNESDAY(DayType.WEEKDAY), THURSDAY(DayType.WEEKDAY),
    FRIDAY(DayType.WEEKEND),
    SATURDAY(DayType.WEEKEND),
    SUNDAY(DayType.WEEKEND);


    private final DayType dayType;

    Day(DayType dayType) {
        this.dayType = dayType;
    }




}

