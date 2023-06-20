package com.example.adnanspringboot.repository;

import com.example.adnanspringboot.entity.Project;
import org.springdoc.core.converters.models.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query("select u from project u")
    List<Project> getAllProject();

    @Query(value = "SELECT u FROM project u order by name")
    List<Project> getProjectBySort();
}
