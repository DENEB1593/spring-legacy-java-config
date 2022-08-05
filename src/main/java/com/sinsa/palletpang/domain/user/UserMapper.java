package com.sinsa.palletpang.domain.user;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    public String selectUserName();

    public User selectUser();

}
