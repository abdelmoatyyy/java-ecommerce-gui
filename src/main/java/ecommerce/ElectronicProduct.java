package ecommerce;

public class ElectronicProduct extends Product {

  private String brand;
  private int warantyPeriod;

  ElectronicProduct(
    int id,
    String name,
    double price,
    String brand,
    int warantyPeriod
  ) {
    super(id, name, price);
    this.brand = brand;
    this.warantyPeriod = Math.abs(warantyPeriod);
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public int getWarantyPeriod() {
    return warantyPeriod;
  }

  public void setWarantyPeriod(int warantyPeriod) {
    this.warantyPeriod = warantyPeriod;
  }
}
