package com.doodle.poll.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/1")
public class PollServiceController {

    @GetMapping(value = "/polls")
    public List<Object> findPolls() {
        return Collections.emptyList();
    }
}
