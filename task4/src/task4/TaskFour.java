package task4;

//import org.apache.commons.lang3.NotImplementedException;

class NotImplementedException extends Exception{
	//private int number;
    //public int getNumber(){return number;}
    public NotImplementedException(String message/*, int num*/){
        super(message);
        //number=num;
    }
}

abstract class Animal{
	
	String name;
	int age;
	static int n;
	
	Animal(String s, int i){
		age = i;
		name = s;
		n++;
		}
	
	//@Override
	public String toString(){
		return getClass().getSimpleName() + ": " + age + " years" + ", name - " + name;
	};
	
	@Override
	public boolean equals(final Object o){
		if(this == o) return true;
		if(o == null || getClass()!= o.getClass()) return false;
		
		final Animal animal = (Animal)o;
		
		if(age != animal.age) return false;
		return name!=null? name.equals(animal.name) : animal.name == null;
	}
	
	public String getName() {return name;}
	public int getAge() {return age;}
	
	abstract public void voice()throws NotImplementedException;

	abstract public void dyingVoice()throws NotImplementedException;
	
	public static int getQuantity(){
		return n;
	}

	@Override
	protected void finalize() throws Throwable{
		dyingVoice();
	}
}

class Dog extends Animal{
	Dog(String s, int i){
		super(s, i);
	}
		
	@Override
	public void voice()throws NotImplementedException{
		System.out.println("Гав");
	}	

	@Override
	public void dyingVoice()throws NotImplementedException{
		System.out.println("Фффф !!!");
	}
}

class Cat extends Animal{
	Cat(String s, int i){
		super(s, i);
	}
			
	@Override
	public void voice()throws NotImplementedException{
		System.out.println("Мяу");}

	@Override
	public void dyingVoice()throws NotImplementedException{
		System.out.println("Хххх !!!");
	}
}

class Fish extends Animal{
	Fish(String s, int i){
		super(s, i);
		}
	
	@Override
	public void voice() throws NotImplementedException {
		//fishException();
		throw new NotImplementedException("Fish can't speak");
	}

	@Override
	public void dyingVoice()throws NotImplementedException{
		throw new NotImplementedException("Fish can't speak");
	}
}


public class TaskFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		// 1. Сделать так, чтобы животные одинакового типа 
		// и с одинаковым возрастом и именем при проверке на equals 
		// были распознаны, как одинаковые.
		Animal [] anim = new Animal [25];
		anim [0] = new Dog("Doggy", 5);
		anim [1] = new Cat("Doggy", 5);
		anim [2] = new Dog("Doggy", 5);
		anim [3] = new Dog("Doggy", 7);
		anim [4] = new Dog("Tom", 5);
		
		for (int i = 0, j = 1; j < Animal.getQuantity(); j++)
			System.out.println((anim[i].equals(anim[j])?"Equals: ":"Not equals: ") + anim[i].toString() + " and " + anim[j].toString());
		
		
		// 3. Создать реализации метода void dyingVoice() в Cat и Dog. 
		// Метод должен печатать на консоль звук, издаваемый животным перед смертью(можно выбрать любой). 
		// Сделать так, чтобы метод вызывался на животном перед его уничтожением сборщиком мусора. 
		// Спровоцировать выполнение сборщика мусора(создать очень много объектов, на которые нет ссылок). 
		// Убедиться, что животных слышно перед смертью.
		/*for(int i = 0; i < 350000; i++){
			new Dog("Баг", 5);
			new Cat("Том", 5);
		}*/
		
		// 5. Создать класс Fish, который будет наследовать Animal. При вызове метода voice, рыба должна выбрасывать 
		// NotImplementedException. Добавить несколько рыб в массив с разными животными. Проитерироваться по массиву, 
		// и вызвать метод voice на каждом животном. Подсчитать, сколько раз выпадет NotImplementedException, и вывести 
		// кол-во на консоль.
		anim[5] = new Fish("Gold", 1);
		anim[6] = new Fish("Som", 2);

		
		int count = 0;
		System.out.println("Quantity:" + Animal.getQuantity());
		for (int i = 0; i < Animal.getQuantity(); i++){
			try{
				anim[i].voice();
			}
			catch(NotImplementedException exc){
				count++;
				System.out.println("Voice" + exc.getMessage());
			}
		}
		System.out.println("Количество исключений: " + count);
		
	}
	
	// 4. Создать статический метод, который принимает на вход объект, и возвращает строку, содержащую имя класса данного объекта.
	public static String name(Object o){
		return o.getClass().getName();
	}
	

}
