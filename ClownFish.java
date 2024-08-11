package zoo;

import java.util.Arrays;

public class ClownFish extends AquariumFish {
	public static final int LIFESPAN = 8;

	public ClownFish(int age, double length, Colors[] color) {
		super(age, length, color);
		this.pattern = Patterns.STRIPES;
	}

	@Override
	public String toString() {
		return "ClownFish [age=" + age + ", length=" + length + ", pattern=" + pattern + ", color="
				+ Arrays.toString(color) + "]";
	}

	@Override
	public double feedFish(AquariumFish fish) {
		return 2;
	}

}
