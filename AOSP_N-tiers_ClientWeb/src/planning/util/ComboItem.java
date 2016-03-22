package planning.util;

public class ComboItem {
	
	private String name;
	private Object value;
	
	public ComboItem(String name, Object value){
		
		setName(name);
		setValue(value);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return getName();
	}

}
