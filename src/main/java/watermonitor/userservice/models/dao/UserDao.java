package watermonitor.userservice.models.dao;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.Set;

@Entity(name = "wm_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDao implements Dao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private long id;
    @NonNull
    @Column(length=50)
    private String name;
    @NonNull
    @Column(length=50)
    private String username;
    @NonNull
    private String password;
    @Transient
    private String passwordConfirm;
    @ManyToMany
    private Set<RoleDao> roles;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<RoleDao> roles) {
        this.roles = roles;
    }
}
