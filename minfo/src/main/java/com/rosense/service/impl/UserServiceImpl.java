package com.rosense.service.impl;

import com.rosense.bean.User;
import com.rosense.dao.app.UserMapper;
import com.rosense.service.IUserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    UserMapper userMapper;

    @Autowired
    public SqlSessionFactory sqlSessionFactory;

    @Override
    public List<Map<String, Object>> getSomeUser() {
        System.out.println("getSomeUser...  service...");

        String sql = sqlSessionFactory.getConfiguration()
                .getMappedStatement("com.rosense.dao.app.UserMapper.getSomeUser")
                .getBoundSql("")
                .getSql();
        System.out.println("sql= " + sql);
        return userMapper.getSomeUser();
    }

    @Override
    public List<Map<String, Object>> getBack() {
        //userMapper.getBack();
        return null;
    }

    @Override
    public List<Map<String, Object>> getOneByUser(User user) {
        return null;
    }

    @Override
    public List<Map<String, Object>> getOneByMap(Map<String, String> map) {
        return null;
    }


    @Override
    public List<Map<String, Object>> insertOne(User user) {
        return null;
    }
}
