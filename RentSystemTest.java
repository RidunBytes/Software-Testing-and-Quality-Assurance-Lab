import code.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;
public class RentSystemTest {
    @Test
    public void testAddCar() {
        RentSystem system = new RentSystem();
        String input = "car\n2022\nToyota\nCamry\nC_001\n4";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);
        system.add(scanner);
        assertNotNull(system.cars[0]);
        assertEquals("C_001", system.cars[0].getVehicleId());
    }

    @Test
    public void testAddVan() {
        RentSystem system = new RentSystem();
        String input = "van\n2021\nFord\nTransit\nV_001\n01/01/2023";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);
        system.add(scanner);
        assertNotNull(system.vans[0]);
        assertEquals("V_001", system.vans[0].getVehicleId());
    }

    @Test
    public void testRentCar() {
        RentSystem system = new RentSystem();
        system.cars[0] = new Car("C_001", 2022, "Toyota", "Camry", 0, new VehicleType(4));
        String input = "C_001\n123\n01/01/2023\n5";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);
        system.rent(scanner);
        assertEquals(1, system.cars[0].vehicleStatus);
        assertNotNull(system.cars[0].records[0]);
    }

    @Test
    public void testRentVan() {
        RentSystem system = new RentSystem();
        system.vans[0] = new Van("V_001", 2021, "Ford", "Transit", 0, new VehicleType(15, new DateTime(1, 1, 2023)));
        String input = "V_001\n456\n01/01/2023\n3";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);
        system.rent(scanner);
        assertEquals(1, system.vans[0].vehicleStatus);
        assertNotNull(system.vans[0].records[0]);
    }

    @Test
    public void testReturnCar() {
        RentSystem system = new RentSystem();
        system.cars[0] = new Car("C_001", 2022, "Toyota", "Camry", 0, new VehicleType(4));
        system.cars[0].rent("123", new DateTime(1, 1, 2023), 5);
        String input = "C_001\n08/01/2023";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);
        system.returnCar(scanner);
        assertEquals(0, system.cars[0].vehicleStatus);
        assertNotNull(system.cars[0].records[0].ActualReturnDate);
    }

    @Test
    public void testVehicleMaintenance() {
        RentSystem system = new RentSystem();
        system.cars[0] = new Car("C_001", 2022, "Toyota", "Camry", 0, new VehicleType(4));
        String input = "C_001";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);
        system.vehicleMaintenance(scanner);
        assertEquals(2, system.cars[0].vehicleStatus);
    }

    @Test
    public void testCompleteMaintenance() {
        RentSystem system = new RentSystem();
        system.cars[0] = new Car("C_001", 2022, "Toyota", "Camry", 2, new VehicleType(4));
        String input = "C_001";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);
        system.completeMaintenance(scanner);
        assertEquals(0, system.cars[0].vehicleStatus);
    }



    @Test
    public void testRunAddVehicle() {
        RentSystem system = new RentSystem();
        String input = "1\ncar\n2022\nToyota\nCamry\nC_001\n4\n7";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);
        system.run();
        assertNotNull(system.cars[0]);
        assertEquals("C_001", system.cars[0].getVehicleId());
    }

}
