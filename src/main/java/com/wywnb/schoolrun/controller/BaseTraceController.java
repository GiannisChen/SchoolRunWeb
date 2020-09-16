package com.wywnb.schoolrun.controller;

import com.wywnb.schoolrun.PO.BaseTraceEntityStringID;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.service.BaseTraceService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("base_trace")
public class BaseTraceController {

    @Resource
    private BaseTraceService baseTraceService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String page() {
        return "draw_trace/baseTraceList";
    }

    @RequestMapping(value = "getPage", method = RequestMethod.POST)
    @ResponseBody
    public List<BaseTraceEntityStringID> getPage() {
        return baseTraceService.findAll2StringID();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String traceEach(@PathVariable("id") ObjectId id,
                            Model model, Map<String, Object> map) {
        List<GPSPoint2V> list = baseTraceService.findGPSPoint2VById(id);
        if(list == null || list.isEmpty()) {
            map.put("msg","路径数据为空！");
            list = new ArrayList<>();
        }
        model.addAttribute("traces", list);
        return "draw_trace/baseTraceEachMap";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> delete(@PathVariable(value = "id") String id) {
        Map<String, Object> map = new HashMap<>();
        if(id != null && !id.isEmpty()) {
            map.putAll(baseTraceService.delete(new ObjectId(id)));
        }
        else {
            map.put("error", "传入数据有误！");
        }
        return map;
    }
}
