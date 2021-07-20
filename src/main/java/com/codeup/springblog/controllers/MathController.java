package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping(path="/add/{x}/and/{y}")
    @ResponseBody
    public String addNumbers(@PathVariable int x, @PathVariable int y){
        return String.valueOf(x + y);
    }
    @GetMapping("/subtract/{x}/from/{y}")
    @ResponseBody
    public String subtractNumbers(@PathVariable int x, @PathVariable int y){
        return String.valueOf(y - x);
    }
    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public String multiplyNumbers(@PathVariable int x, @PathVariable int y){
        return String.valueOf(x * y);
    }
    @GetMapping("/divide/{x}/from/{y}")
    @ResponseBody
    public String divideNumbers(@PathVariable int x, @PathVariable int y){
        return String.valueOf(y / x);
    }
}
