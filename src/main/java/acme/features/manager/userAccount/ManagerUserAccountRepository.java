package acme.features.manager.userAccount;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ManagerUserAccountRepository extends AbstractRepository {
	
	@Query("select u from UserAccount u where u.id = ?1")
	UserAccount findOneUserAccountById(int id);

}
