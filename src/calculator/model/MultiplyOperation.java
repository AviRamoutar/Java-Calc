package calculator.model;

public class MultiplyOperation implements Operation {
    public double apply(double lhs, double rhs){
        return lhs * rhs;
    }
}
