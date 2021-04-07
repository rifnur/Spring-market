package ru.geekbrains.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.controllers.repr.UserRepr;
import ru.geekbrains.info.UserInfo;
import ru.geekbrains.persist.model.Role;
import ru.geekbrains.persist.model.User;
import ru.geekbrains.persist.repo.RoleRepository;
import ru.geekbrains.persist.repo.UserRepository;


import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;


@Service("userService")
public class UserServiceImpl 	implements UserService
{

  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private BCryptPasswordEncoder passwordEncoder;


  @Autowired
  @Qualifier("userRepository")
  public void setUserRepository(UserRepository urepo)
  {
	userRepository = urepo;
  }


  @Autowired
  @Qualifier("roleRepository")
  public void setRoleRepository(RoleRepository rrepo)
  {
	roleRepository = rrepo;
  }


  @Autowired
  public void setPasswordEncoder(BCryptPasswordEncoder encoder)
  {
	passwordEncoder = encoder;
  }




    @Transactional
    public boolean create(UserInfo userInfo)
    {
        User user = new User();

        String pwhash = passwordEncoder.encode(userInfo.password);
        user.setPassword(pwhash);
        Role role = roleRepository.findOneByName("ROLE_CLIENT");

        userRepository.save(user);

        return true;
    }

  @Override
  public List<UserInfo> findAllUsers() {
    return null;
  }

  @Override
  public Optional<UserInfo> findUserById(Long id) {
    return Optional.empty();
  }

  @Override
  public Optional<UserInfo> findByUserName(String username) {
    return Optional.empty();
  }

  @Override
  public boolean save(UserInfo user) {
    return false;
  }

  @Override
  public boolean delete(Long id) {
    return false;
  }

  @Override
  public List<Role> findAllRoles() {
    return null;
  }
}