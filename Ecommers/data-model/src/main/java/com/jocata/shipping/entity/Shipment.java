package com.jocata.shipping.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    private String trackingNumber;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
    private List<TrackingInfo> trackingInfos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public List<TrackingInfo> getTrackingInfos() {
        return trackingInfos;
    }

    public void setTrackingInfos(List<TrackingInfo> trackingInfos) {
        this.trackingInfos = trackingInfos;
    }
}
