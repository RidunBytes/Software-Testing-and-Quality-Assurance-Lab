import code.DateTime;
import code.RentalRecord;
import org.junit.Test;
import static org.junit.Assert.*;
public class RentalRecordTest {
    @Test
    public void testConstructor() {
        DateTime rentDate = new DateTime(1, 1, 2023);
        DateTime estimatedReturnDate = new DateTime(5, 1, 2023);
        RentalRecord record = new RentalRecord("R001", rentDate, estimatedReturnDate);
        assertEquals("R001", record.RentId);
        assertEquals(rentDate, record.RentDate);
        assertEquals(estimatedReturnDate, record.EstimatedReturnDate);
    }

    @Test
    public void testSetData() {
        DateTime rentDate = new DateTime(1, 1, 2023);
        DateTime estimatedReturnDate = new DateTime(5, 1, 2023);
        DateTime actualReturnDate = new DateTime(7, 1, 2023);
        double rentalFee = 250.0;
        double lateFee = 50.0;
        RentalRecord record = new RentalRecord("R001", rentDate, estimatedReturnDate);
        record.setData(actualReturnDate, rentalFee, lateFee);
        assertEquals(actualReturnDate, record.ActualReturnDate);
        assertEquals(rentalFee, record.RentalFee, 0.001);
        assertEquals(lateFee, record.LateFee, 0.001);
    }

    @Test
    public void testGetEstimatedReturnDate() {
        DateTime rentDate = new DateTime(1, 1, 2023);
        DateTime estimatedReturnDate = new DateTime(5, 1, 2023);
        RentalRecord record = new RentalRecord("R001", rentDate, estimatedReturnDate);
        assertEquals(estimatedReturnDate, record.getEstimatedReturnDate());
    }

    @Test
    public void testGetRentDate() {
        DateTime rentDate = new DateTime(1, 1, 2023);
        DateTime estimatedReturnDate = new DateTime(5, 1, 2023);
        RentalRecord record = new RentalRecord("R001", rentDate, estimatedReturnDate);
        assertEquals(rentDate, record.getRentDate());
    }

    @Test
    public void testToString() {
        DateTime rentDate = new DateTime(1, 1, 2023);
        DateTime estimatedReturnDate = new DateTime(5, 1, 2023);
        RentalRecord record = new RentalRecord("R001", rentDate, estimatedReturnDate);
        String expected = "R001:01/01/2023:05/01/2023:none:none:none";
        assertEquals(expected, record.toString());
    }

    @Test
    public void testGetDetails() {
        DateTime rentDate = new DateTime(1, 1, 2023);
        DateTime estimatedReturnDate = new DateTime(5, 1, 2023);
        DateTime actualReturnDate = new DateTime(7, 1, 2023);
        double rentalFee = 250.0;
        double lateFee = 50.0;
        RentalRecord record = new RentalRecord("R001", rentDate, estimatedReturnDate);
        record.setData(actualReturnDate, rentalFee, lateFee);
        String expected = "Record ID:             R001\nRent Date:             01/01/2023\n" +
                "Estimated Return Date: 05/01/2023\nActual Return Date:    07/01/2023\n" +
                "Rental Fee:            250.00\nLate Fee:              50.00";
        assertEquals(expected, record.getDetails());
    }

    @Test
    public void testGetDetailsWithoutActualReturn() {
        DateTime rentDate = new DateTime(1, 1, 2023);
        DateTime estimatedReturnDate = new DateTime(5, 1, 2023);
        RentalRecord record = new RentalRecord("R001", rentDate, estimatedReturnDate);
        String expected = "Record ID:             R001\nRent Date:             01/01/2023\n" +
                "Estimated Return Date: 05/01/2023";
        assertEquals(expected, record.getDetails());
    }
}
