//
//  Mark Anthony Start :  180140208  -- C02220 -- cw1 -- 
//

import java.time.*;
import java.time.temporal.ChronoUnit;


public class HowManyHoursToBillStaticUtilityClass {

	public static int howManyHoursToBill( DateKeeper projectDates ) {
		
		LocalDate startDate = projectDates.getStartDate();
		LocalDate stopDate = projectDates.getStopDate();

		long totalProjectDurationInDaysInclusive = ChronoUnit.DAYS.between( startDate, stopDate ) + 1;
		long totalProjectDurationWeekdaysOnlyInclusive = howManyWeekdays( startDate, totalProjectDurationInDaysInclusive );

		int totalHoursToBill = Math.toIntExact( totalProjectDurationWeekdaysOnlyInclusive * 7 );  // based on a 7 hour work day.

		return totalHoursToBill;

	}


// I based the below method on Modus Tollens' Answer at : Thanks Modus Tollens !
// https://stackoverflow.com/questions/33942544/how-to-skip-weekends-while-adding-days-to-localdate-in-java-8
// It assumes projects can only be started on a weekeday, a countable day.
// The simple inaccruate logic is addressed in the testing section of test.	


	private static long howManyWeekdays( LocalDate startDate, long totalDaysInclusive ){

                if ( totalDaysInclusive == 1 ) return 1;

                LocalDate iterationThroughDaysDay = startDate;
                long totalWeekdays = 0;
                long totalDaysCountdown = totalDaysInclusive;

                while ( totalDaysCountdown > 0 ) {
                
                        if ( !( iterationThroughDaysDay.getDayOfWeek() == DayOfWeek.SATURDAY || iterationThroughDaysDay.getDayOfWeek() == DayOfWeek.SUNDAY)) totalWeekdays ++;
                        iterationThroughDaysDay = iterationThroughDaysDay.plusDays(1);              
                        totalDaysCountdown--;
                }       
        	
		return totalWeekdays;
        }

}
