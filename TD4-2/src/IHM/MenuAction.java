package IHM;

public abstract class MenuAction {
	private final String input;
	
	public MenuAction(String input){
		this.input = input;
	}
	
	public abstract void action();
}
