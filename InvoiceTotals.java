//
//  Mark Anthony Start :  180140208  -- C02220 -- cw1 -- 
//

import java.math.BigDecimal;


public class InvoiceTotals{

	private static final BigDecimal VAT_RATE = new BigDecimal(5);
	private final BigDecimal hourlyRate;
	private BigDecimal totalProjectDurationInHours;
	private BigDecimal baseAmountWithoutVAT;
	private BigDecimal totalVATAmount;
	private final boolean vatApplicable;
	private BigDecimal totalBillAmountIncludingApplicableVAT; 


	public InvoiceTotals( Project project ){

		this.hourlyRate = project.getHourlyRate();
		this.totalProjectDurationInHours = new BigDecimal( project.getProjectDurationInHoursForBill() );
		this.baseAmountWithoutVAT = hourlyRate.multiply( totalProjectDurationInHours );	
		this.vatApplicable = project.getVatApplicable();
		this.totalVATAmount = calculateTotalVATAmount();
		this.totalBillAmountIncludingApplicableVAT = baseAmountWithoutVAT.add( totalVATAmount );

	}

	private BigDecimal calculateTotalVATAmount() {
	
		if ( vatApplicable ){
			return baseAmountWithoutVAT.divide( VAT_RATE );
		} else {
			return new BigDecimal(0);
		}

	}

	public void setTotalProjectDurationInHours( BigDecimal totalHours ){
		this.totalProjectDurationInHours = totalHours;
	}

	public void setBaseAmountWithoutVAT( BigDecimal baseAmountNoVAT ){
		this.baseAmountWithoutVAT = baseAmountNoVAT;
	}

	public void setTotalVATAmount( BigDecimal totalVATAmount ) {
		this.totalVATAmount = totalVATAmount;
	}

	public void setTotalBillAmountIncludingApplicableVAT( BigDecimal total) {
		this.totalBillAmountIncludingApplicableVAT = total;
	}


	public BigDecimal getVATRate(){
		return this.VAT_RATE;
	}

	public BigDecimal getHourlyRate() {
		return this.hourlyRate;
	}

	public BigDecimal getTotalProjectDurationInHours(){
		return this.totalProjectDurationInHours;
	}

	public BigDecimal getBaseAmountWithoutVAT(){
		return this.baseAmountWithoutVAT;
	}

	public BigDecimal getTotalVATAmount(){
		return this.totalVATAmount;
	}

	public boolean getVatApplicable(){
		return this.vatApplicable;
	}	

	public BigDecimal getTotalBillAmountIncludingApplicableVAT() {
		return this.totalBillAmountIncludingApplicableVAT;
	}

}
