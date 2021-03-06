package ao.adnlogico.nuntius.multitenant.tenant.department;

import ao.adnlogico.nuntius.multitenant.tenant.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Md. Amran Hossain
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>
{

}
