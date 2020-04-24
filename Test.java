//
///  Mark Anthony Start :  180140208  -- C02220 -- cw1 -- 
//
//
// ---Testing---
//
// I am pleased with the performance of the new revised classes.
// They maintain the same behaviour as the Ugly classes, with some slight improvments to their logic, output, presentation, and with much clearer, restructered code, classes and format.
//
// On testing i found very few bugs or problems. Most errors are caused by not assigning values that are needed or passing values too great for a value type.
// Many fields are required and 'final' and leaving them 'undefined' will result in 'null pointer exception'. Most are needed to generate the invoice and file name and must be assigned values.
//
// There were some greater problems discovered on testing. 
// I found the greatest problem to be :
// 
// *** That there is no check for uniqness of 'id' fields. *** If the id field passed to make the invoice is not changed it will re-write any invoice of the same date and 'id' ! *** 
// This i considered the problem of most concern, i left the id field as an argument below to be passed to businessProcess.generateId( ), but it is a definate potential problem. 
// I diddn't address this problem other than a simple comment, but i like the idea that it could be tied in to a DateBase id field that ensures uniqness or through static variables.
// Or the file System could be checked for a excisting file of the same name first. I diddnt attempt these because they seemed a bit of tangent.
//
// IllegalArgumentEceptions are thrown for trying to set invalid values.
// Setters were used for encapsulation and data-hideing with checks to ensure valid meaningful arguments were passed to them.
// Lower Limit checks for numbers ( zero or greater ) were implemented but not upperlimit values, a possible issue. Entering a number too great for an int or long field will result in an error. I diddnt implement an upperlimit check because java throws an exception on its own, but arbituary upper values could be chosen to guard for meaningful values. 
//
/// There is limited functionality to change, update details or dates throughout a project, they can be, but to do so could be implemented more straightforwardly.
// I included an overloaded method in DateKeeper to set a newStartDate() with a LocalDate object. So it can be set directly. 
// New project, DateKeeper, organization objects can simply be created and passed to BusinessProcess where an invoice can be generated directly calling its method to do so. Many fields were left 'not'-'final' so that they could be set with a setter. So on testing not a problem but requires rewriting the Test class to achieve.
//
/// The logic for how many hours to bill is simple and inaccurate for project durations not comprised of whole days, or to take in to account bank holidays, or other special dates.
// I diddnt refine the logic much because i thought it would be better to write a sepcification of how to implement the accuracy first.
// I did include a method that only counts weekdays, presuming no billable work could be done on a weekend, it is in the HowManyHoursToBillStaticUtilityClass. But the accuracy of this should really be addressed. I thought it was out of scope but defintly worth mentioning.
//
/// There is no check for valid, meaningful phone, fax, or addresses. I considered this out of scope aswell, but thought about how RegEx regular expression maybe could be used.
//
// I wasn't sure about some final instance fields and setters, i tried my best, I can forsee problems from here. I tried to implement a clone() method to return copies of object rather than the object its self, but it over complicated things and obscured the meaning the classes so i left them out. setters for final fields were a cause of concern/interest .
//
// The layout and information of the generated invoice was slightly improved with reguards to the clarity of VAT totals, The functionality of the Ugly classes was maintainted.
// possibly resulting in a problem as it differs from the original layout and output slightly.
//
// Implementing the 'time' class instead of Calendar raised no issues. The format for the date in the filename was written explicitly in the HowManyHoursToBillStaticUtilityClass but the default format of LocalDate is the same anyway ! , so in the invoice.ToString() the defualt is simply used without formatting. This doesnt appear to be a problem.
// I made sure to keep the filename date format the same as in the Ugly classes fileName, maybe more explicit date formatting could be helpful.
//
// I am pleased with my coursework, i diddn't use any interfaces, abstract classes, or inheritance, they diddnt seem necissary, I like my approach. I think it works clearly and well.
// The Builder Design pattern aproach was most helpful and i very much liked using the layout and format below.
//
// thanks ! 



import java.math.BigDecimal;


public class Test {

	Organization vendor;
	Organization client;
	Project project;
	BusinessProcess businessProcess;


	public void go() {

                this.vendor = new Organization.Builder()
                                              .organizationId(0)
                                              .organizationName("Vendor Industries")
                                              .organizationContactDetails(new OrganizationContactDetails
                                                        .Builder()
                                                        .organizationContactName("Tony Stark")
                                                        .organizationAddress("99 Vendor Lane, London, E1")
                                                        .organizationPhoneNumber("555 9876")
                                                        .organizationFaxNumber("555 9875")
                                                        .organizationEmailAddress("t.stark@vendorinc.com")
                                                        .build())
                                              .build();

                this.client = new Organization.Builder()
                                              .organizationId(1)
                                              .organizationName("Client Industries")
                                              .organizationContactDetails(new OrganizationContactDetails
                                                        .Builder()
                                                        .organizationContactName("Bob Thornton")
                                                        .organizationAddress("1 Client Drive, London, W1")
                                                        .organizationPhoneNumber("555 1234")
                                                        .organizationFaxNumber("555 1235")
                                                        .organizationEmailAddress("bob.t@clientinc.com")
                                                        .build())
                                              .build();

		this.project = new Project.Builder()
  					  .projectId(1)
					  .projectName("Project 1")
					  .projectDescription("Vend awesome things to Client Industries")
					  .dateKeeper(new DateKeeper())
					  .projectHourlyRate(new BigDecimal(10))
					  .vatApplicable(true)
					  .build();


		this.businessProcess = new BusinessProcess( vendor, client, project );

		businessProcess.startProject();
		businessProcess.projectComplete();
		businessProcess.generateInvoice(3);  // ** argument is an Id number for the invoice. It must be changed to not re-write a previous invoice of the same id and date ! **
		businessProcess.writeInvoiceToDisk();

		System.out.println("Everything A.O.K");
		System.out.println("Invoice saved to file");
	}


	public static void main ( String args [] ) {
		Test test = new Test();
		test.go();
	}

}	
