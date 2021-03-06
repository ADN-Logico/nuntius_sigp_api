package ao.adnlogico.nuntius.multitenant.tenant.module;

import ao.adnlogico.nuntius.multitenant.tenant.module.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Md. Amran Hossain
 */
@Repository
public interface ModuleRepository extends JpaRepository<Module, Long>
{

}
