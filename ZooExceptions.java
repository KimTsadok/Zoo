package zoo;

public class ZooExceptions extends Exception {
	private static final long serialVersionUID = 1828076787094666857L;
	private String error;
	private String errorDesc;

	public ZooExceptions(String error, String errorDesc) {
		this.error = error;
		this.errorDesc = errorDesc;
	}


	public String getError() {
		return error;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

}


