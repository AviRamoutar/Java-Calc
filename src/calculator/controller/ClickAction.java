package calculator.controller;

import calculator.view.CalculatorGUI;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickAction implements EventHandler<MouseEvent> {

    private final CalculatorGUI gui;

    public ClickAction(CalculatorGUI calculator){
        this.gui = calculator;
    }

    @Override
    public void handle(MouseEvent actionEvent) {
        this.gui.updateDisplay();
    }
}