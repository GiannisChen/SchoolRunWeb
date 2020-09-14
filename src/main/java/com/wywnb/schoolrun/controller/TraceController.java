package com.wywnb.schoolrun.controller;

import com.wywnb.schoolrun.Entity.TraceEntity;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.PO.GPSPointAbbr2V;
import com.wywnb.schoolrun.PO.TraceEntityStringID;
import com.wywnb.schoolrun.service.BaseTraceService;
import com.wywnb.schoolrun.service.TraceService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/trace")
public class TraceController {
    @Resource
    private TraceService traceService;
    @Resource
    private BaseTraceService baseTraceService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String traceTable(Model model) {
        model.addAttribute("trace_data", traceService.findAll());
        return "trace/traceList";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String traceEach(@PathVariable("id") ObjectId id,
                               Model model, Map<String, Object> map) {
        List<GPSPoint2V> list = traceService.findGPSPoint2VById(id);
        if(list == null || list.isEmpty()) {
            map.put("msg","路径数据为空！");
            list = new ArrayList<>();
        }
        model.addAttribute("traces", list);
        return "trace/traceEachMap";
    }

    @RequestMapping(value = "getPage", method = RequestMethod.POST)
    @ResponseBody
    public List<TraceEntityStringID> tracePage() {
        return traceService.findAll2StringID();
    }

    @RequestMapping(value = "compare/{id}/{base_id}", method = RequestMethod.GET)
    public String compare(@PathVariable("id") ObjectId id,
                          @PathVariable("base_id") ObjectId base_id,
                          Model model, Map<String, Object> map) {
        if (id != null && base_id != null) {
            System.out.println(id.toHexString());
            System.out.println(base_id.toHexString());
            List<GPSPoint2V> traceList = traceService.findGPSPoint2VById(id);
            List<GPSPoint2V> baseList = baseTraceService.findGPSPoint2VById(base_id);
            if(traceList == null || traceList.isEmpty() || baseList == null || baseList.isEmpty()) {
                map.put("msg", "数据不全！");
            }
            else {
                map.put("success", "成功！");
                model.addAttribute("trace_list", traceList);
                model.addAttribute("base_list", baseList);
            }
        }
        else {
            map.put("msg", "id为空！");
        }
        return "trace/traceCompare";
    }
}
