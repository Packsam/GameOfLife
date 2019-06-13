package group1test;

import java.util.HashMap;

import group1src.GameMap;

public class UpdateSelfTest {
	public static void main(String[] args) {
		UpdateSelfTest test = new UpdateSelfTest();
		int[] inputFirst = {5,10,15};
		int[] outputFirst = {10,11};
		test.testCase(input, output);

		int[] inputSecond = {6,11};
		int[] outputSecond = {};
		test.testCase(input, output);

		int[] inputThird = {6,11,12};
		int[] outputThird = {6,7,11,12};
		test.testCase(input, output);

		
		
	}
	public void testCase(int[] input, int[] output) {
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
		if(map.size()>output.length){
			for(Integer i:map.keySet()){
				boolean exist = false;
				for(int k:output){
					if(i==k){
						exist = true;
						break;
					}
				}
				if(!exist){
					System.out.println("false: redundant of "+output[i]);
				}
			}
		}
		}	
	}
}
