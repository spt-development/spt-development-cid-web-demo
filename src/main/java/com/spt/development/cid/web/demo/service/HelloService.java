package com.spt.development.cid.web.demo.service;

import com.spt.development.cid.web.demo.exception.UnknownUserException;
import com.spt.development.cid.web.demo.model.User;
import com.spt.development.cid.web.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HelloService {
    private final UserRepository userRepository;

    public String hello() {
        return "Hello, world";
    }

    public String hello(long userId) throws UnknownUserException {
        final User user = userRepository.read(userId);

        if (user == null) {
            throw new UnknownUserException(userId);
        }
        return String.format("Hello, %s", user.fullName());
    }
}
