package watermonitor.userservice.models.dao;

import lombok.*;

import javax.persistence.*;

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
}
