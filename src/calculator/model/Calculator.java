package calculator.model;

public class Calculator {
    //Plan for layers
    //So well do priv inst varis at top
    //Operations 2nd
    //fill out the skeleton code after
    //then try out the "Fresh Start" idee I wrote down in lecture
    //First number handling followed by similar code for second number handling
    //some sort of idle state
    //result on screen state
    //then the reset extra cred
    //
    //This is actually the craziest shit legit everything could be like O(1)
    // run time if I lock in



    private State state;
    private double lhs = 0.0;
    private Operation pending = ADD;
    private Operation lastOp = ADD;
    private double lastArg = 0.0;
    private InputBuffer buffer;


    private static final Operation ADD = new AddOperation();
    private static final Operation SUBTRACT = new SubtractOperation();
    private static final Operation MULTIPLY = new MultiplyOperation();
    private static final Operation DIVIDE = new DivideOperation();


    public Calculator(){
        state = new Fresh();
        pending = ADD;
        lastOp = ADD;
    }

    // Accessed by View. You should edit this method as you build functionality
    public double displayNumber() {
        return state.display();
    }

    public void clearPressed() {
        state = state.clear();
    }

    public void numberPressed(int number) {
        state = state.number(number);
    }

    public void dividePressed() {
        state = state.div();
    }

    public void multiplyPressed() {
        state = state.mul();
    }

    public void subtractPressed() {
        state = state.sub();
    }

    public void addPressed() {
        state = state.add();
    }

    public void equalsPressed() {
        state = state.eq();
    }

    public void decimalPressed() {
        state = state.decimal();
    }

    //Begin Fresh Here





    private final class Fresh implements State{
        public double display(){
            return 0.0;
        }

        public State number(int d){
            buffer = new InputBuffer.Plain().appendDigit(d);
            return new First();
        }

        public State decimal(){
            buffer = new InputBuffer.Plain().decimal();
            return new First();
        }


        public State add(){
            return this;
        }

        public State sub(){
            return this;
        }

        public State mul(){
            return this;
        }

        public State div(){
            return this;
        }

        public State eq(){
            return this;
        }

        public State clear(){
            return this;
        }

    }


    //First thingy

    private final class First implements State{

        public double display(){
            return buffer.value();
        }
        public State number(int d) {
            buffer = buffer.appendDigit(d);
            return this;
        }


        public State decimal(){
            buffer = buffer.decimal();
            return this;
        }


        private State op(Operation o) {
            lhs = buffer.value(); pending = o;
            return new AwaitRhs();
        }


        public State add() {
            return op(ADD);
        }


        public State sub()   {
            return op(SUBTRACT);
        }


        public State mul()   {
            return op(MULTIPLY);
        }


        public State div()   {
            return op(DIVIDE);
        }

        public State eq()    {
            lhs = buffer.value(); return new ShowRes();
        }
        public State clear() {
            reset(); return new Fresh();
        }
    }

    private final class Second implements State {
        public double display(){
            return buffer.value();
        }

        public State number(int d) {
            buffer = buffer.appendDigit(d);
            return this;
        }


        public State decimal() {
            buffer = buffer.decimal();
            return this;
        }


        public State eq() {
            double rhs = buffer.value();
            lhs = pending.apply(lhs, rhs);
            lastOp = pending;
            lastArg = rhs;
            return new ShowRes();
        }

        public State add()   {
            return this;
        }

        public State sub() {
            return this;
        }

        public State mul() {
            return this;
        }

        public State div() {
            return this;
        }

        public State clear() {
            reset();
            return new Fresh();

        }
    }



    private final class AwaitRhs implements State{
        public double display(){
            return lhs;
        }


        public State number(int d) {
            buffer = new InputBuffer.Plain().appendDigit(d);
            return new Second();
        }


        public State decimal() {
            buffer = new InputBuffer.Plain().decimal();
            return new Second();
        }


        public State add() {
            return this;
        }

        public State sub() {
            return this;
        }

        public State mul() {
            return this;
        }

        public State div() {
            return this;
        }

        public State eq() {
            return this;
        }

        public State clear(){
            reset();
            return new Fresh();
        }
    }

    private final class ShowRes implements State {
        public double display() {
            return lhs;
        }

        private State op(Operation o) {
            pending = o;
            return new AwaitRhs();
        }

        public State add() {
            return op(ADD);
        }


        public State sub() {
            return op(SUBTRACT);
        }


        public State mul() {
            return op(MULTIPLY);
        }


        public State div() {
            return op(DIVIDE);
        }

        public State eq(){
            lhs = lastOp.apply(lhs,lastArg);
            return this;
        }

        public State number(int d){
            return this;
        }

        public State decimal(){
            return this;
        }

        public State clear(){
            reset();
            return new Fresh();
        }

    }

    //Just reset all the priv varis at top
    private void reset(){
        lhs = 0.0;
        pending = ADD;
        lastOp = ADD;
        lastArg = 0.0;
        buffer = null;
    }
}






