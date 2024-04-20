package ecommerce;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Global {

  static Cart cart;
  static Customer customer;
  static int orderCount = 0;
}

public class EcommerceSystemGUI extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Ecommerce");

    Label id_label = new Label("Please Enter Your Id ");
    Label name_label = new Label("Please Enter Your Name ");
    Label address_label = new Label("Please Enter Your Address ");
    Label cart_label = new Label("How Many Orders You Want To Add To Cart ");
    TextField id = new TextField();
    TextField name = new TextField();
    TextField address = new TextField();
    TextField cartn = new TextField();
    Button cont = new Button("Continue");
    VBox vbox = new VBox(
      id_label,
      id,
      name_label,
      name,
      address_label,
      address,
      cart_label,
      cartn,
      cont
    );
    Scene scene = new Scene(vbox);
    primaryStage.setScene(scene);
    primaryStage.show();
    Label selcet_label = new Label("Please Choose A Product ");
    ChoiceBox choiceBox = new ChoiceBox();
    choiceBox.getItems().add("Smartphone");
    choiceBox.getItems().add("T-Shirt");
    choiceBox.getItems().add("OOP");

    Button nextt = new Button("next");
    VBox cart_fill = new VBox(selcet_label, choiceBox, nextt);
    Scene cart_scene = new Scene(cart_fill);
    cont.setOnAction(event -> {
      int id_val = Integer.parseInt(id.getText());
      String name_val = name.getText();
      String address_val = address.getText();
      int cart_val = Integer.parseInt(cartn.getText());
      Global.customer = new Customer(id_val, name_val, address_val);
      Global.cart = new Cart(id_val, cart_val);
      primaryStage.setScene(cart_scene);
    });

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
    nextt.setOnAction(event -> {
      if (Global.cart.isFull()) {
        Label confirm = new Label(
          "Your Total is " +
          Global.cart.calculatePrice() +
          " $ . Do you Want To Place The Order"
        );
        Button y = new Button("Yes");
        Button n = new Button("No");
        VBox place_order = new VBox(confirm, y, n);
        Scene conf_scene = new Scene(place_order);
        primaryStage.setScene(conf_scene);
        y.setOnAction(e -> {
          Order order = new Order(
            Global.cart,
            ++Global.orderCount,
            Global.cart.calculatePrice()
          );
          Label o = new Label(order.printOrderInfo());
          VBox order_details = new VBox(o);
          Scene f_scene = new Scene(order_details);
          primaryStage.setScene(f_scene);
        });
        n.setOnAction(e -> {
          Label clo = new Label("Thank You For Using The App");
          VBox cl = new VBox(clo);
          Scene f = new Scene(cl);
          primaryStage.setScene(f);
        });
      }
      if (choiceBox.getValue().equals("T-Shirt")) {
        Global.cart.addProduct(tShirt);
      }
      if (choiceBox.getValue().equals("OOP")) {
        Global.cart.addProduct(oop);
      }
      if (choiceBox.getValue().equals("Smartphone")) {
        Global.cart.addProduct(smartPhone);
      }
      // primaryStage.setScene(cart_scene);
    });
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
