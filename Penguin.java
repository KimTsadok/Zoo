package zoo;

public class Penguin extends Animal {
	private static final int LIFESPAN = 6;
	private double height;
	private String name;

	// c'tor
	public Penguin(int age, double height, String name) {
		super(age);
		this.height = height;
		this.name = name;
	}

	// getters and setters
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// to string
	public String toString() {
		return "Penguin [age=" + age + ", height=" + height + ", name=" + name + "] ";
	}

	// penguin Noise
	public String penguinNoise() {
		return "squack";
	}

}