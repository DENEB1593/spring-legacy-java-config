package com.sinsa.palletpang.domain;

import org.apache.ibatis.annotations.Select;

public interface TestMapper {
    @Select("select '1'")
    public String select();
}
