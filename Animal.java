package zoo;

public abstract class Animal {
	protected int happiness;
	protected int age;

	public Animal(int age) {
		this.happiness = 100;
		this.age = age;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void ageOneYear() {
		this.age++;
	}

}
