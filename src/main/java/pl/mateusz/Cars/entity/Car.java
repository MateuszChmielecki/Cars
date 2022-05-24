package pl.mateusz.Cars.entity;

import pl.mateusz.Cars.enums.SegmentType;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Brand brand;
    @NotEmpty
    private String model;
    @NotEmpty
    private String modelCode;
    @Min(1886)
    private Integer productionYearFrom;
    @Min(1886)
    private Integer productionYearTo;
    @Enumerated(EnumType.STRING)
    private SegmentType carSegment;

    private String carPicture;

    public Car(Long id, Brand brand, String model, String modelCode, Integer productionYearFrom, Integer productionYearTo, SegmentType carSegment, String carPicture) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.modelCode = modelCode;
        this.productionYearFrom = productionYearFrom;
        this.productionYearTo = productionYearTo;
        this.carSegment = carSegment;
        this.carPicture = carPicture;
    }

    public Car() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public Integer getProductionYearFrom() {
        return productionYearFrom;
    }

    public void setProductionYearFrom(Integer productionYearFrom) {
        this.productionYearFrom = productionYearFrom;
    }

    public Integer getProductionYearTo() {
        return productionYearTo;
    }

    public void setProductionYearTo(Integer productionYearTo) {
        this.productionYearTo = productionYearTo;
    }

    public SegmentType getCarSegment() {
        return carSegment;
    }

    public void setCarSegment(SegmentType carSegment) {
        this.carSegment = carSegment;
    }

    public String getCarPicture() {
        return carPicture;
    }

    public void setCarPicture(String carPicture) {
        this.carPicture = carPicture;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand=" + brand +
                ", model='" + model + '\'' +
                ", modelCode='" + modelCode + '\'' +
                ", productionYearFrom=" + productionYearFrom +
                ", productionYearTo=" + productionYearTo +
                ", carSegment=" + carSegment +
                ", carPicture='" + carPicture + '\'' +
                '}';
    }
}
