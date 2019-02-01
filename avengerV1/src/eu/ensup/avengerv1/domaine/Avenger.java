package eu.ensup.avengerv1.domaine;

public class Avenger {

	public int age;
	public String name;
	public String costume;
	public String pouvoir;
	
	
	public Avenger(int age, String name, String costume, String pouvoir) {
		this.age = age;
		this.name = name;
		this.costume = costume;
		this.pouvoir = pouvoir;
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
	public String getCostume() {
		return costume;
	}
	public void setCostume(String costume) {
		this.costume = costume;
	}
	public String getPouvoir() {
		return pouvoir;
	}
	public void setPouvoir(String pouvoir) {
		this.pouvoir = pouvoir;
	}
	@Override
	public String toString() {
		return "Avengers [age=" + age + ", name=" + name + ", costume=" + costume + ", pouvoir=" + pouvoir + "]";
	}
	
}
