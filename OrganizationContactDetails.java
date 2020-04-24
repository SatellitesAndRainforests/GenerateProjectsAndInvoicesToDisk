//
//  Mark Anthony Start :  180140208  -- C02220 -- cw1 -- 
//


public class OrganizationContactDetails {

        private String organizationContactName;
        private String organizationAddress;
        private String organizationPhoneNumber;
        private String organizationFaxNumber;
        private String organizationEmailAddress;


	private OrganizationContactDetails( Builder builder ) {

		this.organizationContactName = builder.organizationContactName;
		this.organizationAddress = builder.organizationAddress;
		this.organizationPhoneNumber = builder.organizationPhoneNumber;
		this.organizationFaxNumber = builder.organizationFaxNumber;
		this.organizationEmailAddress = builder.organizationEmailAddress;

	}


	public String getContactName() {
		return this.organizationContactName;
	}

	public String getAddress() {
		return this.organizationAddress;
	}

	public String getPhoneNumber() {
		return this.organizationPhoneNumber;
	}

	public String getFaxNumber() {
		return this.organizationFaxNumber;
	}

	public String getEmailAddress() {
		return this.organizationEmailAddress;
	}


	public static class Builder {

		private String organizationContactName;
        	private String organizationAddress;
        	private String organizationPhoneNumber;
        	private String organizationFaxNumber;
        	private String organizationEmailAddress;


		public Builder organizationContactName(String name){
			this.organizationContactName = name;
			return this;
		}

		public Builder organizationAddress(String address){
			this.organizationAddress = address;
			return this;
		}

		public Builder organizationPhoneNumber(String digits){
			this.organizationPhoneNumber = digits;
			return this;
		}

		public Builder organizationFaxNumber(String fax){
			this.organizationFaxNumber = fax;
			return this;
		}

		public Builder organizationEmailAddress(String email){
			this.organizationEmailAddress = email;
			return this;
		}

		public OrganizationContactDetails build(){
			return new OrganizationContactDetails(this);
		}

	}

}


