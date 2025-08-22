import code.DateTime;
import code.Vehicle;
import code.VehicleType;
import org.junit.Test;
import static org.junit.Assert.*;
public class VehicleTest {
    @Test
    public void testGetVehicleId() {
        DateTime lastMaintenance = new DateTime(1, 3, 2023);
        VehicleType vanType = new VehicleType(12, lastMaintenance);
        Vehicle van = new Vehicle("V_001", 2018, "Toyota", "Sienna", 0, vanType);
        String vehicleId = van.getVehicleId();
        assertEquals("V_001", vehicleId);
    }

    @Test
    public void testRentCarSuccess() {
        VehicleType carType = new VehicleType(5);
        Vehicle car = new Vehicle("C_001", 2020, "Honda", "Civic", 0, carType);
        DateTime rentDate = new DateTime(3, 6, 2023); // Monday
        boolean isRented = car.rent("CU_001", rentDate, 3);
        assertTrue(isRented);
    }

    @Test
    public void testRentCarFailureDueToMinimumDays() {
        VehicleType carType = new VehicleType(5);
        Vehicle car = new Vehicle("C_001", 2020, "Honda", "Civic", 0, carType);
        DateTime rentDate = new DateTime(3,6,2023); // Monday
        boolean isRented = car.rent("CU_001", rentDate, 1);
        assertFalse(isRented);
    }

    @Test
    public void testRentVanSuccess() {
        DateTime lastMaintenance = new DateTime(1,3,2023);
        VehicleType vanType = new VehicleType(12, lastMaintenance);
        Vehicle van = new Vehicle("V_001", 2018, "Toyota", "Sienna", 0, vanType);
        DateTime rentDate = new DateTime(3,6,2023); // Monday
        boolean isRented = van.rent("CU_001", rentDate, 5);
        assertTrue(isRented);
    }

    @Test
    public void testRentVanFailureDueToMaintenance() {
        DateTime lastMaintenance = new DateTime(1,2,2023);
        VehicleType vanType = new VehicleType(12, lastMaintenance);
        Vehicle van = new Vehicle("V_001", 2018, "Toyota", "Sienna", 0, vanType);
        DateTime rentDate = new DateTime(6,3,2023); // Monday
        boolean isRented = van.rent("CU_001", rentDate, 15);
        assertFalse(isRented);
    }

    @Test
    public void testPerformMaintenanceSuccess() {
        VehicleType carType = new VehicleType(5);
        Vehicle car = new Vehicle("C_001", 2020, "Honda", "Civic", 0, carType);
        boolean maintenancePerformed = car.performMaintenance();
        assertTrue(maintenancePerformed);
    }

    @Test
    public void testPerformMaintenanceFailure() {
        VehicleType carType = new VehicleType(5);
        Vehicle car = new Vehicle("C_001", 2020, "Honda", "Civic", 1, carType);
        boolean maintenancePerformed = car.performMaintenance();
        assertFalse(maintenancePerformed);
    }

    @Test
    public void testToString() {
        VehicleType carType = new VehicleType(5);
        Vehicle car = new Vehicle("C_001", 2020, "Honda", "Civic", 0, carType);
        String expected = "C_001:2020:Honda:Civic:5:Available";
        String actual = car.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetDetails() {
        DateTime lastMaintenance = new DateTime(1,3,2023 );
        VehicleType vanType = new VehicleType(15, lastMaintenance);
        Vehicle van = new Vehicle("V_001", 2018, "Toyota", "Sienna", 0, vanType);
        String expected = "Vehicle ID:\tV_001\n Year:\t 2018\n Make:\tToyota\n Model:\tSienna\n Number of Seats:\t15\n Status:\tAvailable";
        String actual = van.getDetails();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetLastElementIndex() {
        DateTime lastMaintenance = new DateTime(1,3,2023);
        VehicleType vanType = new VehicleType(12, lastMaintenance);
        Vehicle van = new Vehicle("V_001", 2018, "Toyota", "Sienna", 0, vanType);
        DateTime rentDate = new DateTime(6,3,2023); // Monday
        van.rent("CU_001", rentDate, 5);
        int lastIndex = van.getLastElementIndex();
        assertEquals(0, lastIndex);
    }
}
