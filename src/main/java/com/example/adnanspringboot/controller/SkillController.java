package com.example.adnanspringboot.controller;


import com.example.adnanspringboot.entity.Skill;
import com.example.adnanspringboot.service.SkillService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RequiredArgsConstructor
@RestController
public class SkillController {

    private final SkillService skillService;


    @PostMapping("/skill/{projectId}")
    public Skill createSkill(@RequestBody Skill skill , @PathVariable Long projectId){

        return skillService.create(skill,projectId);
    }

    @GetMapping("/skill")
    public List<Skill> getSkill(){
        return skillService.getAll();
    }
}
