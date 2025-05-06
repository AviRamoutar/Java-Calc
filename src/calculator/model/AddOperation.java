package calculator.model;

public final class AddOperation implements Operation{
    public double apply(double lhs, double rhs){
        return lhs + rhs;
    }
}
