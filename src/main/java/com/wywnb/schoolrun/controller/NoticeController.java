package com.wywnb.schoolrun.controller;

import com.wywnb.schoolrun.Entity.NoticeEntity;
import com.wywnb.schoolrun.PO.NoticeEntityStringID;
import com.wywnb.schoolrun.service.NoticeService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "notice")
public class NoticeController {
    @Resource
    private NoticeService noticeService;

    //跳转列表
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String notice() {
        return "notice/noticeList";
    }

    //获取全部数据
    @RequestMapping(value = "getPage", method = RequestMethod.POST)
    @ResponseBody
    public List<NoticeEntityStringID> findAll() {
        return noticeService.findAll();
    }

    //跳转插入页面
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String insertPage() {
        return "notice/insert";
    }

    //插入提交
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@RequestParam(value = "title", required = true) String title,
                         @RequestParam(value = "content", required = false) String content,
                         HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        String username = (String) session.getAttribute("loginUser");
        if(title != null && content != null && username != null &&
           !title.isEmpty() && !content.isEmpty() && !username.isEmpty()) {
            map.putAll(noticeService.insert(title, content, username));
        }
        else {
            map.put("error", "传入数据有误！");
        }
        return map;
    }

    //跳转查看页面
    @RequestMapping(value = "check/{id}", method = RequestMethod.GET)
    public String checkPage(@PathVariable(value = "id") String id, Map<String, Object> map) {
        if(id != null && !id.isEmpty()) {
            NoticeEntityStringID notice = noticeService.findByID(id);
            map.put("notice", notice);
        }
        return "notice/check";
    }

    //提交修改
    @RequestMapping(value = "check/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@PathVariable(value = "id") String id,
                                      @RequestParam(value = "title", required = true) String title,
                                      @RequestParam(value = "content", required = false) String content) {
        Map<String, Object> map = new HashMap<>();

        if(title != null && content != null && id != null &&
                !title.isEmpty() && !content.isEmpty() && !id.isEmpty()) {
            map.putAll(noticeService.update(new ObjectId(id), title, content));
        }
        else {
            map.put("error", "传入数据有误！");
        }
        return map;
    }

    //修改状态
    @RequestMapping(value = "up/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> up(@PathVariable(value = "id") String id) {
        Map<String, Object> map = new HashMap<>();
        if(id != null && !id.isEmpty()) {
            map.putAll(noticeService.update(new ObjectId(id), true));
        }
        else {
            map.put("error", "传入数据有误！");
        }
        return map;
    }

    @RequestMapping(value = "down/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> down(@PathVariable(value = "id") String id) {
        Map<String, Object> map = new HashMap<>();
        if(id != null && !id.isEmpty()) {
            map.putAll(noticeService.update(new ObjectId(id), false));
        }
        else {
            map.put("error", "传入数据有误！");
        }
        return map;
    }
}
