import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private int clickCount = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Demo");

        // Labels
        Label titleLabel = new Label("Welcome to JavaFX!");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label infoLabel = new Label(String.format("Java: %s  |  JavaFX: %s", javaVersion, javafxVersion));
        infoLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #7f8c8d;");

        Label counterLabel = new Label("Button clicked: 0 times");
        counterLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #34495e;");

        // Button
        Button actionButton = new Button("Click Me!");
        actionButton.setStyle(
            "-fx-background-color: #3498db; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 14px; " +
            "-fx-padding: 8px 16px; " +
            "-fx-background-radius: 6px; " +
            "-fx-cursor: hand;"
        );

        actionButton.setOnAction(e -> {
            clickCount++;
            counterLabel.setText("Button clicked: " + clickCount + " time" + (clickCount == 1 ? "" : "s"));
        });

        // Layout
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 30px; -fx-background-color: #ecf0f1;");
        layout.getChildren().addAll(titleLabel, infoLabel, actionButton, counterLabel);

        // Scene and Stage
        Scene scene = new Scene(layout, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
