package com.portal.examportal.service;

import com.portal.examportal.model.User;
import com.portal.examportal.model.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles);
}
