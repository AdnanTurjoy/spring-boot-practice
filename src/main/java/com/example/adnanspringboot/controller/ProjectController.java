package com.example.adnanspringboot.controller;


import com.example.adnanspringboot.dto.CommonDTO;

import com.example.adnanspringboot.dto.ProjectDTO;
import com.example.adnanspringboot.dto.ResponseDTO;
import com.example.adnanspringboot.entity.Project;
import com.example.adnanspringboot.entity.Skill;
import com.example.adnanspringboot.repository.SkillRepository;
import com.example.adnanspringboot.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final SkillRepository skillRepository;
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
    public ProjectDTO getSingleProject(@PathVariable("id") Long id) {
        Project project1 = projectService.getById(id);
        List<Skill> skills = skillRepository.findAll();
//        System.out.println( skills.stream().filter().);
//        Skill skill1 = skills.stream()
//                .filter(item -> idx.equals(item.getProject().getId()))
//                .findAny().orElseGet(null);
        List<String> items = new ArrayList<>();
        for (int i = 0; i < skills.size(); i++) {
            if (skills.get(i).getProject().getId().equals(id)) {
                items.add(skills.get(i).getSkillName());
            }
        }

        return new ProjectDTO(project1,items);

    }


    @PutMapping("/project/{id}")
    public List<Project> updateProject(@PathVariable("id") Long id, @RequestBody Project project) {
        return projectService.updateById(id,project);
    }

    @DeleteMapping("/project/{id}")
    public boolean deleteProject(@PathVariable("id") Long id){
        return projectService.deleteById(id);
    }

    @GetMapping("/project/sort")
    public List<Project> getAllProjectbySorting(){
        return projectService.sortByName();
    }

}




