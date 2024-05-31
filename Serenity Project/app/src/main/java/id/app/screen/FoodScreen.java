package id.app.screen;

import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import id.app.App;
import id.app.Controller.FoodsController;
import javafx.scene.layout.StackPane;
import id.app.Data.Foods;
import java.util.List;

public class FoodScreen {
    private App app;
    private Scene scene;
    private int column;
    private int row;

    public FoodScreen(App app) {
        this.app = app;
        foodScreen();
    }

    private void foodScreen() {
        List<Foods> foods = FoodsController.getFoodsByProvinsiId(app.getSelectedProvinsiId());
        String provinsiName = FoodsController.getProvinsiNameById(app.getSelectedProvinsiId());

        Pane root = new Pane();
        StackPane stack = new StackPane();

        Text page = new Text(provinsiName != null ? provinsiName : "FOOD PAGE");
        page.getStyleClass().add("logo-text3");

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
        btnLng1.setOnAction(e -> app.showUserScreen());

        Image image1 = new Image(getClass().getResource("/image/back.png").toExternalForm());

        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(45);
        imageView1.setFitHeight(45);
        imageView1.getStyleClass().add("backbtn");
        imageView1.setOnMouseClicked(e -> app.showUserScreen());

        GridPane vbox = new GridPane();
        vbox.setHgap(24);
        vbox.setVgap(10);

        for (Foods food : foods) {
            Label foodLabel = new Label("• " + food.getNama());
            foodLabel.getStyleClass().add("datas");
            foodLabel.setPadding(new Insets(10, 75, 10, 75));
            foodLabel.setOnMouseClicked(event -> {
                System.out.println(food.getNama());
                app.setSelectedFood(food.getNama());
                app.showFoodDetailScreen();
            });
            vbox.add(foodLabel,column,row);
            vbox.setAlignment(Pos.CENTER);
            row++;
            if (row == 11) {
                row = 0;
                column++;
            }
        }

        stack.getChildren().addAll(border, page, vbox, btnLng1,imageView1);
        stack.setAlignment(Pos.CENTER);
        StackPane.setAlignment(page, Pos.TOP_LEFT);
        StackPane.setAlignment(btnLng1, Pos.TOP_LEFT);
        StackPane.setAlignment(imageView1, Pos.TOP_LEFT);

        root.getChildren().addAll(stack);

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