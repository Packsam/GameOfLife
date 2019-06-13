package group1test;

import java.util.HashMap;

import group1src.GameMap;

public class UpdateSelfTest {
	public static void main(String[] args) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		map.put(6, true);
		map.put(7,true);
		map.put(8,true);
		
		GameMap gameMap = new GameMap(5,5,map);
		gameMap.update();
		
		map = gameMap.getAliveCell();
		System.out.println(" when input is 7,11,12, should output true, true, true, true ,  "+map.containsKey(2)+map.containsKey(7)+map.containsKey(12));
	
	}
}
