package com.jocata.los.data.disbursment.dao;

import com.jocata.los.datamodel.disbursment.entity.Disbursment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisbursmentDao extends JpaRepository<Disbursment,Long> {


}
