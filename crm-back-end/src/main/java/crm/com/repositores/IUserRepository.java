package crm.com.repositores;

import crm.com.entities.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<AppUser, String> {
}
