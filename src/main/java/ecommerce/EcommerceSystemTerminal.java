package ecommerce;

import java.util.Scanner;

public class EcommerceSystemTerminal {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int ordersCount = 0;
    ecommerce.ElectronicProduct smartPhone = new ElectronicProduct(
      1,
      "smarthphone",
      599.99,
      "samsung",
      1
    );

    ClothingProduct tShirt = new ClothingProduct(
      2,
      "T-shirt",
      19.99,
      "Medium",
      "Cotton"
    );
    BookProduct oop = new BookProduct(
      3,
      "OOP",
      39.99,
      "O’Reilly",
      "X Publications"
    );

    int n, id;
    String name, address;
    System.out.println("Welcome To E-commerce System ! ");
    System.out.print("Please inter your id :  ");
    id = in.nextInt();
    System.out.print("Please Enter Your Name : ");
    name = in.next();
    System.out.print("Please Enter Your Address : ");
    address = in.next();

    Customer customer = new Customer(id, name, address);

    System.out.print("How Many Products You Want To Add To The Cart :  ");
    n = in.nextInt();

    Cart cart = new Cart(customer.getId(), n);
    int choice;
    for (int i = 0; i < n; i++) {
      System.out.println(
        "Which Product you want to add : 1 - smartphone  2 - T-shirt  3-OOP "
      );
      choice = in.nextInt();
      switch (choice) {
        case 1:
          cart.addProduct(smartPhone);
          break;
        case 2:
          cart.addProduct(tShirt);
          break;
        case 3:
          cart.addProduct(oop);
          break;
        default:
          System.out.println("Invalid Choice");
          break;
      }
    }

    System.out.println(
      "Your Total is " +
      cart.calculatePrice() +
      " $. Do You Want to Place an Order ? 1 - yes   2 - No"
    );
    choice = in.nextInt();
    switch (choice) {
      case 1:
        cart.placeOrder(++ordersCount);
        break;
      case 2:
        System.out.println("Thank You ! ");
        break;
      default:
        System.out.println("Invalid Choice ! ");
        break;
    }
    in.close();
  }
}
