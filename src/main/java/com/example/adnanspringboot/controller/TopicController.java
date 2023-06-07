package com.example.adnanspringboot.controller;

import com.example.adnanspringboot.dto.Respone;
import com.example.adnanspringboot.dto.Topic;
import com.example.adnanspringboot.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class TopicController {

    final private TopicService topicService;

    @GetMapping("/topics")
    public Respone getAllTopic(){

//        List<Topic> topics = List.of(
//                new Topic("1", "JavaScript", "Its the best"),
//                new Topic("1", "JavaScript", "Its the best"),
//                new Topic("1", "Java", "Its the worst")
//        );
        List <Topic> topics= topicService.getAllTopics();

      return new Respone(topics, topics.size());

//        Topic topic = new Topic("1", "JavaScript", "Its the best");
//        return new ResponseEntity<>(respone, HttpStatus.OK);
    }

    @GetMapping("/topic/{id}")
    public Object getOneTopic(@PathVariable("id") String id){
        return topicService.getSingleTopic(id);

    }

    @PostMapping("/topics")
    public List<Topic> createTopic(@RequestBody Topic topic){

       return topicService.createAtopic(topic);

    }
    @PutMapping("/topic/{id}")
    public Topic updateTopic(@PathVariable("id") String id, @RequestBody Topic topic){
        return topicService.updateATopic(topic,id);
    }


}

