package com.Bargunyo.PersonDB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error")
public class ErrorController {

    /*
    * With this class associated to the template error,
    * we can avoid the Whitelabel error page for any
    * error that we haven't anticipated
    * */

    @GetMapping
    public String getErrorPage(){

        return "error";
    }
}
