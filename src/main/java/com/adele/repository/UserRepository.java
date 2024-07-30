package com.adele.repository;

import com.adele.domain.UserVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepository {
    private static List<UserVO> users = new ArrayList<>();

    public static void save(UserVO user) {
        users.add(user);
    }

    public static List<UserVO> findAll() {
        return Collections.unmodifiableList(users);
    }
}
