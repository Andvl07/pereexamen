
public class FixedTermDeposit extends BankDeposit {
    private int termMonths;     // Объявляем приватное поле termMonths для хранения срока вклада в месяцах
    private double interestRate; // Объявляем приватное поле interestRate для хранения процентной ставки

    // Конструктор класса FixedTermDeposit
    public FixedTermDeposit(double balance, int termMonths, double interestRate) {
        super(balance); // Вызываем конструктор базового класса
        this.termMonths = termMonths; // Присваиваем значение параметра termMonths полю termMonths объекта
        this.interestRate = interestRate; // Присваиваем значение параметра interestRate полю interestRate объекта
    }

    // Возвращает срок вклада в месяцах.
    public int getTermMonths() {
        return termMonths; // Возвращаем значение поля termMonths
    }

    // Возвращает годовую процентную ставку.
    public double getInterestRate() {
        return interestRate; // Возвращаем значение поля interestRate
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate * termMonths / 12; // Вычисляем процентный доход для срочного вклада
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Снятие средств со срочного вклада до окончания срока невозможно."); // Выводим сообщение о невозможности снятия средств
    }

    @Override
    public String toString() {
        return String.format("%s, Тип: Срочный, Срок: %d мес., Ставка: %.2f", super.toString(), termMonths, interestRate); // Форматируем строку для представления объекта
    }
}