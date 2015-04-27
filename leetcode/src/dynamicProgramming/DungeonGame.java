package dynamicProgramming;
/**
 * 174
 * https://leetcode.com/problems/dungeon-game/
 * 
 * Write a function to determine the knight's minimum initial health so that
 * he is able to rescue the princess.
 * For example, given the dungeon below,
 * the initial health of the knight must be at least 7 if he follows the optimal
 * path RIGHT-> RIGHT -> DOWN -> DOWN.
 * -2	-3		3
 * -5	-10		1
 * 10	30		-5
 * 
 * @author yili3
 *
 */
public class DungeonGame {
	public static int calculateMinimumHP(int[][] dungeon) {
		if(dungeon==null || dungeon.length==0)	return 0;
        int[] global=new int[dungeon[0].length], local=new int[dungeon[0].length];
        for(int i=0; i<dungeon[0].length; i++)	global[i] = 1;
        
        for(int i=0; i<dungeon.length; i++){
        	for(int j=0; j<dungeon[0].length; j++){
        		if(i>0 && j>0){
            		global[j] = Math.min(Math.max(global[j-1], Math.max(1, -local[j-1]-dungeon[i][j]+1)), 
            				Math.max(global[j], Math.max(1, -local[j]-dungeon[i][j]+1)));
            		local[j] = Math.max(local[j], local[j-1])+dungeon[i][j];
        		}
        		else if(j>0){
        			local[j] = local[j-1]+dungeon[i][j];
        			global[j] = Math.max(global[j-1], -local[j]+1);
        		}else{
        			local[j] = local[j]+dungeon[i][j];
        			global[j] = Math.max(global[j],  -local[j]+1);
        		}
        	}
        }
        
        return global[dungeon[0].length-1];
    }
	public static void main(String[] args){
		int[][] dungeon = new int[2][2];
		dungeon[0][0] = -10; dungeon[0][1] = -11;
		dungeon[1][0] = 3; dungeon[1][1] = -2;
		System.out.print(calculateMinimumHP(dungeon));
	}
}
