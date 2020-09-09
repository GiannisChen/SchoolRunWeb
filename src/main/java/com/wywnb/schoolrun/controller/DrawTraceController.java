package com.wywnb.schoolrun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("draw_trace")
public class DrawTraceController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showDrawingBoard() {
        return "draw_trace/draw_trace";
    }

    @RequestMapping(value = "measure", method = RequestMethod.GET)
    public String showDrawingMeasuring() {
        return "draw_trace/measure_trace";
    }
}
