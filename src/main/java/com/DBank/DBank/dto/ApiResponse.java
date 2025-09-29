package com.DBank.DBank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String status;
    private Data data;

    public static class Data {
        private boolean authorization;

        public boolean isAuthorization() { return authorization; }
    }
}
