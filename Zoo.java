package zoo;

import java.util.ArrayList;

import java.util.Random;

public class Zoo {
	private String name;
	private String address;
	private ArrayList<AquariumFish> aquarium = new ArrayList<AquariumFish>();
	private ArrayList<Lion> predators = new ArrayList<Lion>();

	// c'tor
	public Zoo(String name, String address) {
		this.name = name;
		this.address = address;
	}

	// getters and setters
	public ArrayList<AquariumFish> getAquarium() {
		return aquarium;
	}

	public ArrayList<Lion> getPredators() {
		return predators;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return "Zoo [name=" + name + ", address=" + address + "]";
	}

	// Predators//

	public void addPredators(Lion lion) {
		predators.add(lion);
		System.out.println("predator added succesfully");
	}

	public void printPredators() {
		for (Lion carnivore : predators) {
			System.out.println(carnivore.toString());
		}

	}

	public double feedAllPredators() {
		double sum = 0;
		for (Lion carnivore : predators) {
			sum += carnivore.feed();
		}
		return sum;
	}

	public String countPerdators() {
		int countLions = 0;
		int countTiger = 0;

		for (Lion pred : predators) {
			if (pred instanceof Tiger) {
				countTiger++;
			} else {
				countLions++;
			}
		}
		return countLions + " lions, " + countTiger + " tigers ";
	}

	// fish//

	// add fish - 2 options
	public void addSpecificFish(AquariumFish newFish) {
		aquarium.add(newFish);
		System.out.println("fish added succesfully");
	}

	public void addFish(int n) {
		int age, patternValueCount, randomIndexPattern, colorValueCount, colorAmount, randomIndexColors;
		double length;
		Patterns pattern;
		Colors[] color;
		AquariumFish newFish;
		boolean checkAgain = true;
		int type;
		Colors[] goldFishOp = { Colors.BLACK, Colors.ORANGE, Colors.GOLD, Colors.YELLOW };

		patternValueCount = Patterns.values().length;
		colorValueCount = Colors.values().length;

		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < n; i++) {
			type = rand.nextInt(3); // random type(0-aqua, 1-gold, 2-clown)

			age = rand.nextInt(45); // random age

			length = rand.nextDouble(25); // random length

			if (type == 0) { // aqua fish
				// random pattern
				randomIndexPattern = rand.nextInt(patternValueCount);
				pattern = Patterns.values()[randomIndexPattern];

				// random colors
				colorAmount = rand.nextInt(colorValueCount) + 1;
				color = new Colors[colorAmount];// new array
				for (int j = 0; j < colorAmount; j++) {
					randomIndexColors = rand.nextInt(colorValueCount);

					// check if we don't have this color already
					while (checkAgain == true) {
						checkAgain = false;
						for (int k = 0; k < j; k++) {
							if (color[k] == Colors.values()[randomIndexColors]) {
								randomIndexColors = rand.nextInt(colorValueCount);
								checkAgain = true;
								break;
							}
						}
					}
					color[j] = Colors.values()[randomIndexColors];
					checkAgain = true;
				}
				newFish = new AquariumFish(age, length, pattern, color);

			} else if (type == 1) { // gold fish
				randomIndexColors = rand.nextInt(goldFishOp.length);
				color = new Colors[1];
				color[0] = goldFishOp[randomIndexColors];
				newFish = new GoldFish(age, length, color);

			} else { // clown fish
				color = new Colors[3];
				color[0] = Colors.ORANGE;
				color[1] = Colors.BLACK;
				color[2] = Colors.WHITE;
				newFish = new ClownFish(age, length, color);
			}

			aquarium.add(newFish);
		}
		System.out.println(n + " fishes added succesfully");
	}

	// feed aquarium
	public double feedAllFish() {
		double count = 0;
		for (int i = 0; i < aquarium.size(); i++) {
			count += aquarium.get(i).feedFish(aquarium.get(i));
		}
		return count;
	}

	// aquarium fish colors
	public Colors[] zooFishColors() {
		int count = Colors.values().length;
		boolean isInside = false;
		Colors[] colorsInAquarium = new Colors[count];
		int newArraySize = 0;
		Colors color;

		for (int i = 0; i < count; i++) {
			for (int j = 0; j < aquarium.get(i).getColor().length; j++) {
				color = aquarium.get(i).getColor()[j];
				for (int k = 0; k < newArraySize; k++) {
					if (color == colorsInAquarium[k]) {
						isInside = true;
						break;
					}
				}
				if (!isInside) {
					colorsInAquarium[newArraySize] = color;
					newArraySize++;
				}
				isInside = false;
			}
		}

		return colorsInAquarium;
	}

	public void printFish() {
		for (int i = 0; i < aquarium.size(); i++) {
			System.out.println(aquarium.get(i).toString());
		}
	}

	// count fish in aquarium according to type
	public String countFish() {
		int countAquaFish = 0;
		int countGoldFish = 0;
		int countClownFish = 0;

		for (AquariumFish fish : aquarium) {
			if (fish instanceof GoldFish) {
				countGoldFish++;
			} else if (fish instanceof ClownFish) {
				countClownFish++;
			} else {
				countAquaFish++;
			}
		}
		return countAquaFish + " aquarium fish, " + countGoldFish + " gold fish and " + countClownFish + " clown fish ";
	}

	// 2 domain colors in the aquarium
	public String domainFishColor() {
		int[] countColors = new int[Colors.values().length];
		int colorIndex, max1, max2;
		Colors color;

		// fill array with the amount of time it appear
		// the index of the cell is the index of the enum
		for (int i = 0; i < aquarium.size(); i++) {
			for (int j = 0; j < aquarium.get(i).getColor().length; j++) {
				color = aquarium.get(i).getColor()[j];
				colorIndex = color.ordinal();
				countColors[colorIndex]++;
			}
		}

		max1 = 0; // color in index 0
		max2 = 1; // color in index 1
		for (int i = 2; i < countColors.length - 1; i = i + 2) {
			if (countColors[i] > countColors[max1]) {
				max1 = i;
			}
			if (countColors[i + 1] > countColors[max2]) {
				max2 = i + 1;
			}
		}

		return "the 2 domain colors are: " + Colors.values()[max1] + " , " + Colors.values()[max2];

	}

	// ageOneYear
	public void ageOneYearAllAnimals() {
		// Aquarium
		for (int i = 0; i < aquarium.size(); i++) {
			aquarium.get(i).ageOneYear();
			if (aquarium.get(i) instanceof GoldFish) {
				if (aquarium.get(i).age > GoldFish.LIFESPAN) {
					// delete the gold fish!
				} else {
					// down happiness random
				}
			} else if (aquarium.get(i) instanceof ClownFish) {
				if (aquarium.get(i).age > ClownFish.LIFESPAN) {
					// delete the clown fish!
				} else {
					// down happiness random
				}
			} else {
				if (aquarium.get(i).age > AquariumFish.LIFESPAN) {
					// delete the aqua fish!
				} else {
					// down happiness random
				}
			}
		}

		// Predators
		for (int i = 0; i < predators.size(); i++) {
			predators.get(i).ageOneYear();
			if (predators.get(i).age > Lion.LIFESPAN) {
				// delete predator!
			} else {
				// down happiness random
			}
		}

		// Penguin ageOneYear!!!

	}

}
