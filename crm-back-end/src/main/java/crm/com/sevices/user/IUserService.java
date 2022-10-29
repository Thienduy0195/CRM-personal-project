package crm.com.sevices.user;

import crm.com.entities.user.AppUser;

public interface IUserService {
    public AppUser findUserByUserName(String userName);
}
