package com.forms.intelligentpark.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.forms.intelligentpark.sys.entity.Test;
import com.forms.intelligentpark.sys.entity.TestVO;

import java.util.List;

public interface TestService extends IService<Test> {
    List<TestVO> getTree();
}
