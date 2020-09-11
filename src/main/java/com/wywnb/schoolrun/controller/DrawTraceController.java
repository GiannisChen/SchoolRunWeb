package com.wywnb.schoolrun.controller;

import com.wywnb.schoolrun.PO.GPSPointAbbr2V;
import com.wywnb.schoolrun.service.BaseTraceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("draw_trace")
public class DrawTraceController {

    @Resource
    private BaseTraceService baseTraceService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showDrawingBoard() {
        return "draw_trace/drawTrace";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addTrace(@RequestBody List<GPSPointAbbr2V> traces, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        String username = (String)session.getAttribute("loginUser");
        if(traces == null || traces.isEmpty() || username == null || username.isEmpty()) {
            map.put("error", "提交GPS数据为空！");
        }
        else {
            map.putAll(baseTraceService.insert(traces, username));
        }
        return map;
    }
}
