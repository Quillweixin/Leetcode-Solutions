class Solution {
    public int[] gas,cost;
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0) return -1;
        this.gas = gas;
        this.cost = cost;
        for(int i = 0; i < gas.length;i++){
            if(gas[i] < cost[i]) continue;
            if(isValid(i)) return i;
        }
        return -1;
    }
    
    public boolean isValid(int start){
        int tank = gas[start];
        tank -= cost[start];
        int len = gas.length;
        int i = (start + 1)%len;
        while(i != start){
            tank += gas[i];
            tank -= cost[i];
            if(tank < 0) return false;
            i = (i+1) % len;
        }
        return true;
    }
}

// one-pass solution
/*
1. Initiate total_tank and curr_tank as zero, and choose station 0 as a starting station.

2. Iterate over all stations :

  - Update total_tank and curr_tank at each step, by adding gas[i] and subtracting cost[i].

  - (Important!!) If curr_tank < 0 at i + 1 station, make i + 1 station a new starting point and reset curr_tank = 0 to start with an empty tank.

4. Return -1 if total_tank < 0 and starting station otherwise.
*/

public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;

    int total_tank = 0;
    int curr_tank = 0;
    int starting_station = 0;
    for (int i = 0; i < n; ++i) {
      total_tank += gas[i] - cost[i];
      curr_tank += gas[i] - cost[i];
      // If one couldn't get here,
      if (curr_tank < 0) {
        // Pick up the next station as the starting one.
        starting_station = i + 1;
        // Start with an empty tank.
        curr_tank = 0;
      }
    }
    return total_tank >= 0 ? starting_station : -1;
  }