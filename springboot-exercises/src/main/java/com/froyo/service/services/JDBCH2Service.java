package com.froyo.service.services;

import com.froyo.service.model.User;
import java.util.List;

public interface JDBCH2Service {
    void save(User user);
    List<User> findAll();
}
