package com.jocata.warranty_system.Dao;

import com.jocata.warranty_system.entity.WarrantyPlans;
import com.jocata.warranty_system.entity.WarrantyTypes;

import java.util.List;

public interface WarrantyPlansDao {
    WarrantyPlans addWarrantyPlans(WarrantyPlans entity);
    WarrantyPlans updateWarrantyPlans(WarrantyPlans entity);
    WarrantyPlans getWarrantyPlans(Integer id);
    List<WarrantyPlans> getALlWarrantyPlans();
    String deleteWarrantyPlans(WarrantyPlans entity);
}

