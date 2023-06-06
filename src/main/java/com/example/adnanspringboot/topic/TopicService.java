package com.example.adnanspringboot.topic;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    private final List<Topic> topics = List.of(
            new Topic("1", "JavaScript", "Its the best"),
            new Topic("2", "python", "Its the best"),
            new Topic("3", "Java", "Its the worst"),
            new Topic("4", "Java", "Its the worst")
    );

    public List<Topic> getAllTopics(){
//        topics.add(new Topic("3", "Java", "Its the worst"));
        return topics;
    }
}
