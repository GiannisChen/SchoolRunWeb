package com.wywnb.schoolrun.controller;

import com.wywnb.schoolrun.Dao.RunTraceDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("/run_trace")
public class RunTraceController {
    @Resource
    RunTraceDao runTraceDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String runTraceTable(Model model) {
        model.addAttribute("run_traces", runTraceDao.findAll());
        return "runTraceList";
    }
}
