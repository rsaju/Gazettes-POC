package com.gazette.poc.Db_Service.Controller;

import com.gazette.poc.Db_Service.Model.Register;
import com.gazette.poc.Db_Service.Service.RegisterService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping("/add_user")
    public void registerUser(HttpServletRequest request) throws IOException {

        BufferedReader bufferedReader = request.getReader();
        Gson gson = new Gson();
        Register register = gson.fromJson(bufferedReader, Register.class);
        registerService.save(register);

    }
}
