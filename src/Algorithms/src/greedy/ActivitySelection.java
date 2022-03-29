/****
The greedy choice is to always pick the next activity whose finish time is least 
among the remaining activities and the start time is more than or equal to the finish time 
of the previously selected activity. We can sort the activities according to their finishing 
time so that we always consider the next activity as minimum finishing time activity.

1) Sort the activities according to their finishing time 
2) Select the first activity from the sorted array and print it. 
3) Do the following for the remaining activities in the sorted array. 
…….a) If the start time of this activity is greater than or equal to the finish time of the previously 
    selected activity then select this activity.
*/

package Algorithms.src.greedy;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ActivitySelection {
    // sort the activities according to their finishing time
    public static List<List<Integer>> sort(Integer[][] activities) {
        List<List<Integer>> sortedActivities = new ArrayList<>();
        

        for(int i = 0; i < activities.length; i++) {
            sortedActivities.add(Arrays.asList(activities[i]));
        }

        for(int i = 0; i < activities.length; i++) {
            for(int j = i + 1; j < activities.length; j++) {
                if(sortedActivities.get(j).get(1) < sortedActivities.get(i).get(1)) {
                    List<Integer> temp = sortedActivities.get(i);
                    sortedActivities.set(i, sortedActivities.get(j));
                    sortedActivities.set(j, temp);
                }
            }
        }

        return sortedActivities;
    }

    public static List<List<Integer>> maxAcitivities(List<List<Integer>> activities) {
        List<List<Integer>> maxActivities = new ArrayList<>();

        // The first activity always gets selected
        maxActivities.add(activities.get(0));

        // Consider rest of the activities
        for(int i = 1; i < activities.size(); i++) {
            int n = maxActivities.size();

            // If the start time of this activity is greater than or equal to the finish time 
            // of the previously selected activity then select this activity
            if(activities.get(i).get(0) >= maxActivities.get(n-1).get(1)) {
                maxActivities.add(activities.get(i));
            }
        }

        return maxActivities;
    }

    public static void main(String[] args) {
        Integer[][] activities = {{0,6}, {3, 4}, {1, 2}, {5, 9}, {5, 7}, {8, 9}};

        // Sort the activities according to their finishing time
        List<List<Integer>> sortedActivities = sort(activities);

        List<List<Integer>> result = maxAcitivities(sortedActivities);
        System.out.println("Following activities are selected: " + result);
    }
}
