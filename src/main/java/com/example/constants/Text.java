package com.example.constants;

import java.util.Calendar;

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

    // Toolbar items
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


    public static final String TITLE = "Название:";
    public static final String CODE = "Код валюты:";
    public static final String BASE = "Сделать базовой:";
    public static final String ON = "Включить:";
    public static final String RATE = "Курс:";
    public static final String ACCOUNT = "Счёт:";
    public static final String FROM_ACCOUNT = "Откуда:";
    public static final String TO_ACCOUNT = "Куда:";
    public static final String CURRENCY = "Валюта:";
    public static final String ARTICLE = "Статья:";
    public static final String START_AMOUNT = "Начальный баланс:";
    public static final String FROM_AMOUNT = "Снято:";
    public static final String TO_AMOUNT = "Зачислено:";
    public static final String AMOUNT = "Сумма:";
    public static final String NOTICE = "Примечание:";
    public static final String DATE = "Дата:";

    // Panel items
    public static final String BALANCE_CURRENCIES = "Баланс по валютам:";
    public static final String FULL_BALANCE = "Итоговый баланс:";


    // FileChooser items
    public static final String FC_SAVE = "Сохранить";
    public static final String FC_OPEN = "Открыть";
    public static final String FC_CANCEL = "Отмена";
    public static final String FC_UPDATE = "Обновить";
    public static final String FC_HELP = "Помощь";

    public static final String FC_FOLDER = "Папка:";
    public static final String FC_HOME = "Домой";

    public static final String FC_OPEN_DIRECTORY = "Открыть папку";
    public static final String FC_NEW_DIRECTORY = "Новая папка";
    public static final String FC_NAME_FILE = "Имя файла:";
    public static final String FC_TYPE_FILE = "Тип файла:";

    public static final String FC_VIEW = "Вид";
    public static final String FC_UP = "Вверх";
    public static final String FC_LIST = "Список";
    public static final String FC_TABLE = "Таблица";
    public static final String FC_NAME = "Имя";
    public static final String FC_SIZE = "Размер";
    public static final String FC_TYPE = "Тип";
    public static final String FC_DATE = "Дата";
    public static final String FC_ATTR = "Атрибуты";
    public static final String FC_ALL_FILTER = "Все файлы";

    // Dialogs items
    public static final String DIALOG_ABOUT_TITLE = "О программе";
    public static final String ABOUT = "<html>" +
                                                "<body style='font-size: 120%; text-align: center; width: 300px'>" +
                                                        "<h1>Финансовый помощник</h1>" +
                                                        "<p><img src='file:images/wallet.png' height='100'/></p>" +
                                                        "<p>Программа сделана как тестовый проект.</p>" +
                                                        "<p style='font-size: normal'>Разработчик: Александр Штундер" +
                                                        "<br>@ Copyright " + Calendar.getInstance().get(Calendar.YEAR)  + "</p>" +
                                                "</body>" +
                                        "</html>";
    public static final String ADD = "Добавить";
    public static final String EDIT = "Изменить";
    public static final String CANCEL = "Отменить";

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
    public static final String ERROR = "Ошибка";
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
