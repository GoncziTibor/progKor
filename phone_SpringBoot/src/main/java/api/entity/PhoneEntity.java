package api.entity;

import jakarta.persistence.*;

@Entity
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private double price;

    @Column(name = "operating_system", nullable = false)
    private String operatingSystem;

    @Column(name = "release_year", nullable = false)
    private int releaseYear;

    public PhoneEntity() {
    }

    public PhoneEntity(Long id, String brand, String model, double price, String operatingSystem, int releaseYear) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.operatingSystem = operatingSystem;
        this.releaseYear = releaseYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
