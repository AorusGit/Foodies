package id.app.screen;

import id.app.Controller.ProvinsiController;
import id.app.Data.Provinsi;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import id.app.App;
import java.util.*;

public class UserScreen {
    private App app;
    private Scene scene;
    int column;
    int row;

    public UserScreen(App app) {
        this.app = app;
        userScreen();
    }

    private void userScreen(){
        List<Provinsi> provinsis = ProvinsiController.getAllProvinsi();

        Pane root = new Pane();
        StackPane stack = new StackPane();

        Text page = new Text("USER PAGE");
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
        btnLng1.setOnAction(e -> app.showLogScreen());

        Image image1 = new Image(getClass().getResource("/image/back.png").toExternalForm());

        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(45);
        imageView1.setFitHeight(45);
        imageView1.getStyleClass().add("backbtn");
        imageView1.setOnMouseClicked(e -> app.showLogScreen());

        GridPane vbox = new GridPane();
        vbox.setHgap(24);
        vbox.setVgap(10);
        
        for ( Provinsi provinsi : provinsis) {
            Label province = new Label("• " + provinsi.getNama());
            province.getStyleClass().add("texts");
            province.setPadding(new Insets(10,75,10,75));
            province.setOnMouseClicked(event -> {
                app.setSelectedProvinsiId(provinsi.getId());
                System.out.println(provinsi.getId());
                app.showFoodScreen();
            });
            vbox.add(province,column,row);
            vbox.setAlignment(Pos.CENTER);
            row++;
            if (row == 11) {
                row = 0;
                column++;
            }

        }

        stack.getChildren().addAll(border,page,vbox,btnLng1,imageView1);
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

