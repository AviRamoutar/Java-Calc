package calculator.model;

public class SubtractOperation implements Operation {
    public double apply(double lhs, double rhs){
        return lhs - rhs;
    }
}
