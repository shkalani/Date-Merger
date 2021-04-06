import java.time.LocalDate;
import java.util.*;

public class DateMergerMain {
	
	public static boolean isOverlapped(DateRange daterange1, DateRange daterange2) {
		if(daterange1.end.compareTo(daterange2.start) >= 0 && daterange2.end.compareTo(daterange1.start) > 0) {
			return true;
		}
		if(daterange2.end.compareTo(daterange1.start) >= 0 && daterange1.end.compareTo(daterange2.start) > 0) {
			return true;
		}
		return false;
		
	}

	public static void main(String[] args) {
		DateRange daterange1 = new DateRange(LocalDate.of(2014, 1, 1) , LocalDate.of(2014, 1, 30)); //1st jan to 30 jan
		DateRange daterange2 = new DateRange(LocalDate.of(2014, 1, 15) , LocalDate.of(2014, 2, 15)); //15 jan to 15 feb
		
		DateRange daterange3 = new DateRange(LocalDate.of(2014, 3, 10) , LocalDate.of(2014, 4, 15)); //10 mar to 15 apr
		DateRange daterange4 = new DateRange(LocalDate.of(2014, 4, 10) , LocalDate.of(2014, 5, 15)); //10 apr to 15 may
		
		List<DateRange> dateRanges = new ArrayList<>();
		dateRanges.add(daterange1);
		dateRanges.add(daterange2);

		dateRanges.add(daterange3);
		dateRanges.add(daterange4);
		
		DateMerger m = new DateMerger();
		List output = m.mergeDates(dateRanges);
		System.out.println("Merged dates are");
		m.printdates(output);
		
		

	}

}
