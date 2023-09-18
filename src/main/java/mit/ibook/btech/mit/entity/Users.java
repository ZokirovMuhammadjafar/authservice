package mit.ibook.btech.mit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mit.ibook.btech.mit.dto.base.Scope;
import mit.ibook.btech.mit.exceptions.RestException;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<UserRole> userRoles;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String middleName;

    @Column(nullable = false,unique = true)
    private String phone;

    private String email;

    private boolean deleted;

    private boolean actived;

    private boolean locked;

    @Column(nullable = false)
    private Long regionId;

    @Embedded
    private Audited audited;

    @Override
    public List<? extends GrantedAuthority> getAuthorities() {
        Set<String> permission = new HashSet<>();
        this.userRoles.forEach(a -> permission.addAll(a.getPermissions()));
        return permission.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.actived;
    }

    public Map<String, String> getClaimsByScope(Scope scope) {
        Map<String,String>claims=new HashMap<>();
        switch (scope){
            case PROFILE -> {
               claims.put("username",this.username);
               claims.put("id",this.id.toString());
               claims.put("firstName",this.firstName);
               claims.put("lastName",this.lastName);
               claims.put("middleName",this.middleName);
               claims.put("phone",this.phone);
               claims.put("email",this.email);
               claims.put("regionId",this.regionId.toString());
               claims.put("userRoles",this.getAuthorities().toString());
            }
            case BEARER -> {
                claims.put("username",this.username);
                claims.put("id",this.id.toString());
                claims.put("userRoles",this.getAuthorities().toString());
            }
            case DEFAULT -> {
                claims.put("username",this.username);
                claims.put("id",this.id.toString());
                claims.put("userRoles",this.getAuthorities().toString());
                claims.put("firstName",this.firstName);
                claims.put("lastName",this.lastName);
                claims.put("middleName",this.middleName);
                claims.put("phone",this.phone);
                claims.put("regionId",this.regionId.toString());
            }
            default -> throw new RestException("Unexpected value: ");
        }
        return claims;
    }
}
