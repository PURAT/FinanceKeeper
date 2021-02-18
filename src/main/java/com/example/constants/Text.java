package com.example.constants;

public final class Text {
    public static final String PROGRAM_NAME = "Домашняя бухгалтерия";

    // Menu items
    public static final String MENU_FILE = "Файл";
    public static final String MENU_EDIT = "Правка";
    public static final String MENU_VIEW = "Вид";
    public static final String MENU_HELP = "Помощь";

    public static final String MENU_FILE_NEW = "Новый";
    public static final String MENU_FILE_OPEN = "Открыть";
    public static final String MENU_FILE_SAVE = "Сохранить";
    public static final String MENU_FILE_UPDATE_CURRENCIES = "Обновить курс валют";
    public static final String MENU_FILE_EXIT = "Выход";

    public static final String MENU_EDIT_ADD = "Добавить";
    public static final String MENU_EDIT_EDIT = "Изменить";
    public static final String MENU_EDIT_DELETE = "Удалить";

    public static final String MENU_VIEW_OVERVIEW = "Обзор";
    public static final String MENU_VIEW_ACCOUNTS = "Счета";
    public static final String MENU_VIEW_ARTICLES = "Статьи";
    public static final String MENU_VIEW_TRANSACTIONS = "Транзакции";
    public static final String MENU_VIEW_TRANSFERS = "Переводы";
    public static final String MENU_VIEW_CURRENCIES = "Валюты";
    public static final String MENU_VIEW_STATISTICS = "Статистика";

    public static final String MENU_HELP_ABOUT = "О программе";

    public static final String TOOLBAR_OVERVIEW = "Обзор";
    public static final String TOOLBAR_ACCOUNTS = "Счета";
    public static final String TOOLBAR_ARTICLES = "Статьи";
    public static final String TOOLBAR_TRANSACTIONS = "Транзакции";
    public static final String TOOLBAR_TRANSFERS = "Переводы";
    public static final String TOOLBAR_CURRENCIES = "Валюты";
    public static final String TOOLBAR_STATISTICS = "Статистика";

    public static final String TOOLBAR_ADD = "Добавить";
    public static final String TOOLBAR_EDIT = "Изменить";
    public static final String TOOLBAR_DELETE = "Удалить";

    public static String[] getMonths() {
        return new String[] {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
    }

    public static final String JANUARY = "Январь";
    public static final String FEBRUARY = "Февраль";
    public static final String MARCH = "Март";
    public static final String APRIL = "Апрель";
    public static final String MAY = "Май";
    public static final String JUNE = "Июнь";
    public static final String JULY = "Июль";
    public static final String AUGUST = "Август";
    public static final String SEPTEMBER = "Сентябрь";
    public static final String OCTOBER = "Октябрь";
    public static final String NOVEMBER = "Ноябрь";
    public static final String DECEMBER = "Декабрь";

    // Errors
    public static final String ERROR_TITLE_EMPTY = "Вы не ввели название!";
    public static final String ERROR_IS_EXISTS = "Такая запись не существует!";
    public static final String ERROR_DATE_FORMAT = "Неккоректный формат даты!";
    public static final String ERROR_CODE_EMPTY = "Вы не указали код!";
    public static final String ERROR_CURRENCY_EMPTY = "Вы не выбрали валюту!";
    public static final String ERROR_ARTICLE_EMPTY = "Вы не выбрали статью!";
    public static final String ERROR_ACCOUNT_EMPTY = "Вы не выбрали счёт!";
    public static final String ERROR_RATE_INCORRECT = "Неккоректное значение курса!";
    public static final String ERROR_AMOUNT_FORMAT = "Неккоректный формат суммы!";
    public static final String ERROR_NO_BASE_CURRENCY = "Необходимо выбрать базовую валюту!";

    // Answers
    public static final String YES = "Да";
    public static final String NO = "Нет";
}
