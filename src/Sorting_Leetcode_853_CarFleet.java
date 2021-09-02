import java.util.Arrays;

/*
To form a fleet we have to keep track of the time needed to reach the target
If a car takes less than or equal to a time as the car in-front it, it will catch up make a fleet with it
To keep track of fleets, it's easier to start with the car in lead, because cars can't overtake each other
we start from first by car having the least distance to cover, and we keep track of slowest car
if time taken by a car is more than or equal to slowest car, we count++, that is, this car will make will make a fleet
we do count++ and assign slowest car to this car, if next car is the slowest one again, it will also make a fleet,count++ and so on
if next cars has time less than the slowest car, they will all catch up to it and will not make different fleets
 */


public class Sorting_Leetcode_853_CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length, res=0;
        double[][] cars = new double[n][2];
        for (int i =0;i<n;i++) {
            cars[i]=new double[]{ position[i],(double) (target-position[i])/speed[i]};   //tuple of position and time taken
        }

        Arrays.sort(cars, (a,b) -> Double.compare(a[0],b[0]));   //Sorting based on position
        double current = 0;
        for (int i=n-1; i>=0;i--){     //starting from car having least distance from finish
            if(cars[i][1] > current){  //car has >= time taken by current slowest car, next car makes fleet
                current = cars[i][1];  //updating current slowest time
                res++;                 //updating fleet count
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        System.out.println(carFleet(target,position,speed));
    }
}
