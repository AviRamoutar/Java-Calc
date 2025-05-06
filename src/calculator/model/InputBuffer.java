package calculator.model;

abstract class InputBuffer {
    abstract String asString();

    abstract InputBuffer appendDigit(int dig);

    abstract InputBuffer decimal();

    double value() {
        return Double.parseDouble(asString());
    }


    public static final class Plain extends InputBuffer {
        private final String string;

         Plain(){
            this("0");
        }

         Plain(String set){
            string = set;
        }

         String asString(){
            return string;
        }

         InputBuffer appendDigit(int d){
            return new Plain(string + d);
        }
         InputBuffer decimal(){
            return new Decimal(string + ".");
        }
    }

    public static final class Decimal extends InputBuffer{
        private String string2uh;
        private Decimal(String set){
            string2uh = set;
        }
         String asString(){
            return string2uh;
        }

         InputBuffer appendDigit(int d){
            return new Decimal(string2uh + d);
        }
         InputBuffer decimal(){
            return this;
        }
    }

}