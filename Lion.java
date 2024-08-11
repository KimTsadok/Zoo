package zoo;

public class Lion extends Animal {
	protected static final int LIFESPAN = 15;
	protected String name;
	protected double weight;
	protected genderEnum gender;

	// c'tor
	public Lion(String name, int age, double weight, genderEnum gender) {
		super(age);
		this.name = name;
		this.weight = weight;
		this.gender = gender;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public genderEnum getGender() {
		return gender;
	}

	public void setGender(genderEnum gender) {
		this.gender = gender;
	}

	// to string
	public String toString() {
		return "Lion [name=" + name + ", age=" + age + ", weight=" + weight + ", gender=" + gender + "]";
	}

	public double feed() {
		final double MALE = 0.02;
		final double FEMALE = 0.03;
		int formula = (int) (this.getWeight() * this.getAge());
		if (this.getGender() == genderEnum.FEMALE)
			formula *= FEMALE;
		else
			formula *= MALE;
		if (formula > 25)
			formula = 25;
		return formula;
	}

	public String makeNoise() {
		return "ROAR";
	}

}