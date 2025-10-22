package sum25.se183036.pehsf302trialexamse183036.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sum25.se183036.pehsf302trialexamse183036.entity.SonyAccounts;
import sum25.se183036.pehsf302trialexamse183036.entity.SonyCategories;
import sum25.se183036.pehsf302trialexamse183036.entity.SonyProducts;
import sum25.se183036.pehsf302trialexamse183036.service.SonyAccountsService;
import sum25.se183036.pehsf302trialexamse183036.service.SonyCategoriesService;
import sum25.se183036.pehsf302trialexamse183036.service.SonyProductsService;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataInit implements CommandLineRunner {
    @Autowired
    SonyAccountsService sonyAccountsService;
    @Autowired
    SonyCategoriesService sonyCategoriesService;
    @Autowired
    SonyProductsService sonyProductsService;

    public void run(String... args) throws Exception {
        // You can add data initialization logic here if needed
        if (sonyAccountsService.getSonyAccounts("0905111111", "@1") != null) {
            return;
        }
        SonyAccounts account1 = new SonyAccounts();
        account1.setPhone("0905111111");
        account1.setPassword("@1");
        account1.setRoleId(1);
        sonyAccountsService.addSonyAccounts(account1);

        SonyAccounts account2 = new SonyAccounts();
        account2.setPhone("0905222222");
        account2.setPassword("@1");
        account2.setRoleId(2);
        sonyAccountsService.addSonyAccounts(account2);

        SonyAccounts account3 = new SonyAccounts();
        account3.setPhone("0905333333");
        account3.setPassword("@1");
        account3.setRoleId(3);
        sonyAccountsService.addSonyAccounts(account3);

        SonyCategories category1 = new  SonyCategories();
        category1.setCateName("HeadPhone");
        category1.setStatus("active");
        sonyCategoriesService.addSonyCategories(category1);

        SonyCategories category2 = new  SonyCategories();
        category2.setCateName("Cameras");
        category2.setStatus("active");
        sonyCategoriesService.addSonyCategories(category2);

        SonyCategories category3 = new  SonyCategories();
        category3.setCateName("TVs");
        category3.setStatus("active");
        sonyCategoriesService.addSonyCategories(category3);

        SonyProducts product1 = new SonyProducts();
        product1.setProductName("Alpha 1 II - Full-frame Mirrorless");
        product1.setPrice(6000);
        product1.setStock(3);
        product1.setCreateAt(LocalDateTime.parse("2025-03-03"));
        SonyCategories c1 = new SonyCategories();
        c1.setCateId(2);
        product1.setCategory(c1);
        sonyProductsService.addProducts(product1);

        SonyProducts product2 = new SonyProducts();
        product2.setProductName("Alpha 7C II – Full-frame");
        product2.setPrice(2000);
        product2.setStock(5);
        product2.setCreateAt(LocalDateTime.parse("2025-04-04"));
        SonyCategories c2 = new SonyCategories();
        c2.setCateId(2);
        product2.setCategory(c2);
        sonyProductsService.addProducts(product2);

        SonyProducts product3 = new SonyProducts();
        product3.setProductName("BRAVIA 8 OLED 4K HDR TV");
        product3.setPrice(2500);
        product3.setStock(10);
        product3.setCreateAt(LocalDateTime.parse("2025-01-01"));
        SonyCategories c3 = new SonyCategories();
        c3.setCateId(3);
        product3.setCategory(c3);
        sonyProductsService.addProducts(product3);

        SonyProducts product4 = new SonyProducts();
        product4.setProductName("LinkBuds Fit Truly Wireless Noise Canceling");
        product4.setPrice(180);
        product4.setStock(15);
        product4.setCreateAt(LocalDateTime.parse("2025-03-03"));
        SonyCategories c4 = new SonyCategories();
        c4.setCateId(1);
        product4.setCategory(c4);
        sonyProductsService.addProducts(product4);
    }
}
