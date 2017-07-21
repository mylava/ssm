package cn.mylava.api;

import cn.mylava.datasource.SpringUtil;
import cn.mylava.model.User;
import cn.mylava.service.UserService;
import com.ruwe.collectlog.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lipengfei
 */
@Controller
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public ModelAndView getUser(@RequestParam(value = "id", defaultValue = "1") int id, HttpServletRequest request) throws UnsupportedEncodingException {
        LogUtils.info(LOGGER, "request", "2\n\n", request);
//        User toAdd = new User();
//        toAdd.setId(id);
//        toAdd.setName("王五");
//        userService.tran(1000,toAdd);

        User user = userService.getUserById(id);



        Map<String, User> map = new HashMap<String, User>();
        map.put("user", user);

        LogUtils.error(LOGGER, "--------------------错误错误--------1", "1\n\n", "error");
        return new ModelAndView("/user", map);
    }
}
