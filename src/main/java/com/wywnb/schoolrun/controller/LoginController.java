package com.wywnb.schoolrun.controller;

import com.wywnb.schoolrun.Dao.UserInfoDao;
import com.wywnb.schoolrun.Entity.UserInfoEntity;
import com.wywnb.schoolrun.service.DashboardService;
import com.wywnb.schoolrun.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private UserInfoService userInfoService;
    @Resource
    private DashboardService dashboardService;

    @RequestMapping({"login", "", "login.html"})
    public String login() {
        return "login";
    }

    @RequestMapping(value = "dashboard", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username", required = false) String username,
                        @RequestParam(value = "password", required = false) String password,
                        Map<String, Object> map, HttpSession session, Model model) {

        if (username != null && password != null) {
            UserInfoEntity user = userInfoService.isPasswordMatch(username, password);
            if (user != null) {
                session.setAttribute("loginUser", username);
                session.setAttribute("permission", user.getPermission());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("id", user.getId());
                map.put("success", "登陆成功！");
                model.addAttribute("details", dashboardService.getDetails());
                return "dashboard";
            } else {
                map.put("msg", "用户名密码错误");
                session.removeAttribute("loginUser");
                session.removeAttribute("permission");
                return "login";
            }
        } else {
            map.put("msg", "用户名密码错误！");
            return "login";
        }
    }

    @RequestMapping(value = "dashboard", method = RequestMethod.GET)
    public String backToDashboard(HttpSession session, Model model) {
        if (session.getAttribute("loginUser") == null) {
            return "login";
        } else {
            model.addAttribute("details", dashboardService.getDetails());
            return "dashboard";
        }
    }

    @RequestMapping(value = {"logup", "logup.html"}, method = RequestMethod.GET)
    public String logupPage() {
        return "logup";
    }

    @RequestMapping(value = "logup/submit", method = RequestMethod.POST)
    public String logup(@RequestParam(value = "username", required = false) String username,
                        @RequestParam(value = "password", required = false) String password,
                        @RequestParam(value = "check", required = false) String check,
                        @RequestParam(value = "invitation_code", required = false) String code,
                        Map<String, Object> map, HttpSession session) {

        if (username != null && password != null && check != null && code != null) {
            if(!password.equals(check)) {
                map.put("msg", "两次密码有出入!");
                session.removeAttribute("loginUser");
                return "logup";
            }
            else {
                if(userInfoService.codeExist(code)) {
                    UserInfoEntity newUser = new UserInfoEntity(username, password);
                    userInfoService.insert(newUser);
                    map.put("success", "注册成功！");
                    return "login";
                }
                else {
                    map.put("msg", "邀请码不存在!");
                    session.removeAttribute("loginUser");
                    return "logup";
                }
            }
        }
        else {
            map.put("msg", "用户名密码错误！");
            return "logup";
        }
    }
}
