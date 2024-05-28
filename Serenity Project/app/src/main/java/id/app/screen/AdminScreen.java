package id.app.screen;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import id.app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;

public class AdminScreen {
    private App app;
    private Scene scene;

    public AdminScreen(App app) {
        this.app = app;
        adminScreen();
    }

    private void adminScreen(){
        Pane root = new Pane();
        StackPane stack = new StackPane();
        root.getChildren().addAll(stack);

        Text page = new Text("ADMIN PAGE");
        page.getStyleClass().add("logo-text3");

        Button addButton = new Button("ADD MENU");
        Rectangle box = new Rectangle(430,70);
        box.setArcWidth(50);
        box.setArcHeight(50);
        addButton.setShape(box);
        addButton.setMinSize(430,70);
        addButton.setId("addButton");

        Button updateButton = new Button("UPDATE MENU");
        Rectangle box1 = new Rectangle(430,70);
        box1.setArcWidth(50);
        box1.setArcHeight(50);
        updateButton.setShape(box1);
        updateButton.setMinSize(430,70);
        updateButton.setId("updateButton");

        Button deleteButton = new Button("DELETE MENU");
        Rectangle box2 = new Rectangle(430,70);
        box2.setArcWidth(50);
        box2.setArcHeight(50);
        deleteButton.setShape(box2);
        deleteButton.setMinSize(430,70);
        deleteButton.setId("deleteButton");

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
        btnLng1.setOnAction(e -> app.showLogScreen());

        Image image1 = new Image(getClass().getResource("/image/back.png").toExternalForm());

        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(45);
        imageView1.setFitHeight(45);
        imageView1.getStyleClass().add("backbtn");
        imageView1.setOnMouseClicked(e -> app.showLogScreen());

        stack.getChildren().addAll(border,page,btnLng1,imageView1,addButton,updateButton,deleteButton);
        stack.setAlignment(Pos.CENTER);
        StackPane.setAlignment(page, Pos.TOP_LEFT);
        StackPane.setAlignment(btnLng1, Pos.TOP_LEFT);
        StackPane.setAlignment(imageView1, Pos.TOP_LEFT);


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
