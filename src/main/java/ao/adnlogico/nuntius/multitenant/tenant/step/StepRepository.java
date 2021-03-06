package ao.adnlogico.nuntius.multitenant.tenant.step;

import ao.adnlogico.nuntius.multitenant.tenant.step.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Md. Amran Hossain
 */
@Repository
public interface StepRepository extends JpaRepository<Step, Long>
{

}
