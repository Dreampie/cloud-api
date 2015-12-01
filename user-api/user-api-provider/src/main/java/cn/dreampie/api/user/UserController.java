package cn.dreampie.api.user;

import cn.dreampie.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dreampie on 15/11/30.
 */
@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public User get(@PathVariable String id) {
    return new User(userService.getById(id));
  }
}
