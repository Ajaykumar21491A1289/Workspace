package com.jocata.config;

import com.jocata.shipping.forms.ShippmentForm;
import com.jocata.shipping.forms.TrackingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ShippingClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String SHIPPINGSERVICEURL = "http://localhost:8080/SHIPPING-SERVICE/shipments";

    public ShippmentForm createShipment(Long orderId, String trackingNumber) {
        ShippmentForm request = new ShippmentForm();
        request.setOrderId(orderId);
        request.setTrackingNumber(trackingNumber);

        return restTemplate.postForObject(SHIPPINGSERVICEURL, request, ShippmentForm.class);
    }

    public void updateTracking(Long shipmentId, String status) {
        TrackingForm request = new TrackingForm();
        request.setTrackingStatus(status);

        String url = SHIPPINGSERVICEURL + "/" + shipmentId + "/track";
        restTemplate.postForEntity(url, request, Void.class);
    }
}
