package com.portal.examportal.service;

import com.portal.examportal.model.User;
import com.portal.examportal.model.UserRole;
import com.portal.examportal.repo.RoleRepository;
import com.portal.examportal.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
       User usr= this.userRepository.findByUsername(user.getUsername());
   if(usr!=null){
       System.out.println("User Already exist!");
   }else{
       for(UserRole ur:userRoles){
           roleRepository.save(ur.getRoles());
       }
   }
   user.getUserRoles().addAll(userRoles);
   usr=this.userRepository.save(user);
        return usr;
    }
}
