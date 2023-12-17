package com.myStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new Transaction(brian, 2011, 300));
        transactions.add(new Transaction(raoul, 2012, 1000));
        transactions.add(new Transaction(raoul, 2011, 400));
        transactions.add(new Transaction(mario, 2012, 710));
        transactions.add(new Transaction(mario, 2012, 700));
        transactions.add(new Transaction(alan, 2012, 950));

        // 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        List<Transaction> result1 = new ArrayList<Transaction>();
        for (Transaction t : transactions) {
            if (t.getYear() == 2011) {
                result1.add(t);
            }
        }
        Collections.sort(result1, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                return t1.getValue().compareTo(t2.getValue());
            }
        });
        System.out.println("Результаты задания 1:");
        for (Transaction transaction : result1) {
            System.out.println(transaction);
        }

        // 2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        HashSet<String> cities = new HashSet<String>();
        for (Transaction t : transactions) {
            cities.add(t.getTrader().getCity());
        }
        System.out.println("\nРезультаты задания 2:");
        for (String city : cities) {
            System.out.println(city);
        }

        // 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        List<Trader> tradersFromCambridge = new ArrayList<Trader>();
        for (Transaction t : transactions) {
            if (t.getTrader().getCity().equals("Cambridge")) {
                tradersFromCambridge.add(t.getTrader());
            }
        }
        Collections.sort(tradersFromCambridge, new Comparator<Trader>() {
            @Override
            public int compare(Trader t1, Trader t2) {
                return t1.getName().compareTo(t2.getName());
            }
        });

        // 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        List<String> traderNames = new ArrayList<String>();
        for (Transaction t : transactions) {
            if (!traderNames.contains(t.getTrader().getName())) {
                traderNames.add(t.getTrader().getName());
            }
        }
        Collections.sort(traderNames);
        System.out.println("\nРезультаты задания 3:");
        for (Trader trader : tradersFromCambridge) {
            System.out.println(trader);
        }

        // 5. Выяснить, существует ли хоть один трейдер из Милана.
        boolean traderFromMilanExists = false;
        for (Transaction t : transactions) {
            if (t.getTrader().getCity().equals("Milan")) {
                traderFromMilanExists = true;
                break;
            }
        }
        System.out.println("\nРезультаты задания 5:");
        System.out.println(traderFromMilanExists ? "Да" : "Нет");

        // 6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        int sumOfCambridgeTransactions = 0;
        for (Transaction t : transactions) {
            if (t.getTrader().getCity().equals("Cambridge")) {
                sumOfCambridgeTransactions += t.getValue();
            }
        }
        System.out.println("\nРезультаты задания 6:");
        System.out.println(sumOfCambridgeTransactions);

        // 7. Какова максимальная сумма среди всех транзакций?
        int maxAmount = 0;
        for (Transaction t : transactions) {
            if (t.getValue() > maxAmount) {
                maxAmount = t.getValue();
            }
        }
        System.out.println("\nРезультаты задания 7:");
        System.out.println(maxAmount);

        // 8. Найти транзакцию с минимальной суммой.
        Transaction minAmountTransaction = null;
        for (Transaction t : transactions) {
            if (minAmountTransaction == null || t.getValue() < minAmountTransaction.getValue()) {
                minAmountTransaction = t;
            }
        }
        System.out.println("\nРезультаты задания 8:");
        System.out.println(minAmountTransaction);

    }
}




