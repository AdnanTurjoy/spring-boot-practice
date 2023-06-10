package com.example.adnanspringboot.service;


import com.example.adnanspringboot.entity.Project;
import com.example.adnanspringboot.entity.Skill;
import com.example.adnanspringboot.repository.ProjectRepository;
import com.example.adnanspringboot.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;


   private final ProjectRepository projectRepository;

   public Skill create(Skill skill, Long projectId){
        Project project = projectRepository.findById(projectId).orElse(null);
        System.out.println("adnan"+ project);
        skill.setProject(project);
        return skillRepository.save(skill);
    }

    public List<Skill> getAll(){
       return skillRepository.findAll();
    }
}
