package ecommerce;

// Scanner in = new Scanner(System.in);
public class Cart {

  private int customerId;
  private int Nproducts;
  private Product[] products;
  private int pcount = 0;

  Cart(int customerId, int Nproducts) {
    this.customerId = customerId;
    this.Nproducts = Math.abs(Nproducts);
    products = new Product[Nproducts];
  }

  public void addProduct(Product p) {
    for (int i = 0; i < products.length; i++) {
      if (products[i] == null) {
        products[i] = p;
        pcount++;
        return;
      }
    }
    System.out.println("FULL");
    return;
  }

  public int getCustomerId() {
    return customerId;
  }

  public int getNproducts() {
    return Nproducts;
  }

  public Product[] getProducts() {
    return products;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public void setNproducts(int nproducts) {
    Nproducts = nproducts;
  }

  public void removeProduct(Product p) {
    for (int i = 0; i < Nproducts; i++) {
      if (products[i].getId() == p.getId()) {
        products[i] = null;
        break;
      }
    }
  }

  public double calculatePrice() {
    double sum = 0;
    for (int i = 0; i < products.length; i++) {
      sum += products[i].getPrice();
    }
    return sum;
  }

  boolean isFull() {
    return pcount == Nproducts;
  }

  // Plce Order
  public void placeOrder(int OrderId) {
    Order order = new Order(this, OrderId, this.calculatePrice());
    order.printOrderInfo();
  }
}
