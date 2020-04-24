//
//  Mark Anthony Start :  180140208  -- C02220 -- cw1 -- 
//

import java.time.LocalDate;


public class DateKeeper {

	private LocalDate startDate;
	private LocalDate stopDate;

	
	public DateKeeper() {

	}


//overloads to allow for greater flexibility of setting dates throughout a project.


	public DateKeeper(LocalDate startDate, LocalDate stopDate) {

		this.startDate = startDate;
		this.stopDate = stopDate;

	}


	public void setStartDate( LocalDate date ){
		this.startDate = date;
	}
	
	public void setStartDate(){
		startDate = LocalDate.now();
	}

	public void setStopDate(){
		stopDate = LocalDate.now();
	}

	public LocalDate getStartDate() {
		return this.startDate;
	}

	public LocalDate getStopDate() {
		return this.stopDate;
	}

}

