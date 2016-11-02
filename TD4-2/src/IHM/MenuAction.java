package IHM;

public abstract class MenuAction {
	private final String input;
	private final String action;
	
	public MenuAction(String action, String input){
		this.input = input;
		this.action =  action;
	}
	
	public abstract boolean action();
	
	public String displayMenuAction(){
		return input + " : " + action;
	}
	
	public boolean checkInput(String input){
		return input.equals(this.input);
	}
	
	public String getAction() {
		return this.action;
	}
}
