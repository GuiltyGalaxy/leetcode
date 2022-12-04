package contest.bc87;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class L6184 {
	public static void main(String[] args) {
		new L6184();
	}

	L6184() {
	}

	public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String aA = "2001-" + arriveAlice;
		String lA = "2001-" + leaveAlice;
		String aB = "2001-" + arriveBob;
		String lB = "2001-" + leaveBob;
		LocalDate aA_date = LocalDate.parse(aA, dtf);
		LocalDate lA_date = LocalDate.parse(lA, dtf);
		LocalDate aB_date = LocalDate.parse(aB, dtf);
		LocalDate lB_date = LocalDate.parse(lB, dtf);
		if (lA_date.isBefore(aB_date) || lB_date.isBefore(aA_date)) {
			return 0;
		}
		LocalDate startDate = null;
		LocalDate endDate = null;
		if (aA_date.isBefore(aB_date)) {
			startDate = aB_date;
		} else {
			startDate = aA_date;
		}
		if (lA_date.isBefore(lB_date)) {
			endDate = lA_date;
		} else {
			endDate = lB_date;
		}
		return (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
	}

}
