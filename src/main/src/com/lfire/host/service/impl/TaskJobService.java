package com.lfire.host.service.impl;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("taskJob")
public class TaskJobService {

	@Scheduled(cron = "1 * * * * ?")
	public void job1() {
		System.out.println("���������:"+LocalDateTime.now());
	}
}
