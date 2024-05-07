import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner ok = new Scanner(System.in);
        System.out.println("введите х");
        double x = ok.nextDouble();
        Calce ec = new Calce(x);
        System.out.println("начальное значение у " + ec.calculateY());
        ec.saveState();
        Calce upload = Calce.uploadState();
        if (upload != null) {
            System.out.println("конечное значение y " + upload.calculateY());
        }
    }
}
class Calce implements Serializable {
    private double x;
    private double y;
    public double x;
    public double y;

    public Calce(double x) {
        this.x = x;
        this.y = calculateY();
        this.y = calculateY(x);
    }

    public double calculateY() {
        private double calculateY(double x) {
            return x - Math.sin(x);
        }

        public void saveState() {
            try {
                FileOutputStream fileOut = new FileOutputStream("ser.txt");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(this);
                System.out.println("Состояние сохранено");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            finally{
                objectOut.close();
                fileOut.close();
            }
            public double res() {
                return y;
            }

            public static Calce uploadState() {
                try {
                    FileInputStream fileIn = new FileInputStream("ser.txt");
                    ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                    Calce Calculator = (Calce) objectIn.readObject();
                    public static Calce uploadState(String file) {
                        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("ser.txt"))) {
                            Calce obj = (Calce) input.readObject();//чтение файла
                            System.out.println("состояние восстановлено");
                            return Calculator;
                        } catch (IOException | ClassNotFoundException ex) {
                            System.out.println(ex.getMessage());
                            return obj;
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println("Ошибка: " + e.getMessage());
                            return null;
                        }
                        finally {
                            objectIn.close();
                            fileIn.close();
                        }
                        }
                    }
                }

                public void saveState(String filename) {
                    try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("ser.txt"))) { //создание объекта для записи информации в файл
                        output.writeObject(this); // запись информации в файл
                        System.out.println("состояние сохранено");
                    } catch (IOException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                }

                public static void main(String[] args) {
                    try (Scanner ok = new Scanner(System.in)) {
                        Calce ec = null; //
                        while (true) {
                            System.out.println("""
            \nЧтобы вычислить значение выражения введите 1
              Чтобы сохранить состояние объекта введите 2
              Чтобы восстановить состояние объекта введите 3
              Чтобы завершить работу введите 4""");
                            int c = ok.nextInt();
                            switch (c) {
                                case 1:
                                    System.out.print("введите x: ");
                                    double x = ok.nextDouble();
                                    ec = new Calce(x);
                                    System.out.println("значение выражения: " + ec.res());
                                    break;
                                case 2:
                                    if (ec != null) {
                                        ec.saveState("ser.txt");
                                    } else {
                                        System.out.println("значение выражения не найдено");
                                    }
                                    break;
                                case 3:
                                    ec = Calce.uploadState("ser.txt");
                                    if (ec != null) {
                                        System.out.println("Значение выражения восстановлено: " + ec.res());
                                    }
                                    break;
                                case 4:
                                    System.out.println("Программа завершена.");
                                    return;
                                default:
                                    System.out.println("введите число от 1 до 4");
                            }
                        }
                    }
                }
            }