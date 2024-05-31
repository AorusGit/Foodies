package id.app.screen;

import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import id.app.App;
import javafx.scene.layout.StackPane;

public class LogScreen {
    private App app;
    private Scene scene;

    public LogScreen(App app) {
        this.app = app;
        mainScreen();
    }

    private void mainScreen(){
        Pane root = new Pane();
        StackPane stack = new StackPane();
        root.getChildren().addAll(stack);
    
        Text foodiesLogo = new Text("FOODIES");
        foodiesLogo.getStyleClass().add("logo-text2");

        Image image1 = new Image(getClass().getResource("/image/back1.png").toExternalForm());
        Image image2 = new Image(getClass().getResource("/image/back2.png").toExternalForm());
        Image image3 = new Image(getClass().getResource("/image/back3.png").toExternalForm());
        Image image4 = new Image(getClass().getResource("/image/admin.png").toExternalForm());
        Image image5 = new Image(getClass().getResource("/image/back5.png").toExternalForm());
        Image image6 = new Image(getClass().getResource("/image/back6.png").toExternalForm());

        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(571);
        imageView1.setFitHeight(686);
        imageView1.getStyleClass().add("img1");

        ImageView imageView2 = new ImageView(image1);
        imageView2.setFitWidth(571);
        imageView2.setFitHeight(686);
        imageView2.getStyleClass().add("img2");

        ImageView imageView3 = new ImageView(image2);
        imageView3.setFitWidth(321);
        imageView3.setFitHeight(490);
        imageView3.getStyleClass().add("img3");

        ImageView imageView4 = new ImageView(image2);
        imageView4.setFitWidth(321);
        imageView4.setFitHeight(490);
        imageView4.getStyleClass().add("img4");

        ImageView imageView5 = new ImageView(image3);
        imageView5.setFitWidth(327);
        imageView5.setFitHeight(332);
        imageView5.getStyleClass().add("img5");

        ImageView imageView6= new ImageView(image4);
        imageView6.setFitWidth(45);
        imageView6.setFitHeight(45);
        imageView6.getStyleClass().add("img6");
        imageView6.setOnMouseClicked(e -> app.showAdminScreen());

        ImageView imageView7 = new ImageView(image5);
        imageView7.getStyleClass().add("img7");

        ImageView imageView8 = new ImageView(image6);
        imageView8.getStyleClass().add("img8");

        Button menuButton = new Button("Menu");
        Rectangle box = new Rectangle(430,70);
        box.setArcWidth(50);
        box.setArcHeight(50);
        menuButton.setShape(box);
        menuButton.setMinSize(430,70);
        menuButton.setId("menuButton");
        menuButton.setOnAction(e -> app.showUserScreen());

        Button btnLng = new Button();
        btnLng.setShape(new Circle(100));
        btnLng.setMinSize(50, 50);
        btnLng.getStyleClass().add("btnLing");
        btnLng.setOnAction(e -> app.showAdminScreen());

        Rectangle kotak = new Rectangle();
        kotak.setHeight(70);
        kotak.getStyleClass().add("InnBox");
        kotak.widthProperty().bind(app.getPrimaryStage().widthProperty());

        BorderPane border = new BorderPane();
        border.setTop(kotak);

        stack.getChildren().addAll(foodiesLogo,imageView1,imageView2,imageView3,imageView4,imageView7,imageView8,border,imageView5,menuButton,btnLng,imageView6);
        StackPane.setAlignment(btnLng, Pos.TOP_RIGHT);
        StackPane.setAlignment(imageView6, Pos.TOP_RIGHT);
        StackPane.setAlignment(imageView1, Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(imageView2, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(imageView3, Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(imageView4, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(imageView5, Pos.CENTER);
        StackPane.setAlignment(imageView7, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(imageView8, Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(menuButton, Pos.CENTER);
        stack.setAlignment(Pos.CENTER);
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