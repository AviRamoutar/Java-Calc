package calculator.model;

public interface State {
    double display();

    State number(int d);
    State decimal();
    State add();
    State sub();
    State mul();
    State div();
    State eq();
    State clear();
}
