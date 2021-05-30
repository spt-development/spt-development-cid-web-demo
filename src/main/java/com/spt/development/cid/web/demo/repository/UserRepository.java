package com.spt.development.cid.web.demo.repository;

import com.spt.development.cid.web.demo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User read(long userId) {
        if (userId == 1) {
            return new User(userId, "Arthur Dent");
        }

        if (userId == 99) {
            throw new RuntimeException();
        }
        return null;
    }
}
