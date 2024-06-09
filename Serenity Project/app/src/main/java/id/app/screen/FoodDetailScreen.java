package id.app.screen;

import id.app.App;
import id.app.Controller.FoodsController;
import id.app.Data.Foods;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.scene.control.*;

public class FoodDetailScreen {
    private App app;
    private Scene scene;

    public FoodDetailScreen(App app) {
        this.app = app;
        foodDetailScreen();
    }

    private void foodDetailScreen() {
        Foods food = FoodsController.getFoodById(app.getSelectedFood());

        Pane root = new Pane();
        StackPane stack = new StackPane();
        root.getChildren().addAll(stack);

        Text name = new Text(food.getNama());
        name.getStyleClass().add("logo-text3");

        Text deskripsi = new Text("Deskripsi"); // diatur posisinya jadi lebih baik
        deskripsi.getStyleClass().add("logo-text4");

        Rectangle kotak = new Rectangle();
        kotak.setHeight(70);
        kotak.getStyleClass().add("InnBox");
        kotak.widthProperty().bind(app.getPrimaryStage().widthProperty());

        BorderPane border = new BorderPane();
        border.setTop(kotak);

        Button btnLng1 = new Button();
        btnLng1.setShape(new Circle(100));
        btnLng1.setMinSize(50, 50);
        btnLng1.getStyleClass().add("btnLing1");
        btnLng1.setOnAction(e -> app.showFoodScreen());

        Image image1 = new Image(getClass().getResource("/image/back.png").toExternalForm());

        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(45);
        imageView1.setFitHeight(45);
        imageView1.getStyleClass().add("backbtn");
        imageView1.setOnMouseClicked(e -> app.showFoodScreen());


        Label description = new Label(food.getDeskripsi());
        description.setMaxWidth(1100);
        description.setWrapText(true);
        description.getStyleClass().add("dTexts");

        Rectangle box = new Rectangle(1200,550);
        box.setArcWidth(50);
        box.setArcHeight(50);
        box.setId("deskBox");

        StackPane deskBox = new StackPane();
        deskBox.getChildren().addAll(box,description);

        stack.getChildren().addAll(border,name,deskBox,deskripsi,btnLng1,imageView1);
        StackPane.setAlignment(name, Pos.TOP_LEFT);
        StackPane.setAlignment(btnLng1, Pos.TOP_LEFT);
        StackPane.setAlignment(imageView1, Pos.TOP_LEFT);
        StackPane.setAlignment(deskBox, Pos.CENTER);
        StackPane.setAlignment(deskripsi, Pos.TOP_LEFT);

        stack.prefWidthProperty().bind(app.getPrimaryStage().widthProperty());
        stack.prefHeightProperty().bind(app.getPrimaryStage().heightProperty());

        scene = new Scene(root);
        applyStylesheet();
    }

    private void applyStylesheet() {
        String css = this.getClass().getResource("/css/Style.css").toExternalForm();
        scene.getStylesheets().add(css);
    }

    public Scene getScene() {
        return scene;
    }
}
