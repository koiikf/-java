public class Main {
    public static void main(String[] args) {
        baseVolt iphone15 = new Iphone();
        charge charge = new charge(iphone15);
        charge.charging();

        voltForNokia vfn = new Nokia();
        phoneAdapter adapter = new phoneAdapter(vfn);
        charge nokiacharge = new charge(adapter);
        nokiacharge.charging();
    }
}
interface baseVolt{
    public void chargePhone();
    public void completeCharge();
}
class Iphone implements baseVolt{
    final public int volt = 380;
    public void chargePhone(){
        System.out.println("айфон заряжается (" + volt + ").");
    }

    @Override
    public void completeCharge() {
        System.out.println("зарядка айфона завершена.");
    }
}
class charge{
    baseVolt bv;
    public charge(baseVolt bv){
        this.bv = bv;
    }
    public void charging(){
        bv.chargePhone();
        bv.completeCharge();
    }
}
interface voltForNokia{
    public void chargeNokia();
    public void completeCharge();
}
class Nokia implements voltForNokia{
    final public int volt = 220;
    public void chargeNokia(){
        System.out.println("нокиа3310 заряжается (" + volt + ").");
    }

    @Override
    public void completeCharge() {
        System.out.println("зарядка нокиа3310 завершена.");
    }
}
class phoneAdapter implements baseVolt{
    voltForNokia vfn;
    public phoneAdapter(voltForNokia vfn){
        this.vfn = vfn;
    }
    public void chargePhone(){
        vfn.chargeNokia();
    }

    @Override
    public void completeCharge() {
        vfn.completeCharge();
    }
}