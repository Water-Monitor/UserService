package watermonitor.userservice.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import watermonitor.userservice.mappers.UserMapper;
import watermonitor.userservice.models.dao.UserDao;
import watermonitor.userservice.models.dto.send_in.CreateUserDto;
import watermonitor.userservice.models.dto.send_out.UserDto;
import watermonitor.userservice.repositories.RoleRepository;
import watermonitor.userservice.repositories.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public UserDao readUserByUsername (String username) {
        return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }
    public UserDto createUser(CreateUserDto userCreateRequest) {
        Optional<UserDao> byUsername = userRepository.findByUsername(userCreateRequest.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }

        UserDao user = new UserDao();
        user.setName(userCreateRequest.getName());
        user.setUsername(userCreateRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));

        UserDao savedUser = userRepository.save(user);

        return UserMapper.INSTANCE.map(savedUser);
    }

    public Optional<UserDto> getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()) {
            return Optional.empty();
        }

        String name = (String) authentication.getPrincipal();
        Optional<UserDao> userDao = userRepository.findByUsername(name);
        UserDto userDto = UserMapper.INSTANCE.map(userDao.get());
        return Optional.of(userDto);
    }
}