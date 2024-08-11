package zoo;

import java.util.Arrays;

public class GoldFish extends AquariumFish {
	public static final int LIFESPAN = 12;

	public GoldFish(int age, double length, Colors[] color) {
		super(age, length, color);
		this.pattern = Patterns.SMOOTH;

	}

	@Override
	public String toString() {
		return "GoldFish [age=" + age + ", length=" + length + ", pattern=" + pattern + ", color="
				+ Arrays.toString(color) + "]";
	}

	@Override
	public double feedFish(AquariumFish fish) {
		return 1;
	}

}
