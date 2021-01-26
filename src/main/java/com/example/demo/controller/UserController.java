package com.example.demo.controller;

import com.example.demo.entity.BaseResp;
import com.example.demo.entity.GetUserResp;
import com.example.demo.entity.PutUserReq;
import com.example.demo.entity.PutUserResp;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping (value = "/user")
    public @ResponseBody
    BaseResp addAccount(@RequestBody (required = true) User input, HttpServletRequest request) throws Exception {
        return userService.addUser(input);
    }
    @PutMapping(value = "/user/{nip}")
    public PutUserResp editUser(@RequestBody PutUserReq input, @PathVariable("nip") String nip) {
        return userService.editUser(input, nip);
    }

    @DeleteMapping (value = "/user/{nip}")
    public String deleteUser(@PathVariable("nip") String nip) {
        userService.deleteByNip(nip);
        return "User with NIP "+nip+" is deleted.";
    }
    @GetMapping(value = "/user/{nip}")
    public GetUserResp getUserByNip(@PathVariable("nip") String nip) {
        return userService.getUserByNip(nip);
    }

}
