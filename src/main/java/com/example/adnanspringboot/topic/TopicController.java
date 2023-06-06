package com.example.adnanspringboot.topic;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}

