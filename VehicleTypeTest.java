import code.DateTime;
import code.VehicleType;
import org.junit.Test;
import static org.junit.Assert.*;

public class VehicleTypeTest {
    @Test
    public void testGetSeatsForCar() {
        VehicleType car = new VehicleType(5);
        int seats = car.getSeats("car");
        assertEquals(5, seats);
    }

    @Test
    public void testGetSeatsForVan() {
        DateTime lastMaintenance = new DateTime(1, 3, 2023);
        VehicleType van = new VehicleType(12, lastMaintenance);
        int seats = van.getSeats("van");
        assertEquals(12, seats);
    }

    @Test
    public void testGetCarSeats() {
        VehicleType car = new VehicleType(4);
        int seats = car.getCarSeats();
        assertEquals(4, seats);
    }

    @Test
    public void testSetCarSeats() {
        VehicleType car = new VehicleType(5);
        car.setCarSeats(7);
        int seats = car.getCarSeats();
        assertEquals(7, seats);
    }

    @Test
    public void testGetLastMaintenance() {
        DateTime lastMaintenance = new DateTime(1, 3, 2023);
        VehicleType van = new VehicleType(12, lastMaintenance);
        DateTime maintenance = van.getLastMaintenance();
        assertEquals(lastMaintenance, maintenance);
    }

    @Test
    public void testSetLastMaintenance() {
        DateTime lastMaintenance = new DateTime(1, 3, 2023);
        DateTime newMaintenance = new DateTime(1, 4, 2023);
        VehicleType van = new VehicleType(12, lastMaintenance);
        van.setLastMaintenance(newMaintenance);
        DateTime maintenance = van.getLastMaintenance();
        assertEquals(newMaintenance, maintenance);
    }

    @Test
    public void testCanBeRentedForMinimumDaysForCar() {
        VehicleType car = new VehicleType(4);
        DateTime date = new DateTime(6, 3, 2023); // Monday
        int minDays = car.canBeRentedForMinimumDays(date, "car");
        assertEquals(2, minDays);

        date = new DateTime(11, 3, 2023); // Saturday
        minDays = car.canBeRentedForMinimumDays(date, "car");
        assertEquals(3, minDays);
    }

    @Test
    public void testCanBeRentedForMinimumDaysForVan() {
        DateTime lastMaintenance = new DateTime(1, 3, 2023);
        VehicleType van = new VehicleType(12, lastMaintenance);
        DateTime date = new DateTime(6, 3, 2023); // Monday
        int minDays = van.canBeRentedForMinimumDays(date, "van");
        assertEquals(1, minDays);
    }

}
