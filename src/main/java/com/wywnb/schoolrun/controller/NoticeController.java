package com.wywnb.schoolrun.controller;

import com.wywnb.schoolrun.Entity.NoticeEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "notice")
public class NoticeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String notice() {
        return "notice/noticeList";
    }

    @RequestMapping(value = "getPage", method = RequestMethod.POST)
    @ResponseBody
    public List<NoticeEntity> getAll() {
        return null;
    }

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String insertPage() {
        return "notice/insert";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@RequestParam(value = "title", required = true) String title,
                         @RequestParam(value = "content", required = false) String content,
                         HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        if(title != null && content != null) {
            System.out.println(title);
            System.out.println(content);
            System.out.println(session.getAttribute("loginUser").toString());
            map.put("success", "OK");
        }
        else {
            map.put("error", "传入数据有误！");
        }
        return map;
    }
}
