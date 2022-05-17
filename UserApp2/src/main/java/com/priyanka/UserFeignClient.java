package com.priyanka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(value = "note-api", url=" http://localhost:8083/")
public interface UserFeignClient {
	
	@GetMapping
	String noteuserReSponse();
}
