package com.hq.service;

import com.hq.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by huang on 2018/3/9.
 */
public interface IUserService
{

    Page<User> findAll(Pageable pageable);
}
