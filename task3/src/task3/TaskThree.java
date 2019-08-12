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
		System.out.println("���");
	}	
}

class Cat extends Animal{
	Cat(int i, String s){
		age = i;
		name = s;
		n++;}
	
	public void voice(){
		System.out.println("���");}
}

//��������������!
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
				new Cat(25, "����"), 
				new Cat(3, "������"), 
				new Cat(17, "������"),
				new Dog(15, "�����������"),
				new Dog(8, "��������"),
				new Dog(1, "�����"),
				new Dog(7, "��������")
		};
		
		System.out.println("����� ��������: " + Animal.getQuantity());
		
		//�������� ��������
		Pytomnik p = new Pytomnik();
		
		for(Animal a : anim){
			//��������� ��������
			p.addAnimal(a);
			
			if(a instanceof Cat)
				System.out.print("Cat: ");
			else
				System.out.print("Dog: ");
			System.out.print(a.getName() + " " + a.getAge() + '\n');
		}
		
		// ������� �4
		Animal [] newAnimal = p.getAnimalsByCtiteria("Cat", 2, 20);
		System.out.println("\n" + "���� �� 2 �� 20 ��� �� ���������:");
		for(Animal a : newAnimal){
			if(a==null) break;
			System.out.println(a.getName() + " " + a.getAge());
		}

		// ������� �3
		System.out.println("\n" + "������ �������� ����� �������� ���������:");
		anim = Arrays.copyOf(anim, anim.length - DeleteFunc(anim));
	
		for(Animal a : anim){
			if(a instanceof Cat)
				System.out.print("Cat: ");
			else
				System.out.print("Dog: ");
			System.out.print(a.getName() + " " + a.getAge() + '\n');
		}		
	
		// ������� �5
		int []f = {5,3,7,3,1,9,2,9,0,4,9};
		int []n = Five(f);
		
		System.out.println("\n" + "������� �5");
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
						
				String sogl = "�����������������������";
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
		


	//������� �����, ����������� �� ���� ������, � ������������ ������ ���������� � �������� �������� �������� �������� �������, 
	//� � �������� �������� - ���-�� ��������� ������� �������� �� ������� �������. �������� �������� ������� �� ����� ���� ������ 
	//0 ��� ������ 100.
	//����: [5,3,7,3,1,9,2,9,0,4,9]
	//�����: [1,1,1,2,1,1,0,1,0,3]
	public static int[] Five(int a[])
	{
		//������� ����������� ��������� ������� �� ������������� �������� �������� � �������� �������
		int max=0;
		for(int i=0; i<a.length; i++)
			if(a[i]>max) max=a[i];
		
		//������� �������� ������
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