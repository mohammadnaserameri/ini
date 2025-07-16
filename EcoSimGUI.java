import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class EcoSimGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Input fields
        TextField aField = new TextField();
        TextField bField = new TextField();
        TextField xField = new TextField();
        Button calculateBtn = new Button("Calculate");

        // Output label
        Label resultLabel = new Label();

        // Chart setup
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Growth Simulation");

        calculateBtn.setOnAction(e -> {
            try {
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());
                int x = Integer.parseInt(xField.getText());

                if (b <= 0 || b == 1 || x < 0) {
                    resultLabel.setText("Invalid input. 'b' must be > 0 and ≠ 1, and 'x' ≥ 0.");
                    chart.getData().clear();
                    return;
                }

                double power = 1.0;
                XYChart.Series<Number, Number> series = new XYChart.Series<>();
                series.setName("Growth Over Time");

                for (int i = 0; i <= x; i++) {
                    if (i > 0) power *= b;
                    double value = a * power;
                    series.getData().add(new XYChart.Data<>(i, value));
                }

                resultLabel.setText(String.format("Estimated growth after %d weeks: %.2f cm", x, a * power));
                chart.getData().clear();
                chart.getData().add(series);

            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
                chart.getData().clear();
            }
        });

        VBox inputBox = new VBox(10,
                new Label("Initial growth (a) in cm:"), aField,
                new Label("Weekly growth rate (b):"), bField,
                new Label("Number of weeks (x):"), xField,
                calculateBtn, resultLabel, chart
        );

        inputBox.setStyle("-fx-padding: 20;");
        Scene scene = new Scene(inputBox, 600, 500);
        primaryStage.setTitle("EcoSim Calc – Growth Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}