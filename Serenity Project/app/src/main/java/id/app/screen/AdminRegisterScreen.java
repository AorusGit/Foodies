package id.app.screen;

import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import id.app.App;


public class AdminRegisterScreen implements Show {
    private App app;
    private Scene scene;
    int column;
    int row;

    public AdminRegisterScreen(App app) {
        this.app = app;
        show();
    }

    private void adminRegisterScreen(){

        Pane root = new Pane();
        StackPane stack = new StackPane();

        Text page = new Text("REGISTER");
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
        btnLng1.setOnAction(e -> app.showLoginScreen());

        Image image1 = new Image(getClass().getResource("/image/back.png").toExternalForm());

        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(45);
        imageView1.setFitHeight(45);
        imageView1.getStyleClass().add("backbtn");
        imageView1.setOnMouseClicked(e -> app.showLoginScreen());

        TextField pancing = new TextField();
        pancing.setEditable(false);
        pancing.getStyleClass().add("usernameAdminField");

        Text signUp = new Text("Already have an account? Sign Up");
        signUp.getStyleClass().add("signUpLog");
        signUp.setUnderline(true);
        signUp.setOnMouseClicked(e -> app.showAdminLoginScreen());

        Button SignLog = new Button("Sign Up");
        Rectangle box = new Rectangle(410,65);
        box.setArcWidth(45);
        box.setArcHeight(45);
        SignLog.setShape(box);
        SignLog.setMinSize(430,70);
        SignLog.setId("signButton");
        SignLog.setOnAction(e -> {});

        Text nameText = new Text("Name        : ");
        nameText.getStyleClass().add("RnameAdminText");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter Name...");
        nameField.setMinWidth(500);
        nameField.setMaxWidth(500);
        nameField.setMinHeight(50);
        nameField.setMaxHeight(50);
        nameField.getStyleClass().add("RnameAdminField");

        Rectangle NFBox = new Rectangle(200, 30);
        NFBox.setArcWidth(30);
        NFBox.setArcHeight(30);
        NFBox.setWidth(500);
        NFBox.setHeight(50);
        NFBox.getStyleClass().add("RNameField");

        Text usernameText = new Text("Username : ");
        usernameText.getStyleClass().add("RusernameAdminText");

        TextField userNameField = new TextField();
        userNameField.setPromptText("Enter Username...");
        userNameField.setMinWidth(500);
        userNameField.setMaxWidth(500);
        userNameField.setMinHeight(50);
        userNameField.setMaxHeight(50);
        userNameField.getStyleClass().add("RusernameAdminField");

        Rectangle UNFBox = new Rectangle(200, 30);
        UNFBox.setArcWidth(30);
        UNFBox.setArcHeight(30);
        UNFBox.setWidth(500);
        UNFBox.setHeight(50);
        UNFBox.getStyleClass().add("RUNameField");


        Text passText = new Text("Password  : ");
        passText.getStyleClass().add("RpassAdminText");

        PasswordField passField = new PasswordField();
        passField.setPromptText("Enter Password...");
        passField.setMinWidth(500);
        passField.setMaxWidth(500);
        passField.setMinHeight(50);
        passField.setMaxHeight(50);
        passField.getStyleClass().add("RpassAdminField");

        Rectangle PFBox = new Rectangle(200, 30);
        PFBox.setArcWidth(30);
        PFBox.setArcHeight(30);
        PFBox.setWidth(500);
        PFBox.setHeight(50);
        PFBox.getStyleClass().add("RpassField");


        stack.getChildren().addAll(border,page, pancing,nameText,NFBox,usernameText,UNFBox,passText,PFBox,nameField,userNameField,passField,SignLog,signUp,btnLng1,imageView1);
        stack.setAlignment(Pos.CENTER);
        StackPane.setAlignment(page, Pos.TOP_LEFT);
        StackPane.setAlignment(btnLng1, Pos.TOP_LEFT);
        StackPane.setAlignment(imageView1, Pos.TOP_LEFT);
        StackPane.setAlignment(pancing, Pos.CENTER);
        StackPane.setAlignment(nameText, Pos.CENTER);
        StackPane.setAlignment(nameField, Pos.CENTER);
        StackPane.setAlignment(NFBox, Pos.CENTER);
        StackPane.setAlignment(usernameText, Pos.CENTER);
        StackPane.setAlignment(userNameField, Pos.CENTER);
        StackPane.setAlignment(UNFBox, Pos.CENTER);
        StackPane.setAlignment(passText, Pos.CENTER);
        StackPane.setAlignment(PFBox, Pos.CENTER);
        StackPane.setAlignment(passField, Pos.CENTER);
        StackPane.setAlignment(signUp, Pos.CENTER_RIGHT);
        StackPane.setAlignment(SignLog, Pos.CENTER);
        root.getChildren().addAll(stack);
        
        stack.prefWidthProperty().bind(app.getPrimaryStage().widthProperty());
        stack.prefHeightProperty().bind(app.getPrimaryStage().heightProperty());
    
        scene = new Scene(root);
        applyStylesheet();
    }

    public void show(){
        adminRegisterScreen();
    }
    private void applyStylesheet() {
        String css = this.getClass().getResource("/css/Style.css").toExternalForm();
        scene.getStylesheets().add(css);
    }

    public Scene getScene() {
        return scene;
    }
}
