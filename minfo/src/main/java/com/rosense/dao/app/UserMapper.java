package com.rosense.dao.app;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    List<Map<String, Object>> getSomeUser();


    List<Map<String, Object>> getBack();

    List<Map<String, Object>> getUserByRole(@Param("paramRole") String paramRole);

}
