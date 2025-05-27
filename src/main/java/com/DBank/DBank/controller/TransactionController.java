package com.DBank.DBank.controller;

import com.DBank.DBank.dto.TransactionDTO;
import com.DBank.DBank.service.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public TransactionDTO add(@RequestBody TransactionDTO dto){
        return service.Operation(dto);
    }
}
