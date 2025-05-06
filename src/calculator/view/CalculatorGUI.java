package calculator.view;

import calculator.controller.*;
import calculator.model.Calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorGUI extends Application {

    private final Calculator model;
    private final TextField display;

    public CalculatorGUI() {
        super();
        this.model = new Calculator();
        this.display = this.createDisplay();
        this.updateDisplay();
    }

    private TextField createDisplay() {
        TextField display = new TextField();
        display.setEditable(false);
        display.setStyle("-fx-font: 16 ariel;");
        return display;
    }

    public void updateDisplay() {
        this.display.setText(String.valueOf(this.model.displayNumber()));
    }


    private Button createButton(String display, EventHandler<ActionEvent> action) {
        return this.createButton(display, action, 1.0, 1.0);
    }

    private Button createButton(String display, EventHandler<ActionEvent> action, double xScale, double yScale) {
        Button button = new Button();
        int buttonSize = 50;
        button.setMinWidth(buttonSize * xScale);
        button.setMinHeight(buttonSize * yScale);
        button.setOnAction(action);
        button.setText(display);
        button.setStyle("-fx-font: 18 ariel;");
        return button;
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Calculator");

        GridPane grid = new GridPane();
        grid.setHgap(0.0);
        grid.setVgap(0.0);

        grid.add(this.display, 0, 0, 4, 1);
        grid.add(this.createButton("c", new ClearAction(this.model)), 0, 1);
        grid.add(this.createButton("/", new DivisionAction(this.model)), 1, 1);
        grid.add(this.createButton("*", new MultiplicationAction(this.model)), 2, 1);
        grid.add(this.createButton("-", new SubtractionAction(this.model)), 3, 1);
        grid.add(this.createButton("+", new AdditionAction(this.model), 1.0, 2.0), 3, 2, 1, 2);
        grid.add(this.createButton("=", new EqualAction(this.model), 1.0, 2.0), 3, 4, 1, 2);

        grid.add(this.createButton("7", new NumberAction(this.model, 7)), 0, 2);
        grid.add(this.createButton("8", new NumberAction(this.model, 8)), 1, 2);
        grid.add(this.createButton("9", new NumberAction(this.model, 9)), 2, 2);
        grid.add(this.createButton("4", new NumberAction(this.model, 4)), 0, 3);
        grid.add(this.createButton("5", new NumberAction(this.model, 5)), 1, 3);
        grid.add(this.createButton("6", new NumberAction(this.model, 6)), 2, 3);
        grid.add(this.createButton("1", new NumberAction(this.model, 1)), 0, 4);
        grid.add(this.createButton("2", new NumberAction(this.model, 2)), 1, 4);
        grid.add(this.createButton("3", new NumberAction(this.model, 3)), 2, 4);

        grid.add(this.createButton("0", new NumberAction(this.model, 0), 2.0, 1.0), 0, 5, 2, 1);

        grid.add(this.createButton(".", new DecimalAction(this.model)), 2, 5);

        Scene scene = new Scene(grid);

        stage.addEventFilter(MouseEvent.MOUSE_CLICKED, new ClickAction(this));

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}