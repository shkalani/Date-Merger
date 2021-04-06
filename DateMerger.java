import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateMerger {
	public static boolean isOverlapped(DateRange daterange1, DateRange daterange2) {
		if(daterange1.end.compareTo(daterange2.start) >= 0 && daterange2.end.compareTo(daterange1.start) > 0) {
			return true;
		}
		if(daterange2.end.compareTo(daterange1.start) >= 0 && daterange1.end.compareTo(daterange2.start) > 0) {
			return true;
		}
		return false;
		
	}
	public static DateRange merge(DateRange daterange1, DateRange daterange2) {
		LocalDate start = (daterange1.start.compareTo(daterange2.start)>0 ) ? daterange2.start : daterange1.start ;
		LocalDate end = (daterange1.end.compareTo(daterange2.end)>0 ) ? daterange1.end : daterange2.end ;
		
		return new DateRange(start, end);
	}
	
	public List<DateRange> mergeDates(List<DateRange> dateRanges){
		List<DateRange> temp = new ArrayList<>();
		
		for(int i= 0; i< dateRanges.size()-1; i+=2) {
			if(isOverlapped(dateRanges.get(i) , dateRanges.get(i+1))) {
				temp.add(merge(dateRanges.get(i) , dateRanges.get(i+1)));
			}
			else {
				temp.add(dateRanges.get(i));
				temp.add(dateRanges.get(i+1));
			}
		}
		return temp;
	}
	
	public void printdates(List<DateRange> temp) {
		for(DateRange i: temp) {
			System.out.println(i.start + " - " + i.end);
		}
	}

}
