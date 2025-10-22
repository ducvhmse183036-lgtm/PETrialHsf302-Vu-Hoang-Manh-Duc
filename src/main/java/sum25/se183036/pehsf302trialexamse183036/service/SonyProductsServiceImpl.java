package sum25.se183036.pehsf302trialexamse183036.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.se183036.pehsf302trialexamse183036.entity.SonyProducts;
import sum25.se183036.pehsf302trialexamse183036.repository.SonyProductsRepository;

import java.util.List;

@Service
public class SonyProductsServiceImpl implements SonyProductsService {

    @Autowired
    private SonyProductsRepository sonyProductsRepository;

    @Override
    public boolean addProducts(SonyProducts product) {
        return sonyProductsRepository.save(product) != null;
    }

    @Override
    public void deleteProduct(int id) {
        sonyProductsRepository.deleteById(id);
    }

    @Override
    public List<SonyProducts> getSonyProductsOrderByCreateAtDesc() {
        return sonyProductsRepository.findAllByOrderByCreateAtDesc();
    }

    @Override
    public SonyProducts getProductById(int id) {
        return sonyProductsRepository.findById(id).orElse(null);
    }

    @Override
    public void updateProduct(int id, SonyProducts product) {
        SonyProducts existingProduct = sonyProductsRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setProductName(product.getProductName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setStock(product.getStock()); // ✅ THÊM DÒNG NÀY
            existingProduct.setCategory(product.getCategory());
            sonyProductsRepository.save(existingProduct);
        }
    }

}
