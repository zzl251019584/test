package com.forms.intelligentpark.sys.controller;

import com.forms.intelligentpark.common.result.JsonResult;
import com.forms.intelligentpark.sys.entity.TestVO;
import com.forms.intelligentpark.sys.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("getTree")
    public JsonResult getTree(){
        try {
            List<TestVO> result = testService.getTree();
            return new JsonResult("200","success",result);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("500","fail");
        }
    }

}
