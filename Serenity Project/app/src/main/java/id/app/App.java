package id.app;

import id.app.screen.AdminScreen;
import id.app.screen.LogScreen;
import id.app.screen.ProvinsiPage;
import javafx.application.Application;
import javafx.scene.image.*;
import javafx.stage.Stage;

public class App extends Application {
    private Stage primaryStage;

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("FOODIES");
        primaryStage.setMinWidth(1280);
        primaryStage.setMinHeight(720);
        primaryStage.setMaxWidth(1920);
        primaryStage.setMaxHeight(1080);
        primaryStage.getIcons().add(new Image("image/FoodiesLogo.png"));
        showLogScreen();
    }

    public void showLogScreen() {
        LogScreen mainScene = new LogScreen(this);
        primaryStage.setScene(mainScene.getScene());
        primaryStage.show();
    }

    public void showProvinsi() {
        ProvinsiPage provScene = new ProvinsiPage(this);
        primaryStage.setScene(provScene.getScene());
        primaryStage.show();
    }

    public void showAdminScreen() {
        AdminScreen adminScene = new AdminScreen(this);
        primaryStage.setScene(adminScene.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
