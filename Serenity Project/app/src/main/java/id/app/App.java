package id.app;

import id.app.Controller.FoodsController;
import id.app.screen.LoginScreen;
import id.app.screen.UserScreen;
import id.app.screen.FoodScreen;
import id.app.screen.FoodDetailScreen;
import id.app.screen.AdminLoginScreen;
import id.app.screen.AdminRegisterScreen;
import id.app.screen.AdminScreen;
import id.app.screen.EditorScreen;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    private Stage primaryStage;
    private int selectedProvinsiId;
    private String selectedFood;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("FOODIES");
        primaryStage.setWidth(1280);
        primaryStage.setHeight(720);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("image/FoodiesLogo.png"));

        FoodsController.loadAllFoods();
        
        showLoginScreen();
    }

    public void showLoginScreen() {
        LoginScreen mainScene = new LoginScreen(this);
        primaryStage.setScene(mainScene.getScene());
        primaryStage.show();
    }

    public void showUserScreen() {
        UserScreen userScene = new UserScreen(this);
        primaryStage.setScene(userScene.getScene());
        primaryStage.show();
    }

    public void showAdminLoginScreen() {
        AdminLoginScreen adminLoginScene = new AdminLoginScreen(this);
        primaryStage.setScene(adminLoginScene.getScene());
        primaryStage.show();
    }

    public void showAdminRegisterScreen() {
        AdminRegisterScreen adminRegisterScene = new AdminRegisterScreen(this);
        primaryStage.setScene(adminRegisterScene.getScene());
        primaryStage.show();
    }

    public void showAdminScreen() {
        AdminScreen adminScene = new AdminScreen(this);
        primaryStage.setScene(adminScene.getScene());
        primaryStage.show();
    }

    public void showFoodScreen() {
        FoodScreen foodScene = new FoodScreen(this);
        primaryStage.setScene(foodScene.getScene());
        primaryStage.show();
    }

    public void showFoodDetailScreen() {
        FoodDetailScreen foodDetailScene = new FoodDetailScreen(this);
        primaryStage.setScene(foodDetailScene.getScene());
        primaryStage.show();
    }

    public void showEditorScreen() {
        EditorScreen editorScene = new EditorScreen(this);
        primaryStage.setScene(editorScene.getScene());
        primaryStage.show();
    }

    public int getSelectedProvinsiId() {
        return selectedProvinsiId;
    }

    public void setSelectedProvinsiId(int selectedProvinsiId) {
        this.selectedProvinsiId = selectedProvinsiId;
    }

    public String getSelectedFood() {
        return selectedFood;
    }

    public void setSelectedFood(String selectedFood) {
        this.selectedFood = selectedFood;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
