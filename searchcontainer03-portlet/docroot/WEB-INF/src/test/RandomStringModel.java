package test;

public class RandomStringModel {
	private String string;
	private long id;

	public RandomStringModel(String string, long id) {
		super();
		this.string = string;
		this.id = id;
	}

	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
