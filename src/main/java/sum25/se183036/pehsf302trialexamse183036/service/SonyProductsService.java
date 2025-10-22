package sum25.se183036.pehsf302trialexamse183036.service;

import sum25.se183036.pehsf302trialexamse183036.entity.SonyProducts;

import java.util.List;

public interface SonyProductsService {
    SonyProducts getProductById(int id);
    boolean addProducts(SonyProducts product);
    public void deleteProduct(int id);
    List<SonyProducts> getSonyProductsOrderByCreateAtDesc();
    void updateProduct(int id, SonyProducts product);
}
