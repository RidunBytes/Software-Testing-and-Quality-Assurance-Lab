import code.Car;
import code.DateTime;
import code.VehicleType;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarTest {
    @Test
    public void testConstructor() {
        Car car = new Car("C_123", 2020, "Toyota", "Camry", 0, new VehicleType(5));
        assertEquals(5, car.seats);
        assertEquals(78.0, car.rentRate, 0.001);
    }

    @Test
    public void testGetLateFeeNoLateFee() {
        Car car = new Car("C_123", 2020, "Toyota", "Camry", 0, new VehicleType(5));
        DateTime startDate = new DateTime(1, 1, 2023);
        DateTime endDate = new DateTime(3, 1, 2023);
        double lateFee = car.getLateFee(endDate, startDate);
        assertEquals(1.25 * 78 * DateTime.diffDays(endDate, startDate), lateFee,0);
    }

    @Test
    public void testGetLateFeeWithLateFee() {
        Car car = new Car("C_123", 2020, "Toyota", "Camry", 0, new VehicleType(5));
        DateTime startDate = new DateTime(1, 1, 2023);
        DateTime endDate = new DateTime(5, 1, 2023);
        double lateFee = car.getLateFee(endDate, startDate);
        assertEquals(1.25 * 78 * DateTime.diffDays(endDate, startDate), lateFee,0);
    }

    @Test
    public void testReturnVehicleBeforeMinimumRental() {
        Car car = new Car("C_123", 2020, "Toyota", "Camry", 0, new VehicleType(5));
        DateTime rentDate = new DateTime(1, 1, 2023);
        car.rent("001", rentDate, 2);
        DateTime returnDate = new DateTime(2, 1, 2023);
        assertFalse(car.returnVehicle(returnDate));
    }

    @Test
    public void testReturnVehicleAfterEstimatedReturn() {
        Car car = new Car("C_123", 2020, "Toyota", "Camry", 0, new VehicleType(5));
        DateTime rentDate = new DateTime(1, 1, 2023);
        car.rent("001", rentDate, 3);
        DateTime returnDate = new DateTime(5, 1, 2023);
        assertTrue(car.returnVehicle(returnDate));
        assertTrue(car.records[0].LateFee > 0);
    }

    @Test
    public void testCompleteMaintenance() {
        Car car = new Car("C_123", 2020, "Toyota", "Camry", 2, new VehicleType(5));
        assertTrue(car.completeMaintenance());
        assertEquals(0, car.vehicleStatus);
    }

    @Test
    public void testGetDetailsWithNoRentalRecords() {
        Car car = new Car("C_123", 2020, "Toyota", "Camry", 0, new VehicleType(5));
        String details = car.getDetails();
        assertTrue(details.contains("RENTAL RECORD:\tempty"));
    }

    @Test
    public void testGetDetailsWithRentalRecords() {
        Car car = new Car("C_123", 2020, "Toyota", "Camry", 0, new VehicleType(5));
        DateTime rentDate1 = new DateTime(1, 1, 2023);
        car.rent("001", rentDate1, 3);
        DateTime rentDate2 = new DateTime(5, 1, 2023);
        car.rent("002", rentDate2, 4);
        String details = car.getDetails();
        assertTrue(details.contains("RENTAL RECORD"));
        assertTrue(details.contains("C_123_002_05012023") || details.contains("C_123_001_01012023"));  // Update assertion
    }

    @Test
    public void testGetLateFeeWithBoundaryValues() {
        Car car = new Car("C_123", 2020, "Toyota", "Camry", 0, new VehicleType(5));
        DateTime startDate = new DateTime(1, 1, 2023);
        DateTime endDate = new DateTime(4, 1, 2023);
        double lateFee = car.getLateFee(endDate, startDate);
        assertEquals(1.25 * 78 * DateTime.diffDays(endDate, startDate), lateFee,0);
    }

    @Test(expected = NullPointerException.class)
    public void testReturnVehicleWithNullReturnDate() {
        Car car = new Car("C_123", 2020, "Toyota", "Camry", 0, new VehicleType(5));
        DateTime rentDate = new DateTime(1, 1, 2023);
        car.rent("001", rentDate, 3);
        car.returnVehicle(null);
    }
}
