package com.jocata.oms.controller;

import com.jocata.oms.client.ProductRestClient;
import com.jocata.oms.client.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private ProductRestClient productRestClient;

    @Autowired
    private UserRestClient userRestClient;

//    @Autowired
//    private OrderEventPublisher orderEventPublisher;

    @PostMapping("/createOrder")
    public String createOrder(@RequestBody Map<String, String> data) {

        logger.info("In OrderController :: createOrder() -> Start");
        String user = userRestClient.getUser();
        String product = productRestClient.getProduct();

//        orderEventPublisher.publishOrderEvent("abc-pqr-xyz");
        logger.info("In OrderController :: createOrder() -> end");
        return user + " " + product + " Success";
    }

}
