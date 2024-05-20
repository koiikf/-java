import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void sort(int[] num, Exp e){
        int a = num.length;
        for (int i = 0; i < a - 1; i++) {
            for (int j = 0; j < a - i - 1; j++) {
                if (e.aaa(num[j],num[j + 1])) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
        System.out.println("Массив: " + Arrays.toString(num));
    }


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {

            array[i] = scanner.nextInt();
        }
        System.out.println("Выбери сортировку(0 - по возрастанию, 1 - по убыванию)");
        int y = scanner.nextInt();
        if(y==0) {
            Exp func = (a, b) -> {return a > b;};
            sort(array, func);
        } else if (y==1) {
            Exp func = (a, b) -> {return a < b;};
            sort(array, func);
        }
        else System.out.println("Неопознанная команда");
    }
}

interface Exp{
    boolean aaa(int a, int b);
}


