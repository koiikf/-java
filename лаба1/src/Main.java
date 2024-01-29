//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите число: ");
        double x = input.nextDouble();
        System.out.println("Введите n: ");
        double n = input.nextDouble();
        double result = 0;
        double res = 0;
        if ((x > -1) && (x <= 1)) {
            for (double i = 1; i <= n; i++) {
                result = (Math.pow(-1, i) * Math.pow(x, i + 1) / (i + 1));
                res +=result;
            }
            System.out.println("результат: " + res);
        }
        else {
            System.out.println("введенное число не входит в заданный промежуток");
        }
    }
}