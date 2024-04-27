package ecommerce;

public class Order {

  private int orderId;
  private double totalPrice;
  private Cart cart;

  Order(Cart cart, int orderId, double totalPrice) {
    this.orderId = orderId;
    this.cart = cart;
    this.totalPrice = this.cart.calculatePrice();
  }

  public String printOrderInfo() {
    String s =
      "Here Is Your Order Summary : \n Order Id : " +
      this.orderId +
      "\nCustomer Id : " +
      this.cart.getCustomerId() +
      "\nProducts\n";
    System.out.println("Here Is Your Order Summary : ");
    System.out.println("Order Id :" + this.orderId);
    System.out.println("Customer Id : " + cart.getCustomerId());
    System.out.println("Products : ");
    for (int i = 0; i < cart.getProducts().length; i++) {
      System.out.println(
        cart.getProducts()[i].getName() +
        " - " +
        cart.getProducts()[i].getPrice() +
        " $"
      );
      String t =
        cart.getProducts()[i].getName() +
        " - " +
        cart.getProducts()[i].getPrice() +
        " $";
      s += t;
      s += "\n";
    }
    System.out.println("Total Price : " + this.totalPrice + " $");
    s += "Total Price : " + this.totalPrice + " $";
    return s;
  }
}
