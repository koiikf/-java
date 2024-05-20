import java.util.Scanner;

class ExpressionCalculator {
    double x;
    double y;
    private static ExpressionCalculator instance;

    private ExpressionCalculator(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static ExpressionCalculator getInstance(double x, double y) {
        if (instance == null) {
            instance = new ExpressionCalculator(x, y);
        }
        return instance;
    }

    public double calculate() {
        if (y == 0) {
            System.out.println("Деление на ноль!");
            return 0;
        }
        else return 2 * x + 3 / y;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите х: ");
        double x = s.nextDouble();
        System.out.println("Введите у: ");
        double y = s.nextDouble();
        ExpressionCalculator calculator = ExpressionCalculator.getInstance(x, y);
        double result = calculator.calculate();
        System.out.println("Результат: " + result);

        System.out.println("Введите х2: ");
        double x2 = s.nextDouble();
        System.out.println("Введите у2: ");
        double y2 = s.nextDouble();
        ExpressionCalculator calculator2 = ExpressionCalculator.getInstance(x2, y2);
        double result2 = calculator2.calculate();
        System.out.println("Результат: " + result2);
    }
}
