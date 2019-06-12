package group1src;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameMap {

	private int sizeX;
	private int sizeY;
	private ConcurrentHashMap<Integer,Boolean> aliveCell;
	
	public GameMap(int sizeX, int sizeY, ConcurrentHashMap<Integer,Boolean> aliveCell) {
		super();
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.aliveCell = aliveCell;
	}
	
	public void update() {
		ConcurrentHashMap<Integer,Boolean> tempAliveCell = aliveCell;
		for(Integer position:aliveCell.keySet()) {
			int xTemp = getxOfPosition(position);
			int yTemp = getyOfPosition(position);
			updateSelf(xTemp,yTemp,tempAliveCell);
			updateNeighbour(xTemp,yTemp,tempAliveCell);
			aliveCell = tempAliveCell;
		}
	}
	
	private void updateSelf(int x,int y,ConcurrentHashMap<Integer, Boolean> tempAliveCell) {
		int numOfNeighbour =0;
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
		if(aliveCell.containsKey(assemblePosiotion(x, y))) {
			if((numOfNeighbour<2)||(numOfNeighbour>3)) {
				tempAliveCell.remove(assemblePosiotion(x, y));
			}
		}else {
			if(numOfNeighbour==3) {
				tempAliveCell.put(assemblePosiotion(x, y), true);
			}
		}
	}
	
	private void updateNeighbour(int x,int y,ConcurrentHashMap<Integer, Boolean> tempAliveCell) {
		for(int i = x-1;i<=x+1;i++) {
			for (int j = y-1;j<=y+1;j++) {
				if((i==x)&&(j==y)) {
					continue;
				}
				updateSelf(i, j,tempAliveCell);
			}
		}
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

	public ConcurrentHashMap<Integer, Boolean> getAliveCell() {
		return aliveCell;
	}

	public void setAliveCell(ConcurrentHashMap<Integer, Boolean> aliveCell) {
		this.aliveCell = aliveCell;
	}
}
