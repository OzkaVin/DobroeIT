package seventh.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
//7.1

@FunctionalInterface
interface ISeventh{
    int methodSeven (String [] array);
}

public class Seventh{
    public static void main(String[] args) {
        String a[] = {"Olga", "Helen", "Igor"};

        ISeventh function = (m) -> {
            int sum = 0;
            for (String s : m)
                sum += s.length();
            return sum;
        };

        int b = function.methodSeven(a);
        System.out.println(b);
    }
}
*/

/*
//7.2

public class Seventh{
    public static List <Animal> out (List<Animal> inArr){
        return inArr.stream().
                filter(a -> ((a.getAge() <= 5) && (a.getName().startsWith("A") || a.getName().startsWith("B") || a.getName().startsWith("C")))).
                sorted(Comparator.comparing(a -> a.getAge())).
                limit(3).
                collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList <> ();
        animals.add(new Animal(Type.Bird, 3, "Chloe"));
        animals.add(new Animal(Type.Cat, 4, "Murka"));
        animals.add(new Animal(Type.Dog, 2, "Black"));
        animals.add(new Animal(Type.Caw, 5, "Flower"));
        animals.add(new Animal(Type.Dog, 7, "Fred"));
        animals.add(new Animal(Type.Cat, 1, "Alex"));
        animals.add(new Animal(Type.Bird, 6, "Archi"));
        animals.add(new Animal(Type.Caw, 3, "Arina"));
        animals.add(new Animal(Type.Dog, 8, "Bob"));

        List <Animal> listAnimals = Seventh.out(animals);

        listAnimals.stream().forEach(System.out::println);
    }
}
*/

public class Seventh{
    public static List <Animal> out (int [] array){
        return inArr.stream().
                filter(a -> ((a.getAge() <= 5) && (a.getName().startsWith("A") || a.getName().startsWith("B") || a.getName().startsWith("C")))).
                sorted(Comparator.comparing(a -> a.getAge())).
                limit(3).
                collect(Collectors.toList());
    }

    public static void main(String[] args) {

    }
}