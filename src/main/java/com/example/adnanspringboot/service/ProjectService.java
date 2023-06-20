package com.example.adnanspringboot.service;

import com.example.adnanspringboot.entity.Project;
import com.example.adnanspringboot.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project create(Project project){

        return projectRepository.save(project);
    }

    public List<Project> getAll(){
        return projectRepository.getAllProject();
//        return projectRepository.findAll();     // using default jpa method
    }

    public Project getById(Long idx){
        Project project= projectRepository.findById(idx).get();
        return project;

//        System.out.println("adnan"+skill1);
//        if (project.isPresent()){
//
//            return new ResponseEntity<>(project.get(), HttpStatus.OK);
//        }else {
//
//            return new ResponseEntity<>("Not Found!",HttpStatus.NOT_FOUND);
//        }

    }

    public List<Project> updateById(Long idx, Project newProject){
        Optional<Project> project = projectRepository.findById(idx);
        if (project.isPresent()) {
            Project project1 = new Project();
            project1.setId(idx);
            project1.setName(newProject.getName());
            project1.setDescription(newProject.getDescription());
            project1.setTechnology(newProject.getTechnology());
            projectRepository.save(project1);
            return projectRepository.findAll();
        } else{

            return projectRepository.findAll();
        }
    }

    public Boolean deleteById(Long idx){
        Optional<Project> project = projectRepository.findById(idx);
        if (project.isPresent()) {
            projectRepository.deleteById(idx);
        }
        return true;
    }

    public List<Project> sortByName(){
        return projectRepository.getProjectBySort();
    }

}
