package com.jocata.controller;

import com.jocata.service.ShippingService;
import com.jocata.shipping.forms.ShippmentForm;
import com.jocata.shipping.forms.TrackingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;


    @PostMapping
    public ResponseEntity<ShippmentForm> createShipment(@RequestBody ShippmentForm request) {
        return ResponseEntity.ok(shippingService.createShipment(request));
    }

    @GetMapping("/{shipmentId}/track")
    public ResponseEntity<List<TrackingForm>> trackShipment(@PathVariable Long shipmentId) {
        return ResponseEntity.ok(shippingService.trackShipment(shipmentId));
    }

    @PostMapping("/{shipmentId}/updateTrackingStatus")
    public ResponseEntity<TrackingForm> updateTracking(@PathVariable Long shipmentId, @RequestBody TrackingForm request) {
        shippingService.updateTrackingStatus(shipmentId, request.getTrackingStatus());
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }



}
