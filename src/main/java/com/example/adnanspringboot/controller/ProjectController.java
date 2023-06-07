package com.example.adnanspringboot.controller;


import com.example.adnanspringboot.dto.CommonDTO;

import com.example.adnanspringboot.dto.ResponseDTO;
import com.example.adnanspringboot.entity.Project;
import com.example.adnanspringboot.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/project")
    public CommonDTO getProject(){

        List<Project> projects= projectService.getAll();
//        return new ProjectDTO(projects, projects.size());
        ResponseDTO res = new ResponseDTO();
        res.setMessage("Successfull");
        res.setResponseCode("200");
        return new CommonDTO(projects,res);
    }


    @PostMapping("/project")
    public Project saveProject(@RequestBody Project project){

        return projectService.create(project);
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<?> getSingleProject(@PathVariable("id") Long id){
        return projectService.getById(id);
    }

    @PutMapping("/project/{id}")
    public List<Project> updateProject(@PathVariable("id") Long id, @RequestBody Project project) {
        return projectService.updateById(id,project);
    }

    @DeleteMapping("/project/{id}")
    public boolean deleteProject(@PathVariable("id") Long id){
        return projectService.deleteById(id);
    }


}




