package group1test;

import java.util.concurrent.ConcurrentHashMap;

import group1src.GameMap;

public class UpdateSelfTest {
	public static void main(String[] args) {
		ConcurrentHashMap<Integer, Boolean> map = new ConcurrentHashMap<>();
		map.put(7, true);
		map.put(12,true);
		map.put(11,true);
		
		GameMap gameMap = new GameMap(5,5,map);
		gameMap.update();
		
		map = gameMap.getAliveCell();
		System.out.println(" when input is 7,11,12, should output true, true, true, true ,  "+map.containsKey(6)+map.containsKey(7)+map.containsKey(11)+map.containsKey(12));

		
		
		
		
	}
}
