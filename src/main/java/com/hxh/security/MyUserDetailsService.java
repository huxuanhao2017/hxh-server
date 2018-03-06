package com.hxh.security;

import com.hxh.entity.Role;
import com.hxh.entity.User;
import com.hxh.repository.RelationRepository;
import com.hxh.repository.RoleRepository;
import com.hxh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author: hxh
 * @date: create in 2018/3/2
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RelationRepository relationRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLoginName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名：" + username + "不存在！");
        }
        String password = user.getPassword();
        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        //根据userId查询对应用户的角色列表
        List<Integer> roleIdList = relationRepository.findByUserId(user.getId());
        List<Role> roles = roleRepository.getRoles(roleIdList);
        roles.forEach(role -> {
            collection.add(new SimpleGrantedAuthority(role.getRole()));
        });
        return new org.springframework.security.core.userdetails.User(username, password, collection);
    }
}
