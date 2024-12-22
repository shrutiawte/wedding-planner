package client;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String serviceType;  // Type of service (e.g., caterer, photographer)
    
    @Enumerated(EnumType.STRING)
    private VendorStatus availabilityStatus;  // Available or Unavailable

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public VendorStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(VendorStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
