package com.froyo.service.repository.h2;

import com.froyo.service.model.User;
import java.util.List;

public interface JDBCH2Repository {
    void save(User user);
    List<User> findAll();
}
