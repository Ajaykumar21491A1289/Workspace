package com.jocata.service;

import com.jocata.shipping.forms.ShippmentForm;
import com.jocata.shipping.forms.TrackingForm;

import java.util.List;

public interface ShippingService {
    ShippmentForm createShipment(ShippmentForm request);

    List<TrackingForm> trackShipment(Long shipmentId);

    void updateTrackingStatus(Long shipmentId, String trackingStatus);
}
