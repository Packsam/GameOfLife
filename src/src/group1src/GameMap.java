package group1src;

import java.util.Map;
import java.util.HashMap;

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
		HashMap<Integer,Boolean> tempAliveCell = (HashMap<Integer, Boolean>) aliveCell.clone();
		for(Integer position:aliveCell.keySet()) {
			int xTemp = getxOfPosition(position);
			int yTemp = getyOfPosition(position);
			updateSelf(xTemp,yTemp,tempAliveCell);
			updateNeighbour(xTemp,yTemp,tempAliveCell);
		}
		aliveCell = (HashMap<Integer, Boolean>) tempAliveCell.clone();
	}

	private void updateSelf(int x,int y,HashMap<Integer, Boolean> tempAliveCell) {
		if((x<0)||(y<0)||(x>=sizeX)||(y>=sizeY)) {
			return;
		}
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

	private void updateNeighbour(int x,int y,HashMap<Integer, Boolean> tempAliveCell) {
		for(int i = x-1;i<=x+1;i++) {
			for (int j = y-1;j<=y+1;j++) {
				if((i==x)&&(j==y)) {
					continue;
				}
				updateSelf(i, j,tempAliveCell);
			}
		}
	}

	public int getxOfPosition(int position) {
		int x = position%sizeX;
		return x;
	}

	public int getyOfPosition(int position) {
		int y = position/sizeY;
		return y;
	}

	public Integer assemblePosiotion(int x,int y) {
		if((x<0)||(y<0)||(x>=sizeX)||(y>=sizeY)) {
			return -1;
		}
		return new Integer(y*sizeX+x);
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public HashMap<Integer, Boolean> getAliveCell() {
		return aliveCell;
	}

	public void setAliveCell(HashMap<Integer, Boolean> aliveCell) {
		this.aliveCell = aliveCell;
	}
}