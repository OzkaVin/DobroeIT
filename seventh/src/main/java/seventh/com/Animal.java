package seventh.com;

enum Type {Dog, Cat, Bird, Elephant, Caw};

public class Animal {
    private String name;
    private int age;
    private Type  animalType;

    Animal (Type type, int age, String name){
        this.name = name;
        this.age = age;
        this.animalType = type;
    }

    int getAge(){
        return age;
    }

    String getName(){
        return name;
    }

    Type getType(){
        return animalType;
    }

    public String toString(){
        return String.format("%s - %d", this.name, this.age);
    }
}
