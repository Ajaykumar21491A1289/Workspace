package com.jocata.service.impl;

import com.jocata.dao.shipping.ShipmentRepository;
import com.jocata.dao.shipping.TrackingInfoRepository;
import com.jocata.service.ShippingService;
import com.jocata.shipping.entity.Shipment;
import com.jocata.shipping.entity.TrackingInfo;
import com.jocata.shipping.forms.ShippmentForm;
import com.jocata.shipping.forms.TrackingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private ShipmentRepository shipmentRepo;
    @Autowired
    private TrackingInfoRepository trackingRepo;


    @Transactional
    @Override
    public ShippmentForm createShipment(ShippmentForm request) {

        Shipment shipment = new Shipment();
        shipment.setOrderId(request.getOrderId());
        shipment.setTrackingNumber(request.getTrackingNumber());
        shipment = shipmentRepo.save(shipment);

        TrackingInfo info = new TrackingInfo();
        info.setShipment(shipment);
        info.setTrackingStatus("SHIPPED");
        trackingRepo.save(info);

        return mapToResponse(shipment);
    }

    @Override
    public List<TrackingForm> trackShipment(Long shipmentId) {
        List<TrackingInfo> tracking =trackingRepo.findByShipmentIdOrderByTimestampDesc(shipmentId);
        List<TrackingForm> form = new ArrayList<>();
        for(TrackingInfo entity: tracking){
            TrackingForm response = new TrackingForm();
            response.setTrackingStatus(entity.getTrackingStatus());
            response.setTimestamp(entity.getTimestamp());
            form.add(response);
        }
        return form;
    }

    @Transactional
    @Override
    public void updateTrackingStatus(Long shipmentId, String trackingStatus) {

        Shipment shipment = shipmentRepo.findById(shipmentId)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));
        TrackingInfo info = new TrackingInfo();
        info.setShipment(shipment);
        info.setTrackingStatus(trackingStatus);
        trackingRepo.save(info);
    }

    private ShippmentForm mapToResponse(Shipment shipment) {
        ShippmentForm response = new ShippmentForm();
        response.setId(shipment.getId());
        response.setOrderId(shipment.getOrderId());
        response.setTrackingNumber(shipment.getTrackingNumber());
        return response;
    }
}
