package bookmystay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddOnServiceManager {
    // Maps Reservation ID to a list of Add-On Services
    private Map<String, List<Service>> reservationServices;

    public AddOnServiceManager() {
        this.reservationServices = new HashMap<>();
    }

    public void addService(String reservationId, Service service) {
        reservationServices.computeIfAbsent(reservationId, k -> new ArrayList<>()).add(service);
        System.out.println(" -> Added " + service + " to Reservation " + reservationId);
    }

    public List<Service> getServices(String reservationId) {
        return reservationServices.getOrDefault(reservationId, new ArrayList<>());
    }

    public double calculateAddOnTotal(String reservationId) {
        List<Service> services = getServices(reservationId);
        double total = 0.0;
        for (Service service : services) {
            total += service.getPrice();
        }
        return total;
    }
}
