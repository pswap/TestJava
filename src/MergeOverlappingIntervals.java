import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
https://www.programcreek.com/2012/12/leetcode-merge-intervals/
 */
public class MergeOverlappingIntervals {
	
	public static class Interval {
		int start;
		int end;
		
		public Interval(int start, int end) {
			this.start= start;
			this.end = end;
		}
	}
	
	public static List<Interval> merge(List<Interval> a) {
		if(a.isEmpty() || a == null)
			return a;
		
		List<Interval> result = new ArrayList<Interval>();
		
		Collections.sort(a, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		
		Interval prev = a.get(0);
		for(int i=1;i<a.size();i++) {
			Interval curr = a.get(i);
			if(curr.start > prev.end) {  // means these are not overlapping
				result.add(prev);
				prev = curr;
			} else {
				Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
				prev = merged;
			}
		}
		result.add(prev);
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> a = new ArrayList<Interval>();
		//a.add(new Interval(6,8));
		//a.add(new Interval(1,9));
		//a.add(new Interval(2,4));
		//a.add(new Interval(4,7));
		a.add(new Interval(1,3));
		a.add(new Interval(2,4));
		a.add(new Interval(5,7));
		a.add(new Interval(6,8));
		List<Interval> res = merge(a);
		for(int i=0;i<res.size();i++) {
			System.out.print(res.get(i).start +" " + res.get(i).end +", ");
		}

	}

}
