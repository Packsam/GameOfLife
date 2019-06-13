package group1test;

import java.util.HashMap;

import group1src.GameMap;

public class UpdateSelfTest {
	public static void main(String[] args) {
		UpdateSelfTest test = new UpdateSelfTest();
		int[] input = {5,10,15};
		int[] output = {10,11};
		test.testBoundary(input, output);
		
		
		HashMap<Integer, Boolean> map = new HashMap<>();
		map.put(7, true);
		map.put(12,true);
		map.put(11,true);
		
		GameMap gameMap = new GameMap(5,5,map);
		gameMap.update();
		
		map = gameMap.getAliveCell();
		System.out.println(" when input is 7,11,12, should output true, true, true, true ,  "+map.containsKey(6)+map.containsKey(7)+map.containsKey(11)+map.containsKey(12));
		
	}
	public void testBoundary(int[] input, int[] output) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int i=0;i<input.length;i++) {
			map.put(input[i],true);
		}
		
		GameMap gameMap = new GameMap(5,5,map);
		gameMap.update();
		
		map = gameMap.getAliveCell();
		
		for(Integer pos : map.keySet()) {
			System.out.println(pos);
		}
		
		for(int i=0;i<output.length;i++) {
			if(!map.containsKey(output[i])) {
				System.out.println("false: can not find " + output[i]);
			}
		}	
	}
}
