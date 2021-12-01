package watermonitor.userservice.models.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity(name = "role")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDao implements Dao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private long id;
    @NonNull
    @Column(length=50)
    private String name;

//    @ManyToMany(mappedBy = "roles")
//    private Set<UserDao> users;
}