//
//  Mark Anthony Start :  180140208  -- C02220 -- cw1 -- 
//

public class Organization {

	private final int organizationId;
	private final String organizationName;
	private OrganizationContactDetails organizationContactDetails;


	private Organization (Builder builder) {

		this.organizationId = builder.organizationId;
		this.organizationName = builder.organizationName;
		this.organizationContactDetails = builder.organizationContactDetails;

	}


	public int getId(){
		return this.organizationId;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public OrganizationContactDetails getContactDetails() {
		return this.organizationContactDetails;
	}

	public void setOrganizationContactDetails( OrganizationContactDetails orgContacts  ) {
		this.organizationContactDetails = orgContacts;
	}


	public static class Builder {

		private int organizationId;
		private String organizationName;
		private OrganizationContactDetails organizationContactDetails;


		public Builder organizationId(final int id) {

			if ( id < 0 ) throw new IllegalArgumentException();
			this.organizationId = id;

			return this;

		}

		public Builder organizationName(final String name) {
			this.organizationName = name;
			return this;
		}
	
		public Builder organizationContactDetails( OrganizationContactDetails deets) {
			this.organizationContactDetails = deets;
			return this;
		}

		public Organization build() {
			return new Organization(this);
		}
	}

}
