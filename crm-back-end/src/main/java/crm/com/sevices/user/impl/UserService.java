package crm.com.sevices.user.impl;

import crm.com.entities.user.AppUser;
import crm.com.repositores.IUserRepository;
import crm.com.sevices.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;


    @Override
    public AppUser findUserByUserName(String userName) {
        return this.userRepository.findById(userName).get();
    }
}
