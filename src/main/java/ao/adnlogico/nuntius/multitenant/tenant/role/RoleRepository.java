package ao.adnlogico.nuntius.multitenant.tenant.role;

import ao.adnlogico.nuntius.multitenant.tenant.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Md. Amran Hossain
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>
{

}
