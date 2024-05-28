
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Создаем группы
        Group group1 = new Group("Смешарики");
        Group group2 = new Group("Вязание");
        Group group3 = new Group("Смотреть кино онлайн в качестве 144р");
        Group group4 = new Group("дота эщкере");

        // Создаем пользователей
        User vaska = new User("Васька");
        User gosha = new User("Гоша");

        //васька подписывается на 3 группы
        vaska.subscribe(group1);
        vaska.subscribe(group2);
        vaska.subscribe(group3);

        //гоша подписывается на 4 группы
        gosha.subscribe(group1);
        gosha.subscribe(group2);
        gosha.subscribe(group3);
        gosha.subscribe(group4);

        //оповещения
        group1.notifyObservers("новое объявление в группе \"" + group1.name + "\"");
        group2.notifyObservers("новое объявление в группе \"" + group2.name + "\"");
        group3.notifyObservers("новое объявление в группе \"" + group3.name + "\"");
        group4.notifyObservers("новое объявление в группе \"" + group4.name + "\"");
    }
}

interface Notifier {
    void addObserver(Observer obs); //добавить подписчика
    void removeObserver(Observer obs); //удалить
    void notifyObservers(String message); //оповестить
}

class Group implements Notifier {
    private List<Observer> observers = new ArrayList<>(); //список подписчиковв
    String name;

    public Group(String name) {
        this.name = name;
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(this.name, message);
        }
    }
}

interface Observer {
    void update(String groupName, String message);
}

class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void subscribe(Group group) {
        group.addObserver(this);
    }

    public void unsubscribe(Group group) {
        group.removeObserver(this);
    }

    @Override
    public void update(String groupName, String message) {
        System.out.println(name + " получил оповещение от группы \"" + groupName + "\": " + message);
    }
}

class ConcreteGroup extends Group {

    public ConcreteGroup(String name) {
        super(name);
    }
}