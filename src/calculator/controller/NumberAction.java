package calculator.controller;

import calculator.model.Calculator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NumberAction implements EventHandler<ActionEvent> {

    private final Calculator calculator;
    private final int number;

    public NumberAction(Calculator calculator, int theNumber){
        this.calculator = calculator;
        this.number = theNumber;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.calculator.numberPressed(this.number);
    }
}