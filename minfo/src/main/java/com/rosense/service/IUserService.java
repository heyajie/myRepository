package com.rosense.service;

import com.rosense.bean.User;

import java.util.List;
import java.util.Map;

public interface IUserService {

    List<Map<String, Object>> getSomeUser();

    List<Map<String, Object>> getBack();


    List<Map<String, Object>> getOneByUser(User user);


    List<Map<String, Object>> getOneByMap(Map<String,String> map);

    List<Map<String, Object>> insertOne(User user);

    List<Map<String, Object>> getUserByRole(String paramRole);
}
