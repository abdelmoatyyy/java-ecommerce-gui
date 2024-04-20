package ecommerce;

public class ClothingProduct extends Product {

  private String size;
  private String fabric;

  ClothingProduct(
    int id,
    String name,
    double price,
    String size,
    String fabric
  ) {
    super(id, name, price);
    this.size = size;
    this.fabric = fabric;
  }

  public String getSize() {
    return size;
  }

  public String getFabric() {
    return fabric;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public void setFabric(String fabric) {
    this.fabric = fabric;
  }
}
