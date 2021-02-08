package com.example;

import com.example.exception.ModelException;
import com.example.model.*;
import com.example.saveload.SaveData;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.settings.Settings.PATH_ROBOTO_LIGHT;


public class FinanceKeeper {

    public static void main(String[] args) {
        init();
        // generate models
//        try {
//            testModels();
//        } catch (ModelException e) {
//            e.getMessage();
//        }

        SaveData data = SaveData.getInstance();
        System.out.println(data);
    }


    private static void init() {
        try {
            GraphicsEnvironment graphEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            graphEnv.registerFont(Font.createFont(Font.TRUETYPE_FONT, PATH_ROBOTO_LIGHT));
        } catch (FontFormatException | IOException e) {
            Logger.getLogger(FinanceKeeper.class.getName()).log(Level.SEVERE, "Problems with fonts...", e);
        }
    }

    private static void testModels() throws ModelException {
        Currency rub = new Currency("Рубль", "RUB", 1, true, true);
        Currency usd = new Currency("Доллар", "USD", 75, true, false);
        Currency euro = new Currency("Евро", "EUR", 89, false, false);
        Currency uah = new Currency("Гривна", "UAH", 2.7, false, false);

        Account ac1 = new Account("Банковский депозит (RUB)", rub, 100000);
        Account ac2 = new Account("Банковский депозит (USD)", usd, 0);
        Account ac3 = new Account("Кошелёк", rub, 10000);
        Account ac4 = new Account("Карта Visa", rub, 0);

        Article article1 = new Article("Продукты");
        Article article2 = new Article("Столовая");
        Article article3 = new Article("ЖКХ");
        Article article4 = new Article("Зарплата");
        Article article5 = new Article("Проценты по депозиту");

        ArrayList<Currency> currencies = new ArrayList<>();
        currencies.add(rub);
        currencies.add(usd);
        currencies.add(euro);
        currencies.add(uah);

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);
        accounts.add(ac4);

        ArrayList<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);

        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(ac3, article1, -700, "На выходные"));
        transactions.add(new Transaction(ac3, article3, -2400, "Основаня квартира"));
        transactions.add(new Transaction(ac3, article3, -1340, "Дача"));
        transactions.add(new Transaction(ac1, article5, 5000, new Date(new Date().getTime() - (long) 86400000 * 20)));
        transactions.add(new Transaction(ac2, article4, 11000, "Биржа", new Date(new Date().getTime() - (long) 86400000 * 5)));
        transactions.add(new Transaction(ac3, article2, -210));
        transactions.add(new Transaction(ac4, article4, 1200, "На подарок"));

        for (int i = 0; i < 50; i++) {
            Account tempAccount;
            Article tempArticle;
            if (Math.random() < 0.5) tempAccount = ac1;
            else tempAccount = ac3;
            if (Math.random() < 0.5) tempArticle = article1;
            else tempArticle = article2;
            double tempAmount = Math.round(Math.random() * (-1000));
            Date tempDate = new Date((long) (new Date().getTime() - (long) 86400000 * 30 * Math.random()));
            transactions.add(new Transaction(tempAccount, tempArticle, tempAmount, tempDate));
        }

        ArrayList<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(ac1, ac3, 3500, 3500));
        transfers.add(new Transfer(ac1, ac3, 1000, 1000));
        transfers.add(new Transfer(ac1, ac2, 6000, 90));

        for (Account account: accounts) {
            account.setAmountFromTransactionsAndTransfers(transactions, transfers);
        }

        SaveData data = SaveData.getInstance();
        data.setAccounts(accounts);
        data.setArticles(articles);
        data.setCurrencies(currencies);
        data.setTransactions(transactions);
        data.setTransfers(transfers);
        data.save();
        System.out.println(data);
    }
}
