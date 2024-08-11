package zoo;

public class Tiger extends Lion {

	// c'tor
	public Tiger(String name, int age, double weight, genderEnum gender) {
		super(name, age, weight, gender);
	}

	// general functions
	@Override
	public String makeNoise() {
		return "roar";
	}

	@Override
	public double feed() {
		final double femaleMulti = 0.03, maleMulti = 0.02;
		double formula = this.getWeight() * this.getAge();
		if (this.getGender() == genderEnum.FEMALE)
			formula *= femaleMulti;
		else
			formula *= maleMulti;
		return formula;
	}

	@Override
	public String toString() {
		return "Tiger [name=" + name + ", age=" + age + ", weight=" + weight + ", gender=" + gender + "]";
	}
}