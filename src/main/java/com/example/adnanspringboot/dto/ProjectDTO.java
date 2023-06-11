package com.example.adnanspringboot.dto;


import com.example.adnanspringboot.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private Project project;
    private List<String> skills;


}
