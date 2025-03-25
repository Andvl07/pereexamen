
import java.util.ArrayList; // Импортируем класс ArrayList для создания динамического списка
import java.util.List; // Импортируем интерфейс List для работы со списками

public class Client {
    private String name;          // Объявляем приватное поле name для хранения имени клиента
    private int id;               // Объявляем приватное поле id для хранения уникального идентификатора клиента
    private String contactInfo;   // Объявляем приватное поле contactInfo для хранения контактной информации клиента
    private List<BankDeposit> deposits; // Объявляем приватное поле deposits для хранения списка вкладов клиента
    private static int nextClientId = 1; // Объявляем статическое поле nextClientId для автоматической генерации ID

    // Конструктор класса Client
    public Client(String name, String contactInfo) {
        this.name = name; // Присваиваем значение параметра name полю name объекта
        this.id = nextClientId++;  // Автоматически генерируем ID и увеличиваем nextClientId
        this.contactInfo = contactInfo; // Присваиваем значение параметра contactInfo полю contactInfo объекта
        this.deposits = new ArrayList<>(); // Создаем новый пустой список для хранения вкладов
    }

    // Возвращает имя клиента.
    public String getName() {
        return name; // Возвращаем значение поля name
    }

    // Возвращает уникальный идентификатор клиента.
    public int getId() {
        return id; // Возвращаем значение поля id
    }

    // Возвращает контактную информацию клиента.
    public String getContactInfo() {
        return contactInfo; // Возвращаем значение поля contactInfo
    }

    // Возвращает список вкладов клиента.
    public List<BankDeposit> getDeposits() {
        return deposits; // Возвращаем значение поля deposits
    }

    // Открыть вклад
    public void openDeposit(Bank bank, BankDeposit deposit) {
        deposits.add(deposit); // Добавляем новый вклад в список вкладов
        bank.addDeposit(deposit); // Добавляем вклад в банковскую систему
        System.out.println("Клиент " + name + " открыл вклад."); // Выводим сообщение об открытии вклада
    }

    // Закрыть вклад
    public void closeDeposit(Bank bank, BankDeposit deposit) {
        if (deposits.contains(deposit)) { // Проверяем, содержится ли вклад в списке вкладов
            deposits.remove(deposit); // Удаляем вклад из списка вкладов
            bank.removeDeposit(deposit); // Удаляем вклад из банковской системы
            System.out.println("Клиент " + name + " закрыл вклад."); // Выводим сообщение о закрытии вклада
        } else {
            System.out.println("Вклад не найден у клиента."); // Выводим сообщение, если вклад не найден
        }
    }

    @Override
    public String toString() {
        return String.format("Клиент: %s, Контакт: %s", name, contactInfo); // Форматируем строку для представления объекта
    }
}