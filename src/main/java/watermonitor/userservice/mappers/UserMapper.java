package watermonitor.userservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import watermonitor.userservice.models.dao.RoleDao;
import watermonitor.userservice.models.dao.UserDao;
import watermonitor.userservice.models.dto.send_out.UserDto;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(qualifiedByName = "mapRoles", target = "roles", source = "roles")
    UserDto map(UserDao user);

    @Named("mapRoles")
    default List<String> mapRoles(List<RoleDao> roleDaos) {
        List<String> roles = new ArrayList<>();

        for(RoleDao roleDao : roleDaos) {
            roles.add(roleDao.getName());
        }

        return roles;
    }
}
