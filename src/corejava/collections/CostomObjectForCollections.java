package corejava.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CostomObjectForCollections {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();
		persons.add(new Person(20, "Amit"));
		persons.add(new Person(30, "Rohan"));
		persons.add(new Person(18, "Anil"));
		
		for(Person person : persons){
			System.out.println(person);
		}
		
		Collections.sort(persons);
		
		for(Person person : persons){
			System.out.println(person);
		}
	}
}

class Person implements Comparable<Person>{
	private int age;
	private String name;
	
	public Person(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int compareTo(Person person){
		if(this.getAge() < person.getAge())
			return -1;
		else if(this.getAge() > person.getAge())
			return 1;
		else
			return 0;
	}
	
	public int hashCode(){
		int hashValue = this.getName().hashCode();
		return this.getAge()*hashValue;
	}
	
	public boolean equals(Person person){
		if(this.getAge() == person.getAge() && this.getName().equals(person.getName()))
			return true;
		else
			return false;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
}

