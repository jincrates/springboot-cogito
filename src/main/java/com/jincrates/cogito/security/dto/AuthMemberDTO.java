package com.jincrates.cogito.security.dto;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Log4j2
@Getter
@ToString
public class AuthMemberDTO extends User {
    //password는 부로 클래스를 사용하므로 별도의 멤버 변수로 선언하지 않음
    private String email;

    private String name;

    private boolean fromSocial;

    public AuthMemberDTO(
            String username,
            String password,
            boolean fromSocial,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.email = username;
        this.fromSocial = fromSocial;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeFromSocial(boolean fromSocial) {
        this.fromSocial = fromSocial;
    }
}
