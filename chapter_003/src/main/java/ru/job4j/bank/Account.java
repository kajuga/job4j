package ru.job4j.bank;

public class Account {
    private String details;
    private double cash;


    public Account(String details, double cash) {
        this.details = details;
        this.cash = cash;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Зачисление суммы cash на счет (с проверкой)
     * @param cash
     * @return
     */
    public boolean refill(double cash) {
        boolean result = false;
        if (this.cash >= 0 && cash >= 0){
            this.cash += cash;
            result = true;
        }
        return result;
    }

    /**
     * Списание суммы cash со счета (с проверкой)
     * @param cash
     * @return
     */
    public boolean writeOff(double cash) {
        boolean result = false;
        if (this.cash > 0 && this.cash > cash) {
            this.cash -= cash;
            result = true;
        }
        return result;
    }
}