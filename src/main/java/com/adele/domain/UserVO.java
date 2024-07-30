package com.adele.domain;

import java.util.Objects;

public class UserVO {
    private final String userId;
    private final String name;

    public UserVO(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserVO userVO)) return false;
        return Objects.equals(userId, userVO.userId) && Objects.equals(name, userVO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name);
    }
}
