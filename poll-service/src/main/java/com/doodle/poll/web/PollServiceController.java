package com.doodle.poll.web;

import com.doodle.poll.domain.Poll;
import com.doodle.poll.dto.PollDTO;
import com.doodle.poll.service.PollService;
import com.doodle.poll.transformer.PollDataTransformer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/1")
@Api(tags = "Doodle Polls")
public class PollServiceController {

    private final PollService pollService;
    private final PollDataTransformer pollDataTransformer;

    @Autowired
    public PollServiceController(PollService pollService, PollDataTransformer pollDataTransformer) {

        this.pollService = pollService;
        this.pollDataTransformer = pollDataTransformer;
    }

    @ApiOperation(value = "This endpoint is used for finding the polls by user, title, and/or date")
    @GetMapping(value = "/polls")
    public Page<PollDTO> findPolls(@RequestParam(name = "user", required = false) String user,
                                   @RequestParam(name = "title", required = false) String title,
                                   @RequestParam(value = "fromDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
                                   Pageable pageable) {

        log.info("POST /api/1/polls?user={}&title={}&fromDate={}&page={}&size={}",
                user, title, fromDate, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());

        Page<Poll> pollsByTitleAndDate = pollService.findPollsByTitleAndDate(user, title, fromDate, pageable);

        return pollDataTransformer.pollDTOsFromPolls(pollsByTitleAndDate);
    }

}
