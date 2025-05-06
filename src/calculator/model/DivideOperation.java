package calculator.model;

public final class DivideOperation implements Operation {
    public double apply(double lhs, double rhs){
        return lhs / rhs;
    }
}
