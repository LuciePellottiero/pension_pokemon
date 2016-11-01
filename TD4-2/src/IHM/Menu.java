package IHM;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

public class Menu {
	private final Collection<MenuAction> actions;
	private final String menuName;
	private final BufferedReader reader;
	
	public Menu(String menuName, BufferedReader reader){
		actions = new LinkedList<MenuAction>();
		this.menuName = menuName;
		this.reader = reader;
	}
	
	public void addAction(MenuAction menuAction){
		actions.add(menuAction);
	}
	
	private String displayMenu(){
		String res = menuName + System.lineSeparator();
		for(MenuAction action : actions){
			res += action.displayMenuAction() + System.lineSeparator();
		}
		return res;
	}
	
	private boolean checkInput(String input){
		for(MenuAction action : actions){
			if(action.checkInput(input)){
				return action.action();
			}
		}
		return false;
	}
	
	public void menu(){
		String input = "";
		boolean isRecognized = false;
		while(isRecognized == false){
			System.out.println(this.displayMenu());
			try {
				input = reader.readLine();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			isRecognized = checkInput(input);		
		}
	}
}