package com.example.util;


import com.example.constants.Text;
import com.example.model.Currency;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {
    public static final String FORMAT_AMOUNT = "%.2f";
    public static final String FORMAT_RATE = "%.4f";
    public static final String FORMAT_DATE = "dd.MM.yyyy";
    public static final String FORMAT_DATE_MONTH = "MMMM yyyy";
    public static final String FORMAT_DATE_YEAR = "yyyy";

    public static String formatAmountToString(double amount) {
        return String.format(FORMAT_AMOUNT, amount);
    }

    public static String formatAmountWithCurrencyToString(double amount, Currency currency) {
        return formatAmountToString(amount) + " " + currency.getCode();
    }

    public static String formatRateToString(double rate) {
        return String.format(FORMAT_RATE, rate);
    }

    public static String formatRateWithCurrencyToString(double rate, Currency currency) {
        return formatRateToString(rate) + " " + currency.getCode();
    }

    public static String formatDateToString(Date date) {
        return new SimpleDateFormat(FORMAT_DATE, new MyDateFormatSymbols()).format(date);
    }

    public static String formatDateMonthToString(Date date) {
        return new SimpleDateFormat(FORMAT_DATE_MONTH, new MyDateFormatSymbols()).format(date);
    }

    public static String formatDateYearToString(Date date) {
        return new SimpleDateFormat(FORMAT_DATE_YEAR, new MyDateFormatSymbols()).format(date);
    }

    public static double formatAmountToNumber(String amount) throws NumberFormatException {
        amount = amount.replace(",", ".");
        return Double.parseDouble(amount);
    }

    public static String formatDateFromTitle(DateFilter filter) {
        Date date = filter.getToDate();
        switch (filter.getStep()) {
            case DateFilter.STEP_DAY:
                return formatDateToString(date);
            case DateFilter.STEP_MONTH:
                return formatDateMonthToString(date);
            case DateFilter.STEP_YEAR:
                return formatDateYearToString(date);
        }
        return "";
    }

    public static String formatYesNo(boolean yes) {
        if (yes)
            return Text.YES;
        return Text.NO;
    }

    private static class MyDateFormatSymbols extends DateFormatSymbols {

        @Override
        public String[] getMonths() {
            return Text.getMonths();
        }
    }

}
