//
//  Mark Anthony Start :  180140208  -- C02220 -- cw1 -- 
//


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;


// The format of the date is kept the same as the Ugly classes, it is actualy the same as the default of the LocalDate but made explicit for clarity.
// When it is used in the invoice it is not made explicit how it is formatted, the default is just simply used.


public class writeInvoiceToDisk {

        public static void writeToFile( BusinessProcess businessProcess ) {

		String fileName = constructFileName( businessProcess );

                PrintWriter writer = null;

                try {
                        writer = new PrintWriter( fileName, "UTF-8");
                } catch ( Exception e ) {
                        System.err.println("Something went wrong creating PrintWriter: " + e.getMessage() );
                }

		writer.print( businessProcess.getInvoice() ); //this will cause toString() to be invoked on this object and that is what will be written to disk
                writer.close();
       
	}

        private static String formatDateForWritingToDisk( LocalDate invoiceDate ) {

		LocalDate invoiceDateToFormat = invoiceDate;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedInvoiceDate = invoiceDateToFormat.format( formatter );

		return formattedInvoiceDate;
        }

        private static String constructFileName( BusinessProcess businessProcess ) {
 
		String clientName = businessProcess.getClient().getOrganizationName().replace(' ','-');
		String vendorName = businessProcess.getVendor().getOrganizationName().replace(' ','-');
		int invoiceId = businessProcess.getInvoice().getId();
		String invoiceDate = formatDateForWritingToDisk( businessProcess.getInvoice().getInvoiceDate() );

		String filename = invoiceDate + "-invoice-" + invoiceId + "-for-" + clientName + "-from-" + vendorName + ".txt";

                return filename;
        }

}
