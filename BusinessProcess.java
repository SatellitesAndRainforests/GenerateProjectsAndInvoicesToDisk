//
//  Mark Anthony Start :  180140208  -- C02220 -- cw1 --
//


public class BusinessProcess {

	private Organization vendor;
	private Organization client;
	private Project project;
	private Invoice invoice;


	public BusinessProcess( Organization vendor, Organization client, Project project ) {

		this.vendor = vendor;
		this.client = client;
		this.project = project;

	}


	public void startProject(){
		this.project.getDateKeeper().setStartDate();
	}

	public void projectComplete(){
		this.project.getDateKeeper().setStopDate();		
		this.project.setProjectDurationInHoursForBill( HowManyHoursToBillStaticUtilityClass.howManyHoursToBill( this.getProject().getDateKeeper() ) );
	}

	public void generateInvoice(int invoiceId) {
		this.invoice = new Invoice( invoiceId, this);
	}

	public void writeInvoiceToDisk(){
		writeInvoiceToDisk.writeToFile(this);	
	}


	public Organization getVendor(){
		return this.vendor;
	}

	public Organization getClient(){
		return this.client;
	}

	public Project getProject(){
		return this.project;
	}

	public Invoice getInvoice(){
		return this.invoice;
	}

	public void setVendor( Organization vendor ){
		this.vendor = vendor;
	}

	public void setClient( Organization client ){
		this.client = client;
	}

	public void setProject( Project project ) {
		this.project = project;
	}

	public void setInvoice( Invoice invoice ) {
		this.invoice = invoice;
	}

}
