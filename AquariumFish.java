package zoo;

import java.util.Arrays;

public class AquariumFish extends Animal {
	public static final int LIFESPAN = 25;
	protected double length;
	protected Patterns pattern;
	protected Colors[] color;

	// c'tors
	public AquariumFish(int age, double length, Colors[] color) {
		super(age);
		this.length = length;
		this.color = color;

	}

	public AquariumFish(int age, double length, Patterns pattern, Colors[] color) {
		super(age);
		this.length = length;
		this.pattern = pattern;
		this.color = color;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Patterns getPattern() {
		return pattern;
	}

	public Colors[] getColor() {
		return color;
	}

	public String toString() {
		return "AquariumFish [age=" + age + ", length=" + length + ", pattern=" + pattern + ", color="
				+ Arrays.toString(color) + "]";
	}

	public String fishNoise() {
		return "blob";
	}

	public double feedFish(AquariumFish fish) {
		final int STARTFOOD = 3;
		if (fish.age < STARTFOOD) {
			return STARTFOOD;
		}
		return STARTFOOD + fish.length;
	}
}