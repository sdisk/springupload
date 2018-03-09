package com.hq.dao;

import com.hq.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by huang on 2018/3/9.
 */
public interface UserDao extends JpaRepository<User,Long>
{
}
