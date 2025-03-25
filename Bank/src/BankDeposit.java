
import java.text.DateFormat; // Импортируем класс DateFormat для форматирования даты
import java.text.SimpleDateFormat; // Импортируем класс SimpleDateFormat для задания формата даты
import java.util.Date; // Импортируем класс Date для работы с датами

public abstract class BankDeposit implements InterestBearing, Manageable {
    private int depositId;           // Объявляем приватное поле depositId для хранения уникального идентификатора вклада
    private double balance;         // Объявляем приватное поле balance для хранения текущего баланса
    private Date openingDate;       // Объявляем приватное поле openingDate для хранения даты открытия
    private static int nextDepositId = 1;  // Объявляем статическое поле nextDepositId для автоматической генерации ID
    private static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy"); // Объявляем константу для формата даты

    // Конструктор класса BankDeposit
    public BankDeposit(double balance) {
        this.depositId = nextDepositId++; // Автоматически генерируем ID и увеличиваем nextDepositId
        this.balance = balance; // Присваиваем значение параметра balance полю balance объекта
        this.openingDate = new Date(); // Создаем объект Date с текущей датой и присваиваем его полю openingDate
    }

    // Возвращает уникальный идентификатор вклада.
    public int getDepositId() {
        return depositId; // Возвращаем значение поля depositId
    }

    // Возвращает текущий баланс вклада.
    public double getBalance() {
        return balance; // Возвращаем значение поля balance
    }

    // Возвращает дату открытия вклада.
    public Date getOpeningDate() {
        return openingDate; // Возвращаем значение поля openingDate
    }

    // Устанавливает значение баланса вклада.
    protected void setBalance(double balance) {
        this.balance = balance; // Присваиваем значение параметра balance полю balance объекта
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount; // Увеличиваем баланс на указанную сумму
        System.out.println("Вклад пополнен на " + amount + ". Новый баланс: " + balance); // Выводим сообщение о пополнении вклада
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) { // Проверяем, достаточно ли средств на балансе
            this.balance -= amount; // Уменьшаем баланс на указанную сумму
            System.out.println("Со вклада снято " + amount + ". Новый баланс: " + balance); // Выводим сообщение о снятии средств
        } else {
            System.out.println("Недостаточно средств на вкладе."); // Выводим сообщение о нехватке средств
        }
    }

    @Override
    public abstract double calculateInterest(); // Абстрактный метод, реализуется в подклассах

    @Override
    public void applyInterest() {
        double interest = calculateInterest(); // Вычисляем процентный доход
        this.balance += interest; // Увеличиваем баланс на сумму процентов
        System.out.println("Начислены проценты на вклад: " + interest + ". Новый баланс: " + balance); // Выводим сообщение о начислении процентов
    }

    public String getOpeningDateFormatted() {
        return dateFormat.format(openingDate); // Форматируем дату открытия вклада
    }

    @Override
    public String toString() {
        return String.format("Вклад, Баланс: %.2f, Открыт: %s", balance, getOpeningDateFormatted()); // Форматируем строку для представления объекта
    }
}