package com.example.adnanspringboot.dto;


import com.example.adnanspringboot.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private List<Project> projectData;
    private int numberOfResponse;
}
