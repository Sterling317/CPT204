package lab14;

import java.util.ArrayList;

public class MaxAttendance {

    private ALBinHeap<CourseActivity> minPQ1;
    private ALBinHeap<CourseActivity> minPQ2;


    // LAB 14 PART B MAX ATTENDANCE

    public MaxAttendance(ArrayList<CourseActivity> activities) {
        minPQ1 = new ALBinHeap<>();
        minPQ2 = new ALBinHeap<>();
        for (CourseActivity activity : activities) {
            minPQ1.add(activity,activity.getStartTime() + (activity.getDay()-1)*24);
            minPQ2.add(activity,activity.getEndTime() + (activity.getDay()-1)*24);
        }
    }

    public int maxAttendance() {
//        minPQ1.delMin();
//        minPQ2.delMin();
//        CourseActivity activity1 = minPQ1.getMin();
//        CourseActivity activity2 = minPQ2.getMin();
//        int maxStudent = 0;
//        int currMax = 0;
//        int size = minPQ1.size();
//        for (int i = 0; i < size; i++) {
//            CourseActivity day1 = minPQ1.delMin();
//            while (day1.getDay() != minPQ2.getMin().getDay()) {
//                currMax -= minPQ2.delMin().getNumStudents();
//            }
//            while (day1.getDay() == minPQ2.getMin().getDay() && activity1.getStartTime() >= activity2.getEndTime()) {
//                currMax -= activity2.getNumStudents();
//                minPQ2.delMin();
//            }
//            if (day1.getDay() == minPQ2.getMin().getDay()) {
//                currMax += day1.getNumStudents();
//            }
//            if (maxStudent < currMax) {
//                maxStudent = currMax;
//            }
//        }
//        return maxStudent;

//        return minPQ2.size();

        int maxStudent = 0;
        int currMax = 0;
        int size = minPQ1.size();
        for (int i = 0; i < size; i++) {
            CourseActivity ca1 = minPQ1.delMin();
            while (ca1.getDay() != minPQ2.getMin().getDay()) {
                currMax -= minPQ2.delMin().getNumStudents();
            }
            while (ca1.getDay() == minPQ2.getMin().getDay() && minPQ2.getMin().getEndTime() <= ca1.getStartTime()) {
                currMax -= minPQ2.getMin().getNumStudents();
                minPQ2.delMin();
            }

            if (ca1.getDay() == minPQ2.getMin().getDay()) {
                currMax += ca1.getNumStudents();
            }

            if (maxStudent < currMax) {
                maxStudent = currMax;
//                System.out.println(max);
            }
        }
        return maxStudent;
    }

    private static ArrayList<CourseActivity> createSchedule(int[] days, int[] startTimes, int[] endTimes, int[] studentNumbers) {
        ArrayList<CourseActivity> schedule = new ArrayList<>();
        for (int i = 0; i < startTimes.length; i++) {
            schedule.add(new CourseActivity("", "", days[i], startTimes[i], endTimes[i], studentNumbers[i], ""));
        }
        return schedule;
    }

    public static void main(String[] args) {
//        int[] days = {1, 1, 1, 1, 1, 1, 3};
//        int[] startTimes = {10, 14, 15, 16, 18, 19, 2};
//        int[] endTimes = {11, 17, 16, 17, 20, 22, 3};
//        int[] studentNumbers = {30, 10, 15, 30, 30, 20, 51};
        int[] days = {1, 1, 1, 2};
        int[] startTimes = {10, 14, 15, 9};
        int[] endTimes = {11, 16, 17, 11};
        int[] studentNumbers = {10, 25, 15, 35};
        MaxAttendance maxAtt = new MaxAttendance(createSchedule(days, startTimes, endTimes, studentNumbers));
        System.out.println(maxAtt.maxAttendance());
//        HeapVisualizer.heapVisualize(maxAtt.minPQ2.toArray());
//        int a = maxAtt.maxAttendance();
//        System.out.println(a);

    }

}
