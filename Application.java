package zoo;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

	public static Scanner scn = new Scanner(System.in);
	public static boolean success = false;

	public static void main(String[] args) throws Exception {
		Zoo maayanAndKimZoo = new Zoo("maayanAndKimZoo", "Tel Aviv");

		Penguin leader = new Penguin(7, 200, "leader");
		NodeManager leaderNode = new NodeManager();
		leaderNode.addPenguin(leader);

		Penguin p1 = new Penguin(4, 180, "p1");
		leaderNode.addPenguin(p1);

		Penguin p2 = new Penguin(5, 190, "p2");
		leaderNode.addPenguin(p2);

		Lion l1 = new Lion("Arie", 5, 175, genderEnum.MALE);// male above 25kg
		maayanAndKimZoo.addPredators(l1);
		Lion l2 = new Lion("Aria", 6, 160, genderEnum.FEMALE);// female above 25kg
		maayanAndKimZoo.addPredators(l2);
		Lion l3 = new Lion("Alex", 3, 140, genderEnum.MALE);// male below 25kg
		maayanAndKimZoo.addPredators(l3);
		Lion l4 = new Lion("Nala", 4, 150, genderEnum.FEMALE);// female below 25kg
		maayanAndKimZoo.addPredators(l4);

		maayanAndKimZoo.addFish(10);

		int questionNum;
		do {
			System.out.println(
					"		\n===== MENU =====\n" + " 1. show zoo details\n" + " 2. show all the penguin details\n"
							+ " 3. add new penguin\n" + " 4. show all the predators details\n"
							+ " 5. add new predator\n" + " 6. show all the aquarium fish details \n"
							+ " 7. add new fish(2 options)\n" + " 8. feed all animals in zoo\n"
							+ " 9. all zoo animals make noise\n" + " 10.exit\n" + " Enter your choice (1-9):");
			questionNum = scn.nextInt();
			switch (questionNum) {
			case 1:
				maayanAndKimZoo.toString();
				System.out.print("we have " + leaderNode.countOrFeedPenguin() + " pengiuns, "
						+ maayanAndKimZoo.countPerdators() + "and we have " + maayanAndKimZoo.countFish());
				break;

			case 2:
				System.out.println("penguin details :");
				leaderNode.printAllPenguin();
				break;

			case 3:
				while (!success) {
					Penguin newPenguin = penguinInput();
					try {
						leaderNode.addPenguin(newPenguin);
						success = true;
					} catch (ZooExceptions e) {
						System.out.println(e.getErrorDesc());
						System.out.println("please try again");
						scn.nextLine();
					}
				}
				success = false;
				break;

			case 4:
				System.out.println("the predators details :");
				maayanAndKimZoo.printPredators();
				break;

			case 5:
				Lion newPredator = lionInput();
				maayanAndKimZoo.addPredators(newPredator);
				break;

			case 6:
				System.out.println("we have " + maayanAndKimZoo.countFish());
				maayanAndKimZoo.printFish();
				System.out.println("the aquarium fishes colors are: ");
				System.out.println(Arrays.toString(maayanAndKimZoo.zooFishColors()));
				System.out.println(maayanAndKimZoo.domainFishColor());

				break;

			case 7:
				System.out.println("choose 1 to add a specific fish or 2 to add multiple fish ");
				int choice = scn.nextInt();
				while (choice != 1 && choice != 2) {
					System.out.println("choose 1 to add a specific fish or 2 to add multiple fish ");
					choice = scn.nextInt();
				}
				switch (choice) {
				case 1:
					// input fish details from user
					AquariumFish newFish = fishInput();
					maayanAndKimZoo.addSpecificFish(newFish);
					break;
				case 2:
					System.out.println("enter how many fishes would you like to enter randomaly :");
					int n = scn.nextInt();
					maayanAndKimZoo.addFish(n);
					break;
				default:
					System.out.println("wrong choice");
					break;
				}
				break;
			case 8:
				System.out.println("the penguins eat " + leaderNode.countOrFeedPenguin() + " fishes ,the predators eat "
						+ maayanAndKimZoo.feedAllPredators() + "kg meat and the fishes eat "
						+ maayanAndKimZoo.feedAllFish());
				break;

			case 9:
				for (int i = 0; i < maayanAndKimZoo.getAquarium().size(); i++) {
					System.out.print(maayanAndKimZoo.getAquarium().get(i).fishNoise());
				}
				leaderNode.allPenguinNoise();
				for (int i = 0; i < maayanAndKimZoo.getPredators().size(); i++) {
					System.out.print(maayanAndKimZoo.getPredators().get(i).makeNoise());
				}

				break;
			case 10:
				break;
			}

		} while (questionNum != 10);
		{
			System.out.println("bye");
		}
	}

	// input penguin details from user
	public static Penguin penguinInput() throws Exception {
		// age input
		int pengAge = 0;
		double pengHeight = 0;
		boolean finished = false;
		while (!finished) {
			try {
				System.out.println("enter age of the penguin :");
				pengAge = scn.nextInt();
				finished = true;
			} catch (InputMismatchException e) {
				System.out.println("invalid integer");
				scn.nextLine();
			}
		}

		// height input
		finished = false;
		while (!finished) {
			try {
				System.out.println("enter height of the penguin :");
				pengHeight = scn.nextInt();
				finished = true;
			} catch (InputMismatchException e) {
				System.out.println("invalid integer");
				scn.nextLine();
			}
		}

		// name input
		System.out.println("enter name of the penguin :");
		String pengName = scn.next();
		Penguin newPenguin = new Penguin(pengAge, pengHeight, pengName);
		return newPenguin;
	}

	// input predators details from user
	public static Lion lionInput() {
		Lion newPredator;

		// type input
		System.out.println("enter type of predator: 0 for lion, 1 for tiger");
		int type = readInRange(0, 1, scn);

		// name input
		System.out.println("enter name of the predator");
		String lionName = scn.next();
		// age input
		System.out.println("enter age of the predator :");
		int lionAge = readInRange(0, 100, scn);

		// weight input
		System.out.println("enter weight of the predator :");
		double lionWeight = readInRange(0, 250, scn);

		// gender input
		System.out.println("enter 0 for female and 1 for male");
		int genderChoice = readInRange(0, 1, scn);
		genderEnum lionGender = genderEnum.values()[genderChoice];

		if (type == 0) {
			newPredator = new Lion(lionName, lionAge, lionWeight, lionGender);
		} else {
			newPredator = new Tiger(lionName, lionAge, lionWeight, lionGender);
		}

		return newPredator;
	}

	// input fish details from user
	public static AquariumFish fishInput() {
		AquariumFish newFish = null;
		int fishType, fishAge, patternChoice, colorAmount, color;
		double fishLength;
		Patterns fishPattern;
		boolean isColorIn;
		Colors[] fishColors;
		Colors fishColor;
		Colors[] goldFishOp = { Colors.BLACK, Colors.ORANGE, Colors.GOLD, Colors.YELLOW };

		// type input
		System.out.println("enter type of the fish: 1 for aquariumfish, 2 for goldfish, 3 for clownfish");
		fishType = readInRange(1, 3, scn);

		// age input
		System.out.println("enter fish age");
		fishAge = readInRange(0, 150, scn);

		// length input
		System.out.println("enter fish length");
		fishLength = readInRange(0, 20, scn);

		if (fishType == 1) { // aqua fish
			// pattern input
			System.out.println("enter 0 for DOTS or 1 for STRIPES, or 2 for SPOTS, or 3 for SMOOTH");
			patternChoice = readInRange(0, 3, scn);
//			patternChoice = scn.nextInt();
			fishPattern = Patterns.values()[patternChoice];
			// colors input
			isColorIn = true;
			System.out.println("enter how many colors for the fish :");
			colorAmount = scn.nextInt();
			fishColors = new Colors[colorAmount];
			System.out.println(
					"fish colors : 0 BLACK, 1 WHITE, 2 GREEN, 3 ORANGE, 4 BLUE, 5 YELLOW, 6 BROWN, 7 GOLD, 8 RED, 9 CYAN");
			for (int i = 0; i < colorAmount; i++) {
				System.out.println("enter color number " + (i + 1));
				color = readInRange(0, 9, scn);
				fishColor = Colors.values()[color];
				while (isColorIn == true) {
					isColorIn = false;
					for (int j = 0; j < i; j++) {
						if (fishColors[j] == fishColor) {
							System.out.println("color inside already, please choose again ");
							color = scn.nextInt();
							fishColor = Colors.values()[color];
							isColorIn = true;
							break;
						}
					}
				}
				fishColors[i] = Colors.values()[color];
				isColorIn = true;
			}
			newFish = new AquariumFish(fishAge, fishLength, fishPattern, fishColors);
		} else if (fishType == 2) { // gold fish
			System.out.println("choose color: 1-orange, 2-gold, 3-yellow, 4-black");
			color = scn.nextInt();
			while ((color > 4) || (color < 1)) {
				System.out.println("invalid choice, try again ");
				color = readInRange(1, 4, scn);
			}
			fishColors = new Colors[1];
			fishColors[0] = goldFishOp[color];
			newFish = new GoldFish(fishAge, fishLength, fishColors);
		} else {
			fishColors = new Colors[3];
			fishColors[0] = Colors.ORANGE;
			fishColors[1] = Colors.BLACK;
			fishColors[2] = Colors.WHITE;
			newFish = new ClownFish(fishAge, fishLength, fishColors);
		}

		return newFish;
	}

	@SuppressWarnings("unchecked")
	public static <T extends Number> T readInRange(T min, T max, Scanner scanner) {
		T value = null;
		boolean finished = false;
		while (!finished) {
			try {
				if (min instanceof Integer) {
					value = (T) Integer.valueOf(scanner.nextInt());
				} else if (min instanceof Double) {
					value = (T) Double.valueOf(scanner.nextDouble());
				} else if (min instanceof Long) {
					value = (T) Long.valueOf(scanner.nextLong());
				} else {
					System.out.println("I don't know what type of number this is...");
				}
				if (min.doubleValue() <= value.doubleValue() && value.doubleValue() <= max.doubleValue()) {
					finished = true;
				} else {
					System.out.println("Please enter a value between " + min + " and " + max + ".");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid number.");
				scanner.nextLine(); // Consume invalid input
			}
		}
		scanner.nextLine(); // Consume newline
		return value;
	}

}
