package group1src;

import java.util.HashMap;
import java.util.Map;

public class GameMap {

	private int sizeX;
	private int sizeY;
	private Map<Integer,Boolean> aliveCell;
	
	public GameMap(int sizeX, int sizeY, HashMap<Integer,Boolean> aliveCell) {
		super();
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.aliveCell = aliveCell;
	}
	
	public void update() {
		for(Integer position:aliveCell.keySet()) {
		updateSelf(position);
		updateNeighbour(position);
		}
	}
	
	private void updateSelf(int position) {
		
	}
	
	private void updateNeighbour(int poisition) {
		
	}
	
	private int getxOfPosition(int position) {
		int x = position%sizeX;
		return x;
	}
	
	private int getyOfPosition(int position) {
		int y = position/sizeY;
		return y;
	}
	
	public void display() {
		
	}
}
