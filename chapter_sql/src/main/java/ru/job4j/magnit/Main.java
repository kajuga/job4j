package ru.job4j.magnit;


public class Main {

    public static void main(String[] args) {
        Config config = new Config();

        config.init();
        try(StoreSQL storeSql = new StoreSQL(config);) {
            storeSql.generate(100);
            System.out.println(storeSql.findAll());

        }
    }
}