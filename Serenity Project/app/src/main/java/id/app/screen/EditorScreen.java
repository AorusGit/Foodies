package id.app.screen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import id.app.App;
import id.app.Controller.FoodsController;
import id.app.Data.Foods;

import java.util.List;

public class EditorScreen {
    private App app;
    private Scene scene;
    private TableView<Foods> tableView;
    private ObservableList<Foods> data;

    private TextField nameField;
    private TextArea descriptionField;

    public EditorScreen(App app) {
        this.app = app;
        editorScreen();
    }

    private void editorScreen() {
        List<Foods> foods = FoodsController.getFoodsByProvinsiId(app.getSelectedProvinsiId());
        String provinsiName = FoodsController.getProvinsiNameById(app.getSelectedProvinsiId());

        BorderPane root = new BorderPane();
        StackPane stack = new StackPane();

        Text page = new Text(provinsiName != null ? provinsiName : "FOOD PAGE");
        page.getStyleClass().add("logo-text3");

        Rectangle kotak = new Rectangle();
        kotak.setHeight(70);
        kotak.getStyleClass().add("InnBox");
        kotak.widthProperty().bind(app.getPrimaryStage().widthProperty());

        BorderPane border = new BorderPane();
        border.setTop(kotak);

        tableView = createFoodTable(foods);

        nameField = new TextField();
        nameField.setPromptText("Nama Makanan...");
        nameField.setPrefWidth(40);
        nameField.setPrefHeight(10);
        nameField.getStyleClass().add("namaMakanan");

        descriptionField = new TextArea();
        descriptionField.setId("descriptionArea");
        descriptionField.setPromptText("Deskripsi...");
        descriptionField.setPrefWidth(350);
        descriptionField.setPrefHeight(350);
        descriptionField.setWrapText(true);
        descriptionField.getStyleClass().add("deskMakanan");

        Button addButton = new Button("Add");
        addButton.setId("addButton");
        addButton.getStyleClass().add("addButton");
        addButton.setOnAction(e -> addFood(nameField.getText(), descriptionField.getText()));

        Button updateButton = new Button("Update");
        updateButton.setId("updateButton");
        updateButton.getStyleClass().add("updateButton");
        updateButton.setOnAction(e -> updateFood(nameField.getText(), descriptionField.getText()));

        Button deleteButton = new Button("Delete");
        deleteButton.setId("deleteButton");
        deleteButton.getStyleClass().add("deleteButton");
        deleteButton.setOnAction(e -> deleteFood());

        VBox fieldBox = new VBox(10, nameField, descriptionField);
        fieldBox.setAlignment(Pos.TOP_CENTER);
        fieldBox.setPadding(new Insets(20, 20, 20, 20));

        HBox buttonBox = new HBox(10, fieldBox, addButton, updateButton, deleteButton);
        buttonBox.setAlignment(Pos.TOP_CENTER);
        buttonBox.setPadding(new Insets(20, 20, 20, 20));

        Button btnLng1 = new Button();
        btnLng1.setShape(new Circle(100));
        btnLng1.setMinSize(50, 50);
        btnLng1.getStyleClass().add("btnLing1");
        btnLng1.setOnAction(e -> app.showAdminScreen());

        Image image1 = new Image(getClass().getResource("/image/back.png").toExternalForm());
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(45);
        imageView1.setFitHeight(45);
        imageView1.getStyleClass().add("backbtn");
        imageView1.setOnMouseClicked(e -> app.showAdminScreen());

        stack.getChildren().addAll(border, page, btnLng1, imageView1);
        stack.setAlignment(Pos.CENTER);
        StackPane.setAlignment(page, Pos.TOP_LEFT);
        StackPane.setAlignment(btnLng1, Pos.TOP_LEFT);
        StackPane.setAlignment(imageView1, Pos.TOP_LEFT);

        VBox centerBox = new VBox();
        centerBox.setAlignment(Pos.CENTER);
        centerBox.getChildren().add(tableView);

        StackPane leftStack = new StackPane(centerBox);
        leftStack.setAlignment(Pos.CENTER_LEFT);
        StackPane.setMargin(centerBox, new Insets(0, 0, 0, 50)); // Add margin to the left

        root.setTop(stack);
        root.setLeft(leftStack);
        root.setRight(buttonBox);

        scene = new Scene(root);
        applyStylesheet();
    }

    private TableView<Foods> createFoodTable(List<Foods> foods) {
        TableView<Foods> tableView = new TableView<>();
        tableView.setPrefWidth(900);
        tableView.setPrefHeight(500);
        data = FXCollections.observableArrayList(foods);
        tableView.setItems(data);

        TableColumn<Foods, String> nameColumn = new TableColumn<>("Nama Makanan");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        nameColumn.setPrefWidth(160);

        TableColumn<Foods, String> descriptionColumn = new TableColumn<>("Deskripsi Makanan");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        descriptionColumn.setPrefWidth(730);

        descriptionColumn.setCellFactory(tc -> {
            TableCell<Foods, String> cell = new TableCell<Foods, String>() {
                private Text text = new Text();

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setGraphic(null);
                    } else {
                        text.setText(item);
                        text.wrappingWidthProperty().bind(descriptionColumn.widthProperty());
                        setGraphic(text);
                    }
                }
            };
            return cell;
        });

        tableView.getColumns().addAll(nameColumn, descriptionColumn);

        tableView.setRowFactory(tv -> new TableRow<>() {
            @Override
            protected void updateItem(Foods item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty) {
                    setStyle("-fx-background-color: #F5DEB3;"); // Warna coklat muda
                } else {
                    setStyle("");
                }
            }
        });

        tableView.setRowFactory(tv -> {
            TableRow<Foods> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Foods rowData = row.getItem();
                    app.setSelectedFood(rowData.getNama());
                    nameField.setText(rowData.getNama());
                    descriptionField.setText(rowData.getDeskripsi());
                }
            });
            return row;
        });

        return tableView;
    }

    private void addFood(String name, String description) {
        if (name.isEmpty() || description.isEmpty()) {
            showAlert("Input Error", "Name and description cannot be empty");
            return;
        }
        Foods newFood = new Foods(0, name, description, "");
        data.add(newFood);
        FoodsController.addFood(newFood);
    }

    private void updateFood(String name, String description) {
        Foods selectedFood = tableView.getSelectionModel().getSelectedItem();
        if (selectedFood == null) {
            showAlert("Selection Error", "No food selected");
            return;
        }
        if (name.isEmpty() || description.isEmpty()) {
            showAlert("Input Error", "Name and description cannot be empty");
            return;
        }
        selectedFood.setNama(name);
        selectedFood.setDeskripsi(description);
        tableView.refresh();
        FoodsController.updateFood(selectedFood);
    }

    private void deleteFood() {
        Foods selectedFood = tableView.getSelectionModel().getSelectedItem();
        if (selectedFood == null) {
            showAlert("Selection Error", "No food selected");
            return;
        }
        data.remove(selectedFood);
        FoodsController.deleteFood(selectedFood);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void applyStylesheet() {
        String css = this.getClass().getResource("/css/Style.css").toExternalForm();
        scene.getStylesheets().add(css);
    }

    public Scene getScene() {
        return scene;
    }

    public TableView<Foods> getTableView() {
        return tableView;
    }
}
