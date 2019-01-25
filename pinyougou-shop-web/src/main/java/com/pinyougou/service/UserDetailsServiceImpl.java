package com.pinyougou.service;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * 认真类,实现security的接口
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Getter
    @Setter
    private SellerService sellerService;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        //构建角色列表
        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_SELLER"));
        TbSeller seller = sellerService.findOne(username);
        if (seller != null&& seller.getStatus().equals("1")) {
            return new User(username,seller.getPassword(), grantedAuths);
        }else{
            return null;
        }

    }
}
