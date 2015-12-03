package cn.dreampie.api.user.controller;

import cn.dreampie.api.user.User;
import cn.dreampie.service.user.UserConstants;
import cn.dreampie.service.user.UserService;
import cn.dreampie.service.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dreampie on 15/11/30.
 */
@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @RequestMapping(value = UserConstants.USERS_ID_PATH, method = RequestMethod.GET)
  public User get(@PathVariable String id) {
    UserEntity entity = userService.getById(id);
    User user = null;
    if (entity != null) {
      user = new User(entity);
    }
    return user;
  }
}
