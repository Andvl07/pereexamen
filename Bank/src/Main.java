public class Main {
    public static void main(String[] args) { // Главный метод программы
        // Создаем банк
        Bank bank = new Bank(); // Создаем новый объект Bank

        // Создаем клиентов
        Client client1 = new Client("Иван Иванов", "ivan@example.com"); // Создаем нового клиента
        Client client2 = new Client("Мария Петрова", "maria@example.com"); // Создаем нового клиента

        // Добавляем клиентов в банк
        bank.addClient(client1); // Добавляем первого клиента в банк
        bank.addClient(client2); // Добавляем второго клиента в банк

        // Создаем вклады для клиентов
        FixedTermDeposit fixedDeposit1 = new FixedTermDeposit(10000, 12, 0.08); // Создаем срочный вклад
        SavingsDeposit savingsDeposit1 = new SavingsDeposit(5000, 1000, 500); // Создаем накопительный вклад
        CurrencyDeposit currencyDeposit1 = new CurrencyDeposit(2000, "USD", 80.0); // Создаем валютный вклад

        // Открываем вклады для клиентов
        client1.openDeposit(bank, fixedDeposit1); // Открываем вклад для первого клиента
        client2.openDeposit(bank, savingsDeposit1); // Открываем вклад для второго клиента
        client2.openDeposit(bank, currencyDeposit1); // Открываем вклад для второго клиента

        // Проводим операции по вкладам
        savingsDeposit1.deposit(1000); // Пополняем накопительный вклад
        currencyDeposit1.withdraw(500); // Снимаем валюту (если хватает)

        // Начисляем проценты в конце дня
        bank.processDayEndInterest(); // Начисляем проценты по всем вкладам

        // Выводим информацию о клиентах и вкладах
        System.out.println("\nИнформация о клиентах и вкладах:"); // Выводим заголовок
        for (Client client : bank.getClients()) { // Итерируемся по списку клиентов
            System.out.println(client); // Выводим информацию о клиенте (используем toString)
            for (BankDeposit deposit : client.getDeposits()) { // Итерируемся по списку вкладов клиента
                System.out.println("  " + deposit); // Выводим информацию о вкладе (используем toString)
            }
        }

        // Пример закрытия вклада
        client1.closeDeposit(bank, fixedDeposit1); // Закрываем вклад для первого клиента

        // Выводим информацию о вкладах после закрытия
        System.out.println("\nВклады в банке после закрытия:"); // Выводим заголовок
        for (BankDeposit deposit : bank.getDeposits()) { // Итерируемся по списку вкладов
            System.out.println(deposit);  // Выводим информацию о вкладе (используем toString)
        }
    }
}