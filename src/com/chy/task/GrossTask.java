package com.chy.task;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.chy.service.OrderGrossDalyrecordsService;

/**
 * @毛利定时器
 */
public class GrossTask {

	@Autowired
	OrderGrossDalyrecordsService orderGrossDalyrecordsService;

	// 每天凌晨1点执行 统计前一天毛利
	@Scheduled(cron = "0 0 1 * * ?")
	public void GrossDalyStatistics() {
		// 店长毛利
		orderGrossDalyrecordsService.copyAutoPointGross(new HashMap<String, Object>());
		// 用户毛利
		orderGrossDalyrecordsService.copyCustomerGross(new HashMap<String, Object>());
		// 厂商毛利
		orderGrossDalyrecordsService.copyFactoryGross(new HashMap<String, Object>());
	}

}
