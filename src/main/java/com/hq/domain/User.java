package com.hq.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by huang on 2018/3/9.
 */
@Entity
public class User implements Serializable
{

    private static final long serialVersionUID = -6306790991170396528L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,unique = true,name = "user_id")
    private Long id;

    @Column(nullable = false,unique = true,name = "user_name")
    private String username;

    @Column(nullable = false,unique = true,name = "password")
    private String password;

    @Column(nullable = true,unique = true,name = "email")
    private String email;

    @Column(nullable = true,unique = false,name = "nick_name")
    private String nickName;

    @Column(nullable = false,name = "reg_time")
    private String regTime;

    @Column(nullable = false,name="age")
    private Integer age;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getRegTime()
    {
        return regTime;
    }

    public void setRegTime(String regTime)
    {
        this.regTime = regTime;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }
    //**Entity中不映射成列的字段得加@Transient 注解，不加注解也会映射成列**

}
