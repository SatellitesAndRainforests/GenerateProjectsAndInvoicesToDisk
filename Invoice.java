//
//  Mark Anthony Start :  180140208  -- C02220 -- cw1 -- 
//

import java.math.BigDecimal;
import java.time.*;

// The dafualt date format of LocalDate is used here, as it is the same as the Ugly class format for creating the 'file Name'. 
// The format is only made explicit in the writeInvoiceToDisk class;


public class Invoice {

	private final int invoiceId;
	private BusinessProcess businessProcess;
	private InvoiceTotals invoiceTotals;
	private final LocalDate invoiceDate;


	public Invoice( int id, BusinessProcess businessProcess ) {

		this.invoiceId = id;
		this.businessProcess = businessProcess;
		this.invoiceTotals =  new InvoiceTotals( businessProcess.getProject() );
		this.invoiceDate = LocalDate.now();

	}


	public int getId(){
		return invoiceId;
	}

	public LocalDate getInvoiceDate(){
		return invoiceDate;
	}

	public BusinessProcess getBusinessProcess(){
		return businessProcess;
	}

	public InvoiceTotals getInvoiceTotals(){
		return invoiceTotals;
	}

	public void setBusinessProcess( BusinessProcess businessProcess ) {
		this.businessProcess = businessProcess;
	}

	public void setInvoiceTotals( InvoiceTotals invoiceTotals ) {
		this.invoiceTotals = invoiceTotals;
	}

	
	public  String toString() {

		StringBuffer sb = new StringBuffer();

		sb.append("***********************************");
		sb.append("\n");
		sb.append("\t\t\t\t"+businessProcess.getVendor().getContactDetails().getContactName());
		sb.append("\n");
		sb.append("\t\t\t\t"+businessProcess.getVendor().getOrganizationName());
		sb.append("\n");
		sb.append("\t\t\t\t"+businessProcess.getVendor().getContactDetails().getAddress());
		sb.append("\n");
		sb.append("\t\t\t\tp: "+businessProcess.getVendor().getContactDetails().getPhoneNumber());
		sb.append("\n");
		sb.append("\t\t\t\tf: "+businessProcess.getVendor().getContactDetails().getFaxNumber());
		sb.append("\n");
		sb.append("\t\t\t\te: "+businessProcess.getVendor().getContactDetails().getEmailAddress());
		sb.append("\n");
		sb.append("\n\n");
		sb.append("To:");
		sb.append("\n");
		sb.append("\t"+businessProcess.getClient().getContactDetails().getContactName());
		sb.append("\n");
		sb.append("\t"+businessProcess.getClient().getOrganizationName());
		sb.append("\n");
		sb.append("\t"+businessProcess.getClient().getContactDetails().getAddress());
		sb.append("\n\n");
		sb.append("Invoice ID: "+ invoiceId);
		sb.append("\n");
		sb.append("Invoice date: "+ invoiceDate);
		sb.append("\n");
		sb.append("Project ID: "+businessProcess.getProject().getId());
		sb.append("\n");
		sb.append("Project name: "+businessProcess.getProject().getName());
		sb.append("\n");
		sb.append("Project description: "+businessProcess.getProject().getDescription());
		sb.append("\n");
		sb.append("Start Date: "+businessProcess.getProject().getDateKeeper().getStartDate());
		sb.append("\n");
		sb.append("End Date: "+businessProcess.getProject().getDateKeeper().getStopDate());
		sb.append("\n");
		sb.append("Billing rate: "+businessProcess.getProject().getHourlyRate() + " an hour");
		sb.append("\n");
		sb.append("Number of hours billed: "+businessProcess.getProject().getProjectDurationInHoursForBill());
		sb.append("\n\n");
		sb.append("Sub-total (without VAT): "+invoiceTotals.getBaseAmountWithoutVAT());
		sb.append("\n");
		sb.append("VAT payable: "+invoiceTotals.getVatApplicable());
		sb.append("\n");
		sb.append("\n\n");
		sb.append("\n");
		sb.append("Total VAT: " + invoiceTotals.getTotalVATAmount());
		sb.append("\n");
		sb.append("Total (including VAT): "+invoiceTotals.getTotalBillAmountIncludingApplicableVAT());
		sb.append("\n");
		sb.append("***********************************");

		return sb.toString();

	}

}	




