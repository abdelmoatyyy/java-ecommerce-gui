package ecommerce;

public class BookProduct extends Product {

  private String author;
  private String publisher;

  BookProduct(
    int id,
    String name,
    double price,
    String author,
    String publisher
  ) {
    super(id, name, price);
    this.author = author;
    this.publisher = publisher;
  }

  public String getPublisher() {
    return publisher;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
}
