package Q_GFG_MeetingRooms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class MeetingRooms2 {

	public static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}


	public static int findMinNoOfMeetingRooms(Interval[] intervals) {
		
		if(intervals == null || intervals.length ==0) {
			return -1;
		}
		Arrays.sort(intervals, (a,b)->Integer.compare(a.start, b.start));
		
//		Arrays.sort(intervals, new Comparator<Interval>() {
//			public int compare(Interval i1,Interval i2) {
//				return i1.start - i2.start;
//			}
//		});
		
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		q.add(intervals[0].end);
		
		for(int i=1;i<intervals.length;i++) {
			int temp = q.peek();
			if(temp < intervals[i].start) {
				q.poll();
//				q.add(intervals[i].end);
			}
			q.add(intervals[i].end);
			
		}
		
		
		return q.size();
		
	}

	public static void main(String[] args) {
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(0, 30);
		intervals[1] = new Interval(5, 20);
		intervals[2] = new Interval(21, 24);
//		intervals[3] = new Interval(10, 15);
//		intervals[4] = new Interval(27, 45);
//		intervals[5] = new Interval(31, 40);
		System.out.println("Min no of meeting rooms required is " + findMinNoOfMeetingRooms(intervals));
	}

}
