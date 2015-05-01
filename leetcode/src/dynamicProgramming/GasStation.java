package dynamicProgramming;
/**
 * 134
 * https://leetcode.com/problems/gas-station/
 * 
 * There are N gas stations along a circular route, where the amount of gas
 * at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once,
 * otherwise return -1.
 * 
 * @author yili3
 *
 */
public class GasStation {
	/* Greedy */
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int recent = 0, start = 0, total = 0;
		for (int i = 0; i < gas.length; i++) {
			int current = gas[i]-cost[i];
			total += current;
			recent += current;
			if (recent < 0) {
				recent = 0;
				start = i+1;
			}
		}
		return (total>=0)?start:-1;
    }
	
	/* Mine: Using algorithm same with #MaximumSubarray*/
	public int canCompleteCircuitMine(int[] gas, int[] cost) {
		int local = 0, global = gas[0] - cost[0], start = 0, localStart = 0, total = 0;
		for (int i = 0; i < 2*gas.length; i++) {
			int current = gas[i % gas.length] - cost[i % gas.length];
			if(i<gas.length)	total += current;
			if (local + current > current)	local += current;
			else {
				local = current;
				localStart = i;
			}
			if (global < local) {
				global = local;
				start = localStart;
			}
		}
		return (total>=0)?start:-1;
	}
}
