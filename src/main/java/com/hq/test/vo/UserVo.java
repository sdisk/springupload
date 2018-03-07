package com.hq.test.vo;

/**
 * Created by huang on 2018/3/7.
 */
public class UserVo  implements java.io.Serializable
{
    private static final long serialVersionUID = 245692801672283498L;
    private Integer id;
    private String username;
    private String password;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
