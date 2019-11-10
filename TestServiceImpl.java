package com.forms.intelligentpark.sys.service.impl;

import com.alipay.api.domain.SiteInfo;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.forms.intelligentpark.sys.entity.Test;
import com.forms.intelligentpark.sys.entity.TestVO;
import com.forms.intelligentpark.sys.mapper.TestMapper;
import com.forms.intelligentpark.sys.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author PARK
 * @since 2019-04-04
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<TestVO> getTree() {
        List<Test> testList = testMapper.selectList(new EntityWrapper<>());
        Set<TestVO> testVOS = new HashSet<>();
        HashSet<TestVO> testVOSF = new HashSet<>();
        TestVO testVO;
        for (Test test : testList) {
            String[] names = test.getName().split("/");
            String[] paths = test.getPath().split("\\.");
            for (int i = 0; i < names.length; i++) {
                testVO = new TestVO();
                testVO.setName(names[i]);
                testVO.setId(paths[i]);
                if(i>0){
                    testVO.setPid(paths[i-1]);
                }
                testVOS.add(testVO);
            }
        }
        for (TestVO vo : testVOS) {
            if(null == vo.getPid()){
                testVOSF.add(vo);
            }
        }
        createTree(testVOSF,testVOS);
        return new ArrayList<>(testVOSF);
    }

    public void createTree(HashSet<TestVO> testVOSF,Set<TestVO> testVOS){
        ArrayList<TestVO> testVOS1 = new ArrayList<>();
        if (testVOSF.size()>0){
            for (TestVO testVO : testVOSF) {
                for (TestVO vo : testVOS) {
                    if(null != vo.getPid() && vo.getPid().equals(testVO.getId())){
                        testVOS1.add(vo);
                    }
                }
                    createTree(new HashSet<>(testVOS1),testVOS);
                    testVO.setChildrenTest(testVOS1);
            }
        }
    }
}
