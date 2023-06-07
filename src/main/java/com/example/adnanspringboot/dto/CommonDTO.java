package com.example.adnanspringboot.dto;

import com.example.adnanspringboot.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonDTO {
    private List<Project> data;
    private ResponseDTO response;
}
