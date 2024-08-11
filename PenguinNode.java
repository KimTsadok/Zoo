package zoo;

public class PenguinNode {
	private Penguin data;
	private PenguinNode next;

	// c'tor
	public PenguinNode(Penguin penguin) {
		this.data = penguin;
		this.next = null;
	}

	// getters and setters
	public Penguin getData() {
		return data;
	}

	public void setData(Penguin data) {
		this.data = data;
	}

	public PenguinNode getNext() {
		return next;
	}

	public void setNext(PenguinNode next) {
		this.next = next;
	}

	public String toString() {
		return "PenguinNode [data=" + data + ", next=" + next + "]";
	}
}
