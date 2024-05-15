package api.dto;

public class Phone {
    private String brand;
    private String model;
    private double price;
    private String operatingSystem;
    private int releaseYear;

    public Phone(String brand, String model, double price, String operatingSystem, int releaseYear) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.operatingSystem = operatingSystem;
        this.releaseYear = releaseYear;
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

