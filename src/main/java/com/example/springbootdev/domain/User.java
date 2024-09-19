package com.example.springbootdev.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User  implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email",updatable = false,unique = true)
    private String email;

    @Column(name = "password")
    private String password;


    @Builder
    public User(String email,String password,String auth){
        this.email = email;
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() { //계정이 만료되었는지 확인
        return true; // true -> 만료되지않음
    }

    //계정 만료 여부 반환
    @Override
    public boolean isAccountNonLocked() { //계정이 잠금되었는지 확인
        return true; // true -> 잠금되지 않음
    }

    @Override
    public boolean isCredentialsNonExpired() { //패스워드가 만료되었는지 확인
        return true; //true ->만료되지 않음
    }

    @Override
    public boolean isEnabled() { //계정이 사용가능한지 확인
        return true;//true -> 사용가능
    }
}
