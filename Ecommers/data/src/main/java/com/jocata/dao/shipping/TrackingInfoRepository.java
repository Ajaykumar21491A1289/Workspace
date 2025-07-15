package com.jocata.dao.shipping;

import com.jocata.shipping.entity.TrackingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingInfoRepository extends JpaRepository<TrackingInfo, Long> {
    List<TrackingInfo> findByShipmentIdOrderByTimestampDesc(Long shipmentId);
}
