# GenerateProjectsAndInvoicesToDisk
create projects and when complete generate a invoice and save it to disk

# Test.java
The test object contains a 'Testing report'. 
It also imitates the creation of a project between a client and a vendor, initates the project with a start date and imitates its completion, generates an invoice and saves that invoice to disk.

# To run
javac compile all .java files in a terminal, '$ java Test' to run the test, but also try modifying Test.java, the consturctors use a clear Builder format for easy data entry. 

//The output saved to file

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
		sb.append("VAT RATE: "+invoiceTotals.getVATRate());
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
