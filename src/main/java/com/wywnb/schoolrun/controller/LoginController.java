package com.wywnb.schoolrun.controller;

import com.wywnb.schoolrun.Dao.UserInfoDao;
import com.wywnb.schoolrun.Entity.UserInfoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class LoginController {

    @Resource
    private UserInfoDao userInfoDao;

    @RequestMapping({"login", "", "login.html"})
    public String login() {
        return "login";
    }

    @RequestMapping(value = "dashboard", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username", required = false) String username,
                        @RequestParam(value = "password", required = false) String password,
                        Map<String, Object> map, HttpSession session) {

        if(username != null && password != null) {
            List<UserInfoEntity> userList = userInfoDao.findByUsername(username);
            boolean isMatch = false;
            for(UserInfoEntity user: userList) {
                if(user.getPassword().equals(password)) {
                    isMatch = true;
                    session.setAttribute("isAdmin", user.getIsAdmin());
                    session.setAttribute("email", user.getEmail());
                    break;
                }
            }
            if(isMatch) {
                map.put("success","登陆成功！");
                session.setAttribute("loginUser", username);
                return "dashboard";
            }
            else {
                map.put("msg", "用户名密码错误");
                session.removeAttribute("loginUser");
                session.removeAttribute("isAdmin");
                return "login";
            }
        }
        else {
            map.put("msg","用户名密码错误！");
            return "login";
        }
    }

    @RequestMapping(value = "dashboard", method = RequestMethod.GET)
    public String backToDashboard(HttpSession session) {
        if(session.getAttribute("loginUser") == null) {
            return "login";
        }
        else {
            return "dashboard";
        }
    }
}
