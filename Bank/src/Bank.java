
import java.util.ArrayList; // Импортируем класс ArrayList для создания динамического списка
import java.util.List; // Импортируем интерфейс List для работы со списками

public class Bank {
    private List<Client> clients;     // Объявляем приватное поле clients для хранения списка клиентов
    private List<BankDeposit> deposits;   // Объявляем приватное поле deposits для хранения списка вкладов

    // Конструктор класса Bank
    public Bank() {
        this.clients = new ArrayList<>(); // Создаем новый пустой список для хранения клиентов
        this.deposits = new ArrayList<>(); // Создаем новый пустой список для хранения вкладов
    }

    // Возвращает список клиентов банка.
    public List<Client> getClients() {
        return clients; // Возвращаем значение поля clients
    }

    // Возвращает список вкладов банка.
    public List<BankDeposit> getDeposits() {
        return deposits; // Возвращаем значение поля deposits
    }

    // Добавить клиента
    public void addClient(Client client) {
        clients.add(client); // Добавляем нового клиента в список клиентов
        System.out.println("Клиент " + client.getName() + " добавлен в банк."); // Выводим сообщение о добавлении клиента
    }

    // Удалить клиента
    public void removeClient(Client client) {
        clients.remove(client); // Удаляем клиента из списка клиентов
        System.out.println("Клиент " + client.getName() + " удален из банка."); // Выводим сообщение об удалении клиента
    }

    // Добавить вклад
    public void addDeposit(BankDeposit deposit) {
        deposits.add(deposit); // Добавляем новый вклад в список вкладов
        System.out.println("Вклад добавлен в банк."); // Выводим сообщение о добавлении вклада
    }

    // Удалить вклад
    public void removeDeposit(BankDeposit deposit) {
        deposits.remove(deposit); // Удаляем вклад из списка вкладов
        System.out.println("Вклад удален из банка."); // Выводим сообщение об удалении вклада
    }

    // Начислить проценты всем вкладам
    public void processDayEndInterest() {
        System.out.println("Начисление процентов по всем вкладам..."); // Выводим сообщение о начале начисления процентов
        for (BankDeposit deposit : deposits) { // Итерируемся по списку вкладов
            deposit.applyInterest(); // Начисляем проценты на текущий вклад
        }
        System.out.println("Начисление процентов завершено."); // Выводим сообщение о завершении начисления процентов
    }

    public Client findClientById(int clientId) {
        for (Client client : clients) { // Итерируемся по списку клиентов
            if (client.getId() == clientId) { // Проверяем, совпадает ли ID клиента с искомым ID
                return client; // Возвращаем найденного клиента
            }
        }
        return null; // Возвращаем null, если клиент не найден
    }
}