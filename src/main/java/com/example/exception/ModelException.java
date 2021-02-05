package com.example.exception;

import static com.example.constants.Text.*;

public class ModelException extends Exception {
    public static final int TITLE_EMPTY = 0;
    public static final int IS_EXISTS = 1;
    public static final int DATE_FORMAT = 2;
    public static final int CODE_EMPTY = 3;
    public static final int CURRENCY_EMPTY = 4;
    public static final int ARTICLE_EMPTY = 5;
    public static final int ACCOUNT_EMPTY = 6;
    public static final int RATE_INCORRECT = 7;
    public static final int AMOUNT_FORMAT = 8;
    public static final int NO_BASE_CURRENCY = 9;

    private final int code;

    public ModelException(int code) {
        this.code = code;
    }

    public String getMessage() {
        switch (code) {
            case 0:
                return ERROR_TITLE_EMPTY;
            case 1:
                return ERROR_IS_EXISTS;
            case 2:
                return ERROR_DATE_FORMAT;
            case 3:
                return ERROR_CODE_EMPTY;
            case 4:
                return ERROR_CURRENCY_EMPTY;
            case 5:
                return ERROR_ARTICLE_EMPTY;
            case 6:
                return ERROR_ACCOUNT_EMPTY;
            case 7:
                return ERROR_RATE_INCORRECT;
            case 8:
                return ERROR_AMOUNT_FORMAT;
            case 9:
                return ERROR_NO_BASE_CURRENCY;
            default:
                return "";
        }
    }
}
