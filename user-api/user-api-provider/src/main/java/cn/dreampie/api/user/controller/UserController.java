package cn.dreampie.api.user.controller;

import cn.dreampie.api.user.User;
import cn.dreampie.service.user.UserConstants;
import cn.dreampie.service.user.UserService;
import cn.dreampie.service.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Dreampie on 15/11/30.
 */
@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @RequestMapping(value = UserConstants.USERS_ID_PATH, method = RequestMethod.GET)
  public User findById(@PathVariable String id) {
    UserEntity entity = userService.findById(id);
    User result = null;
    if (entity != null) {
      result = new User(entity);
    }
    return result;
  }

  @RequestMapping(value = UserConstants.USERS_PATH, method = RequestMethod.POST)
  public User save(@RequestBody User user) {
    UserEntity entity = userService.save(user.reverseEntity());
    User result = null;
    if (entity != null) {
      result = new User(entity);
    }
    return result;
  }
}
