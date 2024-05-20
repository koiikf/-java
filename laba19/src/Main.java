public class Main {
    public static void main(String[] args) {
        clothes[] cl = new clothes[4];
        cl[0] = new tShirt(size.XXS, 6666, "пастельный желтый");
        cl[1] = new pants(size.XS, 4, "полосатые красно-белые");
        cl[2] = new skirt(size.M, 777, "клетчатая красная");
        cl[3] = new tie(size.L, 11, "салатовый");
        parlor.dressMen(cl);
        parlor.dressWomen(cl);
    }
}
enum size{
    XXS (32){
        @Override
        String getDescription(){
            return "Детский размер";
        }
    }, XS(34), S(36), M(38), L(40);

    int euroSize;
    size( int euroSize){
        this.euroSize = euroSize;
    }

    String getDescription(){
        return "Взрослый размер";
    }
}

interface MensClothing{
    void dressAMan();
}

interface WomenClothing{
    void dressAWoman();
}

abstract class clothes{
    size size;
    int price;
    String color;

    clothes(size size, int price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }
}

class tShirt extends clothes implements MensClothing, WomenClothing{
    tShirt(size size, int price, String color){
        super(size, price, color);
    }
    public void dressAMan(){
        System.out.println("Мужчина надел футболку размера " + size + " по цене " + price + " цвета " + " \"" + color + "\".");
    }
    public void dressAWoman(){
        System.out.println("Женщина надела футболку размера " + size + " по цене " + price + " цвета " + " \"" + color + "\".");
    }
}

class pants extends clothes implements MensClothing, WomenClothing{
    pants(size size, int price, String color){
        super(size, price, color);
    }
    public void dressAMan(){
        System.out.println("Мужчина надел штаны размера " + size + " по цене " + price + " цвета " + " \"" + color + "\".");
    }
    public void dressAWoman(){
        System.out.println("Женщина надела штаны размера " + size + " по цене " + price + " цвета " + " \"" + color + "\".");
    }
}

class skirt extends clothes implements MensClothing, WomenClothing{
    skirt(size size, int price, String color){
        super(size, price, color);
    }
    public void dressAMan(){
        System.out.println("Мужчина надел килт размера " + size + " по цене " + price + " цвета " + " \"" + color + "\".");
    }
    public void dressAWoman(){
        System.out.println("Женщина надела юбку размера " + size + " по цене " + price + " цвета " + " \"" + color + "\".");
    }
}

class tie extends clothes implements MensClothing, WomenClothing{
    tie(size size, int price, String color){
        super(size, price, color);
    }
    public void dressAMan(){
        System.out.println("Мужчина надел галстук " + size + " по цене " + price + " цвета " + " \"" + color + "\".");
    }
    public void dressAWoman(){
        System.out.println("Женщина надела бабочку размера " + size + " по цене " + price + " цвета " + " \"" + color + "\".");
    }
}

class parlor{
    static void dressWomen(clothes[] clothes) {
        for (clothes c : clothes) {
            if (c instanceof WomenClothing) {
                ((WomenClothing) c).dressAWoman();
            }
        }
    }

    static void dressMen(clothes[] clothes) {
        for (clothes c : clothes) {
            if (c instanceof MensClothing) {
                ((MensClothing) c).dressAMan();
            }
        }
    }
}