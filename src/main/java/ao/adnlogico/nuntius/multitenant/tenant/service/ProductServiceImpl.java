package ao.adnlogico.nuntius.multitenant.tenant.service;

import ao.adnlogico.nuntius.multitenant.tenant.entity.Product;
import ao.adnlogico.nuntius.multitenant.tenant.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Md. Amran Hossain
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}