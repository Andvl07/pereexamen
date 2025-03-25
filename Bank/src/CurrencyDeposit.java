
public class CurrencyDeposit extends BankDeposit {
    private String currencyType;  // Объявляем приватное поле currencyType для хранения типа валюты
    private double exchangeRate;  // Объявляем приватное поле exchangeRate для хранения курса обмена

    // Конструктор класса CurrencyDeposit
    public CurrencyDeposit(double balance, String currencyType, double exchangeRate) {
        super(balance); // Вызываем конструктор базового класса
        this.currencyType = currencyType; // Присваиваем значение параметра currencyType полю currencyType объекта
        this.exchangeRate = exchangeRate; // Присваиваем значение параметра exchangeRate полю exchangeRate объекта
    }

    // Возвращает тип валюты вклада.
    public String getCurrencyType() {
        return currencyType; // Возвращаем значение поля currencyType
    }

    // Возвращает курс валюты.
    public double getExchangeRate() {
        return exchangeRate; // Возвращаем значение поля exchangeRate
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.05 * exchangeRate; // Пример: ставка + курс
    }

    @Override
    public String toString() {
        return String.format("%s, Тип: Валютный (%s), Курс: %.2f", super.toString(), currencyType, exchangeRate); // Форматируем строку для представления объекта
    }
}