import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("введи какое-нибудь число: ");
        double a = sc.nextDouble();
        Sin sinx = new Sin(a);
        sinx.vv();
        System.out.println("введи команду (сохрани/восстанови): ");

        String b = sc.next();

        if (b.equals("сохрани")){
            sinx.save();
        }
        else {
            if (b.equals("восстанови")) {
                sinx = sinx.upload();
                System.out.println("Восстановлено: y = " + sinx.y + " при x = " + sinx.x);
            }
            else{
                System.out.println("не то ввел");

            }
        }
    }

    static class Sin implements Serializable{
        double x;
        double y;
        Sin(double x){
            this.x = x;
            this.y = sin();
        }

        public double sin(){
            return x - Math.sin(x);
        }
        public void vv(){
            System.out.println("x - sinx = " + y);
        }
        public void save(){
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\user\\Desktop\\уроки\\javaaaa\\eee.txt"))) {
                oos.writeObject(this);
                System.out.println("Сохранено: y = " + y + " при x = " + x);
            }
            catch (Exception ex){
                System.out.println("не удалось сохранить((");
            }
        }

        public Sin upload(){
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\user\\Desktop\\уроки\\javaaaa\\eee.txt"))){
                Sin sin = (Sin) ois.readObject();
                return sin;
            }
            catch (Exception ex){
                System.out.println("не удалось восстановить((");
            }
            return null;
        }
    }
}