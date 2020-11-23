package com.spring.advance.task.springtask.web;

import com.spring.advance.task.springtask.domain.User;
import com.spring.advance.task.springtask.service.Helper;
import com.spring.advance.task.springtask.service.UserService;
import com.spring.advance.task.springtask.util.GeneratePdfReport;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PhoneCompanyController {

    private UserService userService;
    private Helper helper;

    public PhoneCompanyController(UserService userService, Helper helper) {
        this.userService = userService;
        this.helper = helper;
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = {"/addUsers"}, method = RequestMethod.GET)
    public String addPersonForm(Model model) {
        return "addUsers";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        if (!file.isEmpty()) {
            try {
                helper.importFileData(file.getInputStream());

                model.addAttribute("message", "File was saved!");
                return "addUsers";
            } catch (Exception e) {
                return "File can not be upload " + e.getMessage();
            }
        } else {
            model.addAttribute("message", "File is empty.");
            return "addUsers";
        }
    }

    @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {

        List<User> users = (List<User>) userService.list();

        ByteArrayInputStream bis = GeneratePdfReport.userReport(users);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=userReport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String list(Model model) {

        model.addAttribute("users", userService.list());

        return "userList";
    }
}
