package watermonitor.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import watermonitor.userservice.models.dao.RoleDao;

public interface RoleRepository extends JpaRepository<RoleDao, Long> {
    RoleDao findByName(String name);
}
