package task3;

import java.util.Arrays;

abstract class Animal{
	public String getName() {return name;}
	public int getAge() {return age;}
	
	abstract void voice();	
	
	String name;
	int age;
	static int n;
	
	public static int getQuantity(){
		return n;
	}	
}

class Dog extends Animal{
	Dog(int i, String s){
		age = i;
		name = s;
		n++;
		}
	
	public void voice(){
		System.out.println("Гав");
	}	
}

class Cat extends Animal{
	Cat(int i, String s){
		age = i;
		name = s;
		n++;}
	
	public void voice(){
		System.out.println("Мяу");}
}

//протестировать!
class Pytomnik
{
	private Animal []a = new Animal [1000];
	private static int last;
	
	void addAnimal(Animal b){
		a[last]=b;
		last++;
	}
	
	Animal[] getAnimalsByCtiteria(String type, int beginning, int end){
		Animal []b = new Animal [last+1]; 		
		
		for(int i=0,j=0; i<last; i++){
			boolean mark = false;
			
			if((a[i] instanceof Dog && type == "Dog") || (a[i] instanceof Cat && type == "Cat"))
				mark = true;
			
			if(mark && a[i].getAge() >= beginning && a[i].getAge() <=end){
				b[j] = a[i];
				j++;
			}			
		}		
		return b;
	}
}

public class TaskThree {
	
	public static void main(String[] args) {
		
		Animal [] anim = { 
				new Cat(25, "Тина"), 
				new Cat(3, "Васька"), 
				new Cat(17, "Тимоша"),
				new Dog(15, "Джентельмен"),
				new Dog(8, "Блэккиус"),
				new Dog(1, "Санни"),
				new Dog(7, "Петричек")
		};
		
		System.out.println("Всего животных: " + Animal.getQuantity());
		
		//обявляем питомник
		Pytomnik p = new Pytomnik();
		
		for(Animal a : anim){
			//заполняем питомник
			p.addAnimal(a);
			
			if(a instanceof Cat)
				System.out.print("Cat: ");
			else
				System.out.print("Dog: ");
			System.out.print(a.getName() + " " + a.getAge() + '\n');
		}
		
		// Задание №4
		Animal [] newAnimal = p.getAnimalsByCtiteria("Cat", 2, 20);
		System.out.println("\n" + "Коты от 2 до 20 лет из питомника:");
		for(Animal a : newAnimal){
			if(a==null) break;
			System.out.println(a.getName() + " " + a.getAge());
		}

		// Задание №3
		System.out.println("\n" + "Массив животных после удаления элементов:");
		anim = Arrays.copyOf(anim, anim.length - DeleteFunc(anim));
	
		for(Animal a : anim){
			if(a instanceof Cat)
				System.out.print("Cat: ");
			else
				System.out.print("Dog: ");
			System.out.print(a.getName() + " " + a.getAge() + '\n');
		}		
	
		// Задание №5
		int []f = {5,3,7,3,1,9,2,9,0,4,9};
		int []n = Five(f);
		
		System.out.println("\n" + "Задание №5");
		for(int i =0; i<f.length; i++)
			System.out.print(f[i] + " ");
		System.out.println();
		for(int i =0; i<n.length; i++)
			System.out.print(n[i] + " ");		
	}

	public static int DeleteFunc(Animal [] aa)
	{
		int count = 0;
		int length = aa.length;
		
		for(int i=0; i<length; i++){
			if(aa[i] instanceof Cat)
				if(aa[i].getAge() < 1 || aa[i].getAge() > 8){
					//deleting array element							
					System.arraycopy(aa, 0, aa, 0, i);
					System.arraycopy(aa, i+1, aa, i, length-i-1);	
					
					if(i>0) i--;
					count++;
					length--;					
				}	
				
			if(aa[i] instanceof Dog){
				String s = (aa[i].getName()).toLowerCase();
						
				String sogl = "бвгджзйклмнпрстфхцчшщъь";
				char[] soglArray = sogl.toCharArray();
				int c=0;
				        
				for(Character character : soglArray)
				   for (int j = 0; j < s.length(); j++)   
				       if(s.charAt(j) == character)
				           c++;
				
				if(c > 4){
					//deleting array element
					System.arraycopy(aa, 0, aa, 0, i);
					System.arraycopy(aa, i+1, aa, i, length-i-1);	
					
					count++;
					length--;
					if(i>0) i--;
				}	            
			}
		}		
		return count;
	}
		


	//Создать метод, принимающий на вход массив, и возвращающий массив содержащий в качестве индексов значения входного массива, 
	//а в качестве значений - кол-во вхождений данного элемента во входном массиве. Значения входного массива не могут быть меньше 
	//0 или больше 100.
	//Вход: [5,3,7,3,1,9,2,9,0,4,9]
	//Выход: [1,1,1,2,1,1,0,1,0,3]
	public static int[] Five(int a[])
	{
		//находим размерность выходного массива по максимальному значению элемента в исходном массиве
		int max=0;
		for(int i=0; i<a.length; i++)
			if(a[i]>max) max=a[i];
		
		//создаем выходной массив
		int [] b = new int[max+1];
			
		for(int i=0; i<a.length; i++){
			if(b[a[i]] == 0){
				
			int s=1;
			
			for(int j=i+1; j<a.length; j++)
				if(a[j]==a[i])s++;
			
			b[a[i]]=s;
			}
		}
		return b;
	}

}