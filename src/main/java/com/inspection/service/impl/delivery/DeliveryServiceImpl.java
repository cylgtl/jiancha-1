package com.inspection.service.impl.delivery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.service.delivery.DeliveryServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("deliveryService")
@Transactional
public class DeliveryServiceImpl extends CommonServiceImpl implements DeliveryServiceI {
	
}