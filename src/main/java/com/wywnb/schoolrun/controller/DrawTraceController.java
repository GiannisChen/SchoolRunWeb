package com.wywnb.schoolrun.controller;

import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.PO.GPSPointAbbr2V;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addTrace(@RequestBody List<GPSPointAbbr2V> traces) {
        Map<String, Object> map = new HashMap<>();
        if(traces == null || traces.isEmpty()) {
            map.put("error", "提交GPS数据为空！");
        }
        else {
            System.out.println(traces.toString());
            map.put("success", "提交成功");
        }
        return map;
    }
}
