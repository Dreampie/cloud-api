package cn.dreampie.api.user;

import cn.dreampie.service.user.entity.UserEntity;
import lombok.Data;

@Data
public class User {
  private String id;
  private String username;

  public User(UserEntity entity) {
    this.id = entity.getId();
    this.username = entity.getUsername();
  }
}
