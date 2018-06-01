package com.wang926454.service.impl;

import com.wang926454.dao.UserDao;
import com.wang926454.model.User;
import com.wang926454.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Desc
 * @Author wang926454
 * @Date 2018/5/25 10:06
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> all(int start, int size) {
        return userDao.all(start, size);
    }

    @Override
    public long allCount() {
        return userDao.allCount();
    }

    @Override
    public void insertTemplate(User user) {
        userDao.insertTemplate(user);
    }

    @Override
    @CacheEvict(value = "userService", key = "'user:' + #user.id", allEntries = false)
    public int updateTemplateById(User user) {
        return userDao.updateTemplateById(user);
    }

    @Override
    @Cacheable(value = "userService", key = "'user:' + #id")
    public User single(int id) {
        return userDao.single(id);
    }

    @Override
    @CacheEvict(value = "userService", key = "'user:' + #id", allEntries = false)
    public int deleteById(int id) {
        return userDao.deleteById(id);
    }
}
