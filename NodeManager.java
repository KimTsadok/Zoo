package zoo;

public class NodeManager {
	private PenguinNode head;

	public NodeManager() {
		this.head = null;
	}

	public PenguinNode getHead() {
		return head;
	}

	public void addPenguin(Penguin newPenguin) throws ZooExceptions {
		PenguinNode newNode = new PenguinNode(newPenguin);
		PenguinNode current = this.head;

		if (current == null) {
			this.head = newNode;
		} else {
			if (newNode.getData().getAge() <= 0 || newNode.getData().getAge() >= 30)
				throw new ZooExceptions("invalid age", "The penguin's age cant be negative or too high");
			if (newNode.getData().getHeight() >= current.getData().getHeight()) {
				throw new ZooExceptions("invalid height", "the penguin can't be higher than the leader");
			} else {
				if (newNode.getData().getHeight() <= 0) {
					throw new ZooExceptions("invalid height", "Height cant be negative or zero");
				}
			else {
			while ((current.getNext() != null)
					&& (current.getNext().getData().getHeight() > newNode.getData().getHeight())) {
				current = current.getNext();
			}
			if (current.getNext() != null) {
				newNode.setNext(current.getNext());
			}
			current.setNext(newNode);
		}
			}
		}
		System.out.println("penguin added succesfuly");
	}

	public int countOrFeedPenguin() { // also to feed penguin
		int count = 0;
		PenguinNode current = this.head;
		while (current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}

	public void printAllPenguin() {
		PenguinNode current = this.head;
		while (current != null) {
			String pengDet = current.getData().toString();
			System.out.println(pengDet);
			current = current.getNext();
		}
	}

	public void allPenguinNoise() {
		PenguinNode current = this.head;
		while (current != null) {
			System.out.print(current.getData().penguinNoise());
			current = current.getNext();
		}
	}
}
