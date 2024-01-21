package com.example.webmarket.exc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDetails {
    private String serviceName;
    private String message;
    private Integer code;
}
