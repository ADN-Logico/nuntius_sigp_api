package ao.adnlogico.nuntius.multitenant.tenant.forwarding;

import ao.adnlogico.nuntius.multitenant.tenant.forwarding.Forwarding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Md. Amran Hossain
 */
@Repository
public interface ForwardingRepository extends JpaRepository<Forwarding, Long>
{

}
