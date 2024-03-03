import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product(1, "Ноутбук", "Потужний ноутбук для роботи та розваг", 1200.0f, new Category("Електроніка")));
        inventory.addProduct(new Product(2, "Футболка", "Комфортна футболка для повсякденного використання", 25.0f, new Category("Одяг")));
        inventory.addProduct(new Product(3, "Мобільний телефон", "Сучасний смартфон з великим екраном та потужною камерою", 800.0f, new Category("Електроніка")));
        inventory.addProduct(new Product(4, "Шорти", "Зручні шорти для активного відпочинку", 35.0f, new Category("Одяг")));
        inventory.addProduct(new Product(5, "Велосипед", "Легкий та швидкий велосипед для поїздок по місту", 500.0f, new Category("Спорт")));

        Cart cart = new Cart();
        OrderHistory orderHistory = new OrderHistory();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Переглянути список товарів");
            System.out.println("2. Додати товар до кошика");
            System.out.println("3. Переглянути кошик");
            System.out.println("4. Зробити замовлення");
            System.out.println("5. Переглянути історію замовлень");
            System.out.println("6. Пошук товару за назвою");
            System.out.println("7. Пошук товару за категорією");
            System.out.println("8. Вийти");

            System.out.print("Виберіть опцію: ");
            try {
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1 -> inventory.displayProducts();
                    case 2 -> cart.addToCart(inventory, scanner);
                    case 3 -> cart.displayCart();
                    case 4 -> cart.placeOrder(orderHistory);
                    case 5 -> orderHistory.displayOrderHistory();
                    case 6 -> {
                        System.out.print("Введіть назву товару для пошуку: ");
                        String name = scanner.nextLine();
                        inventory.searchByName(name);
                    }
                    case 7 -> {
                        System.out.print("Введіть категорію товару для пошуку: ");
                        String categoryName = scanner.nextLine();
                        inventory.searchByCategory(categoryName);
                    }
                    case 8 -> exit = true;
                    default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Невірний ввід. Будь ласка, введіть число від 1 до 8.");
            }
        }
    }
}
