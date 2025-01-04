package com.example.storeproject.services.user;

import com.example.storeproject.models.entity.User;
import com.example.storeproject.services.CrudService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService extends CrudService<User,Long> {
  Optional<User>findByEmail(String email);

}
