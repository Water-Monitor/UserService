package watermonitor.userservice.models.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

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
    @Column
    @Size(min = 8, max = 200)
    private String name;
    @NonNull
    @Column
    @Size(min = 8, max = 200)
    private String username;
    @NonNull
    @Size(min = 8, max = 200)
    private String password;
    @Transient
    @Size(min = 8, max = 200)
    private String passwordConfirm;
    @ManyToMany
    private List<RoleDao> roles;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<RoleDao> roles) {
        this.roles = roles;
    }
}
