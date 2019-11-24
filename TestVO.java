package com.forms.intelligentpark.sys.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class TestVO implements Serializable {
    private String id;
    private String pid;
    private String name;
    private List<TestVO> childrenTest;
	ggg

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TestVO> getChildrenTest() {
        return childrenTest;
    }

    public void setChildrenTest(List<TestVO> childrenTest) {
        this.childrenTest = childrenTest;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj instanceof TestVO)
        {
            TestVO testVO=(TestVO)obj;
        //id和path都一样就返回true    若有一个不同返回false
            return this.name.equals(testVO.getName()) && this.id.equals(testVO.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
