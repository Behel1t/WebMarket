package com.example.webmarket.Dto;

import com.example.webmarket.model.ClotesType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchDTO {
    private ClotesType type;
}
