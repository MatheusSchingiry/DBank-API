package com.DBank.DBank.Client;

import com.DBank.DBank.DTO.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "AuthorizeAPI", url = "${basket.client.authorize}")
public interface Authorize {

    @GetMapping("/authorize")
    ResponseEntity<ApiResponse> authorizePayment();
}
