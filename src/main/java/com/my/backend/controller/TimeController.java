package com.my.backend.controller;

import com.my.backend.repository.TimeRepository;
import entity.TimeEntity;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TimeController {

    private final TimeRepository timeRepository
    @GetMapping("/time")
    public String getCurrentTime(){
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        return currentTime.format(formatter);
    }
    @GetMapping("/time/add")
    public String addCurrentTime(){
        LocalDateTime currentTime = LocalDateTime.now();
        TimeEntity timeEntity = new TimeEntity(currentTime);
        timeRepository.save(timeEntity);
        return "현재시각이 저장됨";

    }
    @GetMapping("/time/list")
    public List<TimeEntity> getTimeList(){
        return (List<TimeEntity>)timeRepository.findAll();
    }

}
