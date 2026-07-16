package com.leave.leave_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LeaveManagementSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(LeaveManagementSystemApplication.class, args);
	}

}
