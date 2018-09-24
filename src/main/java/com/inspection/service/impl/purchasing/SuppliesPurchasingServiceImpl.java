package com.inspection.service.impl.purchasing;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspection.service.purchasing.SuppliesPurchasingServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("suppliesPurchasingService")
@Transactional
public class SuppliesPurchasingServiceImpl extends CommonServiceImpl implements SuppliesPurchasingServiceI {
	
}