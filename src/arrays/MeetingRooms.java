package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * Problem 252
 * 
 * https://leetcode.com/problems/meeting-rooms/
 * 
 * @author Matt
 *
 */
public class MeetingRooms {

	static Interval[] intervals;

	public static void main(String[] args) {

		intervals = new Interval[3];
		intervals[0] = new Interval(0, 5);
		intervals[1] = new Interval(5, 10);
		intervals[2] = new Interval(15, 20);

		System.out.println(canAttendMeetings(intervals));
	}

	private static boolean canAttendMeetings(Interval[] intervals) {
		try {
			Arrays.sort(intervals, new IntervalComparator());
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private static class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start < o2.start && o1.end <= o2.start)
				return -1;
			else if (o1.start > o2.start && o1.start >= o2.end)
				return 1;
			throw new RuntimeException();
		}
	}

	private static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

}
