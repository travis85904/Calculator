public class Calculator {
    public Calculator() {

    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public int modulus(double a, double b) {
        int intA = (int) a;
        int intB = (int) b;
        return (intA % intB);
    }

    public double invertValue(double a) {
        return (a * -1);
    }

}
