package com.aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MonitorController {

    @RequestMapping("/monitor/toShowOnline")
    public String toShowOnline(){
        return "monitor/showOnline";
    }

    @RequestMapping("/monitor/toShowData")
    public String toShowData(){
        return "monitor/showData";
    }

    @RequestMapping("/monitor/toShowServer")
    public String toShowServer(){
        return "monitor/showServer";
    }
}