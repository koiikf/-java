import java.util.ArrayList;
import java.util.List;

abstract class перевозки {
    String name;
    List <String> accessories = new ArrayList();

    public String toString(){
        return "Тип перевозки: " + name + "\n" + accessories;
    }
}

abstract class перевозкиФабрика {
    public abstract перевозки создатьПеревозку();

}

class грузоперевозкиФабрика extends перевозкиФабрика {
    public перевозки создатьПеревозку(){
        return new грузоперевозки();
    }

}

class судоперевозкиФабрика extends перевозкиФабрика {
    public перевозки создатьПеревозку(){
        return new судно();
    }

}
class самолетоперевозкиФабрика extends перевозкиФабрика {
    public перевозки создатьПеревозку(){
        return new самолет();
    }

}

class грузоперевозки extends перевозки {
    public грузоперевозки(){
        name = "грузовик";
        accessories.add("дешево");
        accessories.add("надежно");
        accessories.add("долго");
    }
}

class судно extends перевозки {
    public судно(){
        name = "титаник";
        accessories.add("красиво");
        accessories.add("со вкусом");
        accessories.add("дорого");
        accessories.add("небезопасно");
    }
}

class самолет extends перевозки {
    public самолет(){
        name = "капрони";
        accessories.add("надежно");
        accessories.add("быстро");
        accessories.add("дорого");
    }
}

public class Main{
    public static void main(String[] args) {
        перевозкиФабрика грузоФабрика = new грузоперевозкиФабрика();
        перевозкиФабрика самолетнаяФабрика = new самолетоперевозкиФабрика();
        перевозкиФабрика судноФабрика = new судоперевозкиФабрика();

        перевозки мойГрузовик = грузоФабрика.создатьПеревозку();
        перевозки летатель = самолетнаяФабрика.создатьПеревозку();
        перевозки титаник = судноФабрика.создатьПеревозку();

        System.out.println(мойГрузовик);
        мойГрузовик.toString();
        System.out.println();

        System.out.println(летатель);
        летатель.toString();
        System.out.println();

        System.out.println(титаник);
        титаник.toString();


    }
}