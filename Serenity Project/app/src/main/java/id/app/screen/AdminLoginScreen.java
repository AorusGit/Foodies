package id.app.screen;

import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import id.app.Controller.userController;
import id.app.ETC.Show;
import id.app.App;

// poly 2
public class AdminLoginScreen implements Show {
    private App app;
    private Scene scene;
    int column;
    int row;
    private String validatedUserName;

    public AdminLoginScreen(App app) {
        this.app = app;
        show();
    }

    private void adminLoginScreen(){

        Pane root = new Pane();
        StackPane stack = new StackPane();

        Text page = new Text("SIGN IN");
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
        btnLng1.setOnAction(e -> app.showMainScreen());

        Image image1 = new Image(getClass().getResource("/image/back.png").toExternalForm());
        Image image2 = new Image(getClass().getResource("/image/Eyes.png").toExternalForm());
        Image image3 = new Image(getClass().getResource("/image/EyesHide.png").toExternalForm());

        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(45);
        imageView1.setFitHeight(45);
        imageView1.getStyleClass().add("backbtn");
        imageView1.setOnMouseClicked(e -> app.showMainScreen());

        ImageView imageView2 = new ImageView(image3);
        imageView2.setFitWidth(50);
        imageView2.setFitHeight(45);
        imageView2.getStyleClass().add("viewPassImages");

        TextField pancing = new TextField();
        pancing.setEditable(false);
        pancing.getStyleClass().add("usernameAdminField");

        Text usernameText = new Text("Username : ");
        usernameText.getStyleClass().add("usernameAdminText");

        TextField userNameField = new TextField();
        userNameField.setPromptText("Enter Username...");
        userNameField.setMinWidth(500);
        userNameField.setMaxWidth(500);
        userNameField.setMinHeight(50);
        userNameField.setMaxHeight(50);
        userNameField.getStyleClass().add("usernameAdminField"); // username

        Rectangle UNFBox = new Rectangle(200, 30);
        UNFBox.setArcWidth(30);
        UNFBox.setArcHeight(30);
        UNFBox.setWidth(500);
        UNFBox.setHeight(50);
        UNFBox.getStyleClass().add("NameField");


        Text passText = new Text("Password  : ");
        passText.getStyleClass().add("passAdminText");

        TextField passShow = new TextField();
        passShow.setManaged(false);
        passShow.setVisible(false);
        passShow.setPromptText("Enter Password...");
        passShow.setMinWidth(500);
        passShow.setMaxWidth(500);
        passShow.setMinHeight(50);
        passShow.setMaxHeight(50);
        passShow.getStyleClass().add("passAdminShow");// password tapi yang dapat menampilkan sandi

        PasswordField passField = new PasswordField();
        passField.setPromptText("Enter Password...");
        passField.setMinWidth(500);
        passField.setMaxWidth(500);
        passField.setMinHeight(50);
        passField.setMaxHeight(50);
        passField.getStyleClass().add("passAdminField");// password tersembunyi

        Rectangle PFBox = new Rectangle(200, 30);
        PFBox.setArcWidth(30);
        PFBox.setArcHeight(30);
        PFBox.setWidth(500);
        PFBox.setHeight(50);
        PFBox.getStyleClass().add("passField");

        Button vPass = new Button();
        vPass.setMinSize(50, 50);;
        vPass.getStyleClass().add("vpass1");
        passShow.textProperty().bindBidirectional(passField.textProperty());
        // tombol untuk menampakkan / menyembunyikan sandi
        vPass.setOnAction(event -> {
            if (passField.isVisible()) {
                passField.setVisible(false);
                passField.setManaged(false);
                passShow.setVisible(true);
                passShow.setManaged(true);
                imageView2.setImage(image2);
            } else {
                passField.setVisible(true);
                passField.setManaged(true);
                passShow.setVisible(false);
                passShow.setManaged(false);
                imageView2.setImage(image3);
            }
        });

        imageView2.setOnMouseClicked(event -> {
            if (imageView2.getImage() == image3) {
                passField.setVisible(false);
                passField.setManaged(false);
                passShow.setVisible(true);
                passShow.setManaged(true);
                imageView2.setImage(image2);
            } else {
                passField.setVisible(true);
                passField.setManaged(true);
                passShow.setVisible(false);
                passShow.setManaged(false);
                imageView2.setImage(image3);
            }
        });

        Button SignLog = new Button("Sign In");
        Rectangle box = new Rectangle(410,65);
        box.setArcWidth(45);
        box.setArcHeight(45);
        SignLog.setShape(box);
        SignLog.setMinSize(430,70);
        SignLog.setId("signButton");
        SignLog.setOnAction(e -> {
            String username = userNameField.getText();
            String password = passField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter your username and password");
                return;
            }

            if (userController.validateLogin(username, password)) {
                validatedUserName = userController.getValidatedUserName(username, password);
                showAlert(Alert.AlertType.INFORMATION, "Login Successful!", "Welcome back!");
                app.showAdminScreen(validatedUserName);
            } else {
                showAlert(Alert.AlertType.ERROR, "Login Failed!", "Invalid username or password");
            }
        });

        stack.getChildren().addAll(border,page, pancing, usernameText,UNFBox,passText,PFBox,userNameField,passField,passShow,SignLog,btnLng1,imageView1,vPass,imageView2);
        stack.setAlignment(Pos.CENTER);
        StackPane.setAlignment(page, Pos.TOP_LEFT);
        StackPane.setAlignment(btnLng1, Pos.TOP_LEFT);
        StackPane.setAlignment(imageView1, Pos.TOP_LEFT);
        StackPane.setAlignment(pancing, Pos.CENTER);
        StackPane.setAlignment(usernameText, Pos.CENTER);
        StackPane.setAlignment(userNameField, Pos.CENTER);
        StackPane.setAlignment(UNFBox, Pos.CENTER);
        StackPane.setAlignment(passText, Pos.CENTER);
        StackPane.setAlignment(PFBox, Pos.CENTER);
        StackPane.setAlignment(passField, Pos.CENTER);
        StackPane.setAlignment(passShow, Pos.CENTER);
        StackPane.setAlignment(SignLog, Pos.CENTER);
        StackPane.setAlignment(vPass, Pos.CENTER);
        StackPane.setAlignment(imageView2, Pos.CENTER);

        root.getChildren().addAll(stack);
        
        stack.prefWidthProperty().bind(app.getPrimaryStage().widthProperty());
        stack.prefHeightProperty().bind(app.getPrimaryStage().heightProperty());
    
        scene = new Scene(root);
        applyStylesheet();
    }

    public void show(){
        adminLoginScreen();
    }
    private void applyStylesheet() {
        String css = this.getClass().getResource("/css/Style.css").toExternalForm();
        scene.getStylesheets().add(css);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public Scene getScene() {
        return scene;
    }
}
