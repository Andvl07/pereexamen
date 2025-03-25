
public class SavingsDeposit extends BankDeposit {
    private double minBalance;  // Объявляем приватное поле minBalance для хранения минимального баланса
    private double monthlyTopUp; // Объявляем приватное поле monthlyTopUp для хранения ежемесячного пополнения

    // Конструктор класса SavingsDeposit
    public SavingsDeposit(double balance, double minBalance, double monthlyTopUp) {
        super(balance); // Вызываем конструктор базового класса
        this.minBalance = minBalance; // Присваиваем значение параметра minBalance полю minBalance объекта
        this.monthlyTopUp = monthlyTopUp; // Присваиваем значение параметра monthlyTopUp полю monthlyTopUp объекта
    }

    // Возвращает минимальный баланс на вкладе.
    public double getMinBalance() {
        return minBalance; // Возвращаем значение поля minBalance
    }

    // Возвращает сумму ежемесячного пополнения вклада.
    public double getMonthlyTopUp() {
        return monthlyTopUp; // Возвращаем значение поля monthlyTopUp
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount); // Разрешаем пополнение (вызываем метод базового класса)
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02; // Пример: небольшая фиксированная ставка
    }

    @Override
    public String toString() {
        return String.format("%s, Тип: Накопительный, Мин. баланс: %.2f, Ежемес. пополнение: %.2f", super.toString(), minBalance, monthlyTopUp); // Форматируем строку для представления объекта
    }
}