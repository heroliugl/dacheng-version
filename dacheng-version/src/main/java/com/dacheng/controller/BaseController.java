package com.dacheng.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;


@Controller
public class BaseController{

    protected int currentPage = 0;
    protected int pageSize = 20;
    
    public static Logger log = Logger.getLogger(BaseController.class);


    /**
     * 获取UserDto
     *
     * @param request
     * @return
     */
   /* protected UserDto getUserSession() {
        UserDto userDto = (UserDto) request.getSession().getAttribute(BusinessConstant.SESSION_USER);
        return (null != userDto) ? userDto : null;
    }
*/
   
}
