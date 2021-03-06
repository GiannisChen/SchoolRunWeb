package com.wywnb.schoolrun.controller;

import com.wywnb.schoolrun.Dao.RunTraceDao;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.service.RunTraceService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/run_trace")
public class RunTraceController {
    @Resource
    private RunTraceService runTraceService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String runTraceTable(Model model) {
        model.addAttribute("run_traces", runTraceService.findAll());
        return "run_trace/runTraceList";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String runTraceEach(@PathVariable("id") ObjectId id,
                               Model model, Map<String, Object> map) {
        List<GPSPoint2V> list = runTraceService.findGPSPoint2VById(id);
        if(list == null || list.isEmpty()) {
            map.put("msg","路径数据为空！");
        }
        model.addAttribute("traces", list);
        return "run_trace/runTraceEachMap";
    }
}
