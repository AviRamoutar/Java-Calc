package calculator.controller;

import calculator.model.Calculator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AdditionAction implements EventHandler<ActionEvent> {

    private final Calculator calculator;

    public AdditionAction(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.calculator.addPressed();
    }
}