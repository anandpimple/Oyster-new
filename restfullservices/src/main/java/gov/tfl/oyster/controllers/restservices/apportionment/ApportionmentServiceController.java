package gov.tfl.oyster.controllers.restservices.apportionment;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dev on 14/10/16.
 */
@RestController
@RequestMapping("/apportionment")
public class ApportionmentServiceController {
    @RequestMapping("/apply")
    public @ResponseBody  String apply(){
        return "Hello";
    }
}
