package com.hq.service;

import com.hq.dao.UserDao;
import com.hq.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by huang on 2018/3/9.
 * @author huang
 */
@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserDao userDao;

    @Override
    public Page<User> findAll(Pageable pageable)
    {
        return userDao.findAll(pageable);
    }
}
