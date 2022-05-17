
package com.task;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name = "Employee", url = "http://localhost:8080")
public interface SchedulerFeignServiceUtil {

	@GetMapping("/getemployee/all")
	List<Employee> getAll(@RequestHeader(name="X-TenantID") String XTenantId);
	
	@PostMapping(value = "/createemployee" , consumes= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<HttpStatus> save(@RequestBody Employee Employee,@RequestHeader(name="X-TenantID") String XTenantId);

}
