package com.chy.task;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import com.chy.service.AutoPointTaskService;


/**
 * @自提点定时器
 */
public class AutoPointTask {
	@Autowired
	AutoPointTaskService autoPointTaskService;

	// 每天凌晨1点执行 停业时间到期执行
	@Scheduled(cron = "0 0 1 * * ?")
	public void AutoPointTaskInfoTask() {
		
		if(autoPointTaskService.autoPointUpdateTask(new HashMap<String,Object>())>0) {
			System.out.println("TASK===========>自提点营业状态批量切换完成");
			if(autoPointTaskService.autoPointUpdateTask(new HashMap<String,Object>())>0) {
				System.out.println("TASK===========>自提点营业状态清除完成");
			}else {
				System.out.println("TASK===========>自提点营业状态失败");
			}
		}else {
			System.out.println("TASK===========>自提点营业状态没有需要批量切换的信息");
		}
	}

}
