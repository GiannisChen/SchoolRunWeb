package com.wywnb.schoolrun.controller;

import com.wywnb.schoolrun.Entity.UserInfoEntity;
import com.wywnb.schoolrun.component.SHA256Coding;
import com.wywnb.schoolrun.service.UserInfoService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("")
public class OptionsController {
    @Resource
    private UserInfoService userInfoService;

    @RequestMapping("invitation_code")
    public String invitationCode(Model model, HttpSession session) {
        ObjectId id = (ObjectId) session.getAttribute("id");
        String code = "error-code-find-help";
        UserInfoEntity user = userInfoService.findOneByID(id);
        if(user != null) {
            if(user.getInvitation_code() == null || user.getInvitation_code().isEmpty()) {
                if(user.getUsername() != null && !user.getUsername().isEmpty() &&
                    user.getId() != null && !user.getId().toHexString().isEmpty()) {
                    code = SHA256Coding.coding(user.getUsername(), user.getId());
                    if(code == null || code.length() < 16) {
                        code = "error-code-find-help";
                    }
                    else {
                        code = code.substring(0, 16).toUpperCase();
                        user.setInvitation_code(code);
                        userInfoService.update(user);
                    }
                }
            }
            else {
                code = user.getInvitation_code();
            }
        }
        code = code.toUpperCase();
        model.addAttribute("code", code);
        return "invitationCode";
    }
}
