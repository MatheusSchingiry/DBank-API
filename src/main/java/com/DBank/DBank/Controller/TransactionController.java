package com.DBank.DBank.Controller;

import com.DBank.DBank.DTO.TransactionDTO;
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

    @PostMapping
    public TransactionDTO add(@RequestBody TransactionDTO dto){
        return service.Operation(dto);
    }
}
