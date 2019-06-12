package group1src;

import java.util.HashMap;
import java.util.Map;

public class GameMap {

	private int sizeX;
	private int sizeY;
	private HashMap<Integer,Boolean> aliveCell;
	
	public GameMap(int sizeX, int sizeY, HashMap<Integer,Boolean> aliveCell) {
		super();
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.aliveCell = aliveCell;
	}
	
	public void update() {
		for(Integer position:aliveCell.keySet()) {
			int xTemp = getxOfPosition(position);
			int yTemp = getyOfPosition(position);
			updateSelf(xTemp,yTemp);
			updateNeighbour(xTemp,yTemp);
		}
	}
	
	private void updateSelf(int x,int y) {
		int numOfNeighbour =0 ;
		for(int i = x-1;i <=x+1;i++) {
			for(int j = y-1;j<=y+1;j++) {
				if((i==x)&&(j==y)) {
					continue;
				}
				if(aliveCell.containsKey(assemblePosiotion(i, j))) {
					numOfNeighbour++;
				}
			}
		}
		if((numOfNeighbour<2)||(numOfNeighbour>3)) {
			aliveCell.remove(assemblePosiotion(x, y));
		}
	}
	
	private void updateNeighbour(int x,int y) {
		
	}
	
	private int getxOfPosition(int position) {
		int x = position%sizeX;
		return x;
	}
	
	private int getyOfPosition(int position) {
		int y = position/sizeY;
		return y;
	}
	
	private Integer assemblePosiotion(int x,int y) {
		return new Integer(y*sizeX+x);
	}
	
	public void display() {
		
	}

	public HashMap<Integer, Boolean> getAliveCell() {
		return aliveCell;
	}

	public void setAliveCell(HashMap<Integer, Boolean> aliveCell) {
		this.aliveCell = aliveCell;
	}
}
