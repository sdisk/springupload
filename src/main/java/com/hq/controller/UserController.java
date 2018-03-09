package com.hq.controller;

import com.hq.base.controller.BaseController;
import com.hq.domain.User;
import com.hq.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huang on 2018/3/9.
 */
@RestController
public class UserController extends BaseController
{
    @Autowired
    private IUserService userService;

    @RequestMapping("/userList")
    public ModelAndView getUsers(@RequestParam(name="start",defaultValue = "1") int start,
                                 @RequestParam(name="limit",defaultValue = "5") int limit){

        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.Direction.ASC,"user_id");
        Pageable pageable = new PageRequest(start,limit, sort);
        Page<User> page = userService.findAll(pageable);
        ModelAndView view = new ModelAndView("users");
        view.addObject("page",page);
        return view;
    }

}
