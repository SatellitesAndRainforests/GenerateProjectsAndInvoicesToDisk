//
//  Mark Anthony Start :  180140208  -- C02220 -- cw1 -- 
//

import java.math.BigDecimal;

public class Project {

	private final int projectId;
	private final String projectName;
	private final String projectDescription;
	private DateKeeper dateKeeper;
	private int projectDurationInHoursForBill;
	private final BigDecimal projectHourlyRate;
	private final boolean vatApplicable;

	private Project( Builder builder ) {

		this.projectId = builder.projectId;
		this.projectName = builder.projectName;
		this.projectDescription = builder.projectDescription;
		this.dateKeeper = builder.dateKeeper;
		this.projectHourlyRate = builder.projectHourlyRate;
		this.vatApplicable = builder.vatApplicable;

	}


	public void setProjectDurationInHoursForBill( int hoursForBill ) {
		if ( hoursForBill < 0 ) throw new IllegalArgumentException();
		this.projectDurationInHoursForBill = hoursForBill;
	}

	public void setDateKeeper( DateKeeper dateKeeper ) {
		this.dateKeeper = dateKeeper;
	}

	public int getId() {
		return this.projectId;
	}

	public String getName() {
		return this.projectName;
	}

	public String getDescription() {
		return this.projectDescription;
	}

	public DateKeeper getDateKeeper(){
		return this.dateKeeper;
	}

	public int getProjectDurationInHoursForBill() {
		return this.projectDurationInHoursForBill;
	}

	public BigDecimal getHourlyRate() {
		return this.projectHourlyRate;
	}

	public boolean getVatApplicable(){
		return this.vatApplicable;
	}


		public static class Builder {

			private int projectId;
			private String projectName;
			private String projectDescription;
			private DateKeeper dateKeeper;
			private BigDecimal projectHourlyRate;
			private boolean vatApplicable;	


			public Builder projectId(final int id){

				if ( id < 0 ) throw new IllegalArgumentException();

				this.projectId = id;

				return this;

			}

			public Builder projectName(final String name){
				this.projectName = name;
		       		return this;
			}	

			public Builder projectDescription(final String description) {
				this.projectDescription = description;
				return this;
			}

			public Builder dateKeeper( DateKeeper dateKeeper) {
				this.dateKeeper = dateKeeper;
				return this;
			}

			public Builder projectHourlyRate(final BigDecimal hourlyRate ) {

				if (hourlyRate.compareTo(BigDecimal.ZERO) >= 0)
				this.projectHourlyRate = hourlyRate;

				return this;

			}

			public Builder vatApplicable(final boolean vatApplicable){
				this.vatApplicable = vatApplicable;
				return this;
			}

			public Project build() {
				return new Project(this);
			}
		}
}
















