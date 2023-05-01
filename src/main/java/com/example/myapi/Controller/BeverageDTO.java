package com.example.myapi.Controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BeverageDTO {
    private String name;
    private String description;
    private List<OptionDTO> options;

    public BeverageDTO(String name, String description, List<OptionDTO> options) {
        this.name = name;
        this.description = description;
        this.options = options;
    }
}