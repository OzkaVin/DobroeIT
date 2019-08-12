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
		System.out.println("���");
	}	

	@Override
	public void dyingVoice()throws NotImplementedException{
		System.out.println("���� !!!");
	}
}

class Cat extends Animal{
	Cat(String s, int i){
		super(s, i);
	}
			
	@Override
	public void voice()throws NotImplementedException{
		System.out.println("���");}

	@Override
	public void dyingVoice()throws NotImplementedException{
		System.out.println("���� !!!");
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
				
		// 1. ������� ���, ����� �������� ����������� ���� 
		// � � ���������� ��������� � ������ ��� �������� �� equals 
		// ���� ����������, ��� ����������.
		Animal [] anim = new Animal [25];
		anim [0] = new Dog("Doggy", 5);
		anim [1] = new Cat("Doggy", 5);
		anim [2] = new Dog("Doggy", 5);
		anim [3] = new Dog("Doggy", 7);
		anim [4] = new Dog("Tom", 5);
		
		for (int i = 0, j = 1; j < Animal.getQuantity(); j++)
			System.out.println((anim[i].equals(anim[j])?"Equals: ":"Not equals: ") + anim[i].toString() + " and " + anim[j].toString());
		
		
		// 3. ������� ���������� ������ void dyingVoice() � Cat � Dog. 
		// ����� ������ �������� �� ������� ����, ���������� �������� ����� �������(����� ������� �����). 
		// ������� ���, ����� ����� ��������� �� �������� ����� ��� ������������ ��������� ������. 
		// �������������� ���������� �������� ������(������� ����� ����� ��������, �� ������� ��� ������). 
		// ���������, ��� �������� ������ ����� �������.
		/*for(int i = 0; i < 350000; i++){
			new Dog("���", 5);
			new Cat("���", 5);
		}*/
		
		// 5. ������� ����� Fish, ������� ����� ����������� Animal. ��� ������ ������ voice, ���� ������ ����������� 
		// NotImplementedException. �������� ��������� ��� � ������ � ������� ���������. ���������������� �� �������, 
		// � ������� ����� voice �� ������ ��������. ����������, ������� ��� ������� NotImplementedException, � ������� 
		// ���-�� �� �������.
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
		System.out.println("���������� ����������: " + count);
		
	}
	
	// 4. ������� ����������� �����, ������� ��������� �� ���� ������, � ���������� ������, ���������� ��� ������ ������� �������.
	public static String name(Object o){
		return o.getClass().getName();
	}
	

}
