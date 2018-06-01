package com.wang926454.service;

import com.wang926454.model.User;

import java.util.List;

/**
 * @Desc
 * @Author wang926454
 * @Date 2018/5/25 10:02
 */
public interface IUserService{
    /**
     * 返回实体对应的一个范围的记录
     * @param start
     * @param size
     * @return
     */
    List<User> all(int start,int size);
    /**
     * 返回实体在数据库里的总数
     * @return
     */
    long allCount();

    /**
     * 插入实体到数据库，对于null值不做处理
     * @param entity
     */
    void insertTemplate(User user);

    /**
     * 根据主键更新对象，只有不为null的属性参与更新
     * @param entity
     * @return
     */
    int updateTemplateById(User user);

    /**
     * 根据主键获取对象，如果对象不存在，返回null
     * @param key
     * @return
     */
    User single(int id);

    /**
     * 根据主键删除对象，如果对象是复合主键，传入对象本生即可
     * @param key
     * @return
     */
    int deleteById(int id);
}
