package com.oma.controllers.managestock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anandpimple
 */
@RestController
@RequestMapping(path = "/stock")
public class ManageStockController {
    @RequestMapping(path = "/manage")
    public @ResponseBody String manage(){
        return "Hello";
    }
}
