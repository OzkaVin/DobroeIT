package seventh.com;

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


//7.2

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface ISeventh <T> {
    T [] methodSeven (T [] array);
}

public class Seventh{
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList(new Animal(Type.Bird, 3, "Flee"),
                new Animal(Type.Cat, 4, "Murka"),
                new Animal(Type.Dog, 2, "Black")
        );

        List <Animal> listAnimals = animals.stream().
                filter(a -> ((a.getAge() <= 5) && (a.getName().startsWith("A") || a.getName().startsWith("B") || a.getName().startsWith("C")))).
                sorted().
                limit(5).
                collect(Collectors.toList());
    }
}
