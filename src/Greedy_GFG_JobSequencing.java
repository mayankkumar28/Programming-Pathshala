import java.util.Arrays;

//We sort on the basis of profit first and then do the job as late as possible
//Do this opens slots for jobs with lesser deadline,
//We fill the slots based on highest profit, and if slot at deadline is not available we look for dates before it


public class Greedy_GFG_JobSequencing {
    int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> {
            if (a.profit != b.profit) return b.profit - a.profit;
            else return a.deadline - b.deadline;
        });
        int[] ans = new int[2];
        boolean[] slots = new boolean[n];
        int profit = 0;
        int number_of_jobs = 0;
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(n, arr[i].deadline) - 1; j >= 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    profit += arr[i].profit;
                    number_of_jobs++;
                    break;
                }
            }
        }
        ans[0] = number_of_jobs;
        ans[1] = profit;
        return ans;
    }

    class Job {
        int profit;
        int deadline;
        Job(int p, int d){
            this.profit = p;
            this.deadline =d;
        }
    }
}


