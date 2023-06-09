package com.example.adnanspringboot.dto;

import com.example.adnanspringboot.dto.Topic;
import com.example.adnanspringboot.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Respone {

    private List<Topic> data;
    private int numberOfResponse;


}
