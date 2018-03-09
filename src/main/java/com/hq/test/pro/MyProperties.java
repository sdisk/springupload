package com.hq.test.pro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by huang on 2018/3/9.
 */
@Component
public class MyProperties
{
    @Value("${com.hq.title}")
    private String title;
    @Value("${com.hq.description}")
    private String description;


    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
