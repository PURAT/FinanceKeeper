package com.example.util;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateFilter {
    public static final int STEP_DAY = 0;
    public static final int STEP_MONTH = 1;
    public static final int STEP_YEAR = 2;

    private int step;
    private Date fromDate;
    private Date toDate;

    public DateFilter() {
        this.step = STEP_MONTH;
        setRange(new GregorianCalendar());
    }

    public DateFilter(int step) {
        this.step = step;
        setRange(new GregorianCalendar());
    }

    public int getStep() {
        return step;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void next() {
        offset(1);
    }

    public void previous() {
        offset(-1);
    }

    public void nextStep() {
        step++;
        if (step > 2)
            step = STEP_DAY;
        setRange(new GregorianCalendar());
    }

    public boolean checkDate(Date date) {
        return (date.compareTo(fromDate) > 0) && (date.compareTo(toDate) < 0);
    }

    private void offset(int count) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fromDate);
        switch (step) {
            case STEP_DAY:
                calendar.add(Calendar.DAY_OF_MONTH, count);
                break;
            case STEP_MONTH:
                calendar.add(Calendar.MONTH, count);
                break;
            case STEP_YEAR:
                calendar.add(Calendar.YEAR, count);
        }
        setRange(calendar);
    }

    private void setRange(Calendar calendar) {
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        switch (step) {
            case STEP_DAY:
                this.fromDate = new GregorianCalendar(currentYear, currentMonth,
                        currentDay, 0,0,0).getTime();
                this.toDate = new GregorianCalendar(currentYear, currentMonth,
                        currentDay, 23, 59, 59).getTime();
                break;
            case STEP_MONTH:
                // In YearMonth months counting starts with 1,
                // but in Calendar month counting starts with 0
                YearMonth yearMonth = YearMonth.of(currentYear, currentMonth + 1);
                this.fromDate = new GregorianCalendar(currentYear, currentMonth,
                        1, 0,0,0).getTime();
                this.toDate = new GregorianCalendar(currentYear, currentMonth,
                        yearMonth.lengthOfMonth(),23,59, 59).getTime();
                break;
            case STEP_YEAR:
                this.fromDate = new GregorianCalendar(currentYear, Calendar.JANUARY,
                        1, 0, 0, 0).getTime();
                this.toDate = new GregorianCalendar(currentYear, Calendar.DECEMBER,
                        31, 23, 59, 59).getTime();
        }
    }
}
