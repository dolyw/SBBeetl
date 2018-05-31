package com.wang926454.dao;

import com.wang926454.model.User;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

@SqlResource("UserDao")
public interface UserDao extends BaseMapper<User> {
    List<User> selectAll();
}