
public interface Manageable {
    
    // Пополняет баланс.
    void deposit(double amount);

    // Снимает деньги (если разрешено условиями).
    void withdraw(double amount);
}