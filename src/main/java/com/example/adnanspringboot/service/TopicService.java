package com.example.adnanspringboot.service;

import com.example.adnanspringboot.dto.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        return topics;
    }

    public Topic getSingleTopic(String idx){
        for (Topic item : topics) {
            if(item.getId().equals(idx)) {
                return item;
            }
        }
        return null;
    }

    public List<Topic> createAtopic(Topic topic){
              List<Topic> topics = new ArrayList<>();
              topics.add(topic);
              return topics;
    }

    public Topic updateATopic(Topic topic, String idx){
        Topic topic1 = new Topic();
        for (Topic item : topics){
            if(item.getId().equals(idx)){
                item.setName(topic.getName());
                item.setDescription(topic.getDescription());
                topic1 = topic;
            }
        }
        return topic1;
    }
}
