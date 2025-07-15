package com.jocata.warranty_system.entity;
import com.jocata.warranty_system.util.CarType;
import com.jocata.warranty_system.util.CarTypeNameConverter;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CarTypes")
public class CarTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_type_id")
    private Integer carTypeId;

    @Convert(converter = CarTypeNameConverter.class)
    @Column(name = "car_type_name", nullable = false, length = 100)
    private CarType carTypeName;

    @OneToMany(mappedBy = "carTypeId")
    private List<CarSaleRecords> carSales;


    public Integer getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(Integer carTypeId) {
        this.carTypeId = carTypeId;
    }

    public CarType getCarTypeName() {
        return carTypeName;
    }

    public void setCarTypeName(CarType carTypeName) {
        this.carTypeName = carTypeName;
    }
}
