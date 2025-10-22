package sum25.se183036.pehsf302trialexamse183036.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sum25.se183036.pehsf302trialexamse183036.entity.SonyAccounts;
import sum25.se183036.pehsf302trialexamse183036.entity.SonyCategories;
import sum25.se183036.pehsf302trialexamse183036.entity.SonyProducts;
import sum25.se183036.pehsf302trialexamse183036.service.SonyCategoriesService;
import sum25.se183036.pehsf302trialexamse183036.service.SonyProductsService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private SonyProductsService sonyProductsService;

    @Autowired
    private SonyCategoriesService sonyCategoriesService;

    // =============================
    // 📦 Hiển thị danh sách sản phẩm
    // =============================
    @GetMapping("/product/management")
    public ModelAndView showManagementPage(HttpSession session) {
        SonyAccounts user = (SonyAccounts) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("403");
        }

        List<SonyProducts> products = sonyProductsService.getSonyProductsOrderByCreateAtDesc();
        ModelAndView mav = new ModelAndView("product/management");
        mav.addObject("products", products);
        mav.addObject("user", user);
        return mav;
    }

    // =============================
    // ➕ Hiển thị form thêm sản phẩm
    // =============================
    @GetMapping("/product/add")
    public ModelAndView addProduct(HttpSession session) {
        SonyAccounts user = (SonyAccounts) session.getAttribute("user");
        if (user == null || user.getRoleId() != 1) {
            session.invalidate();
            return new ModelAndView("redirect:/login");
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("product", new SonyProducts());
        mav.addObject("categories", sonyCategoriesService.getAllCategories());
        mav.setViewName("product/add");
        return mav;
    }

    @PostMapping("/product/add")
    public String addNewProduct(@Valid SonyProducts product,
                                BindingResult bindingResult,
                                Model model,
                                HttpSession session) {
        SonyAccounts user = (SonyAccounts) session.getAttribute("user");
        if (user == null || user.getRoleId() != 1) {
            session.invalidate();
            return "redirect:/login";
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            model.addAttribute("categories", sonyCategoriesService.getAllCategories());
            return "product/add";
        }

        LocalDateTime currentDate = LocalDateTime.now();
        product.setCreateAt(currentDate);

        sonyProductsService.addProducts(product);
        return "redirect:/product/management";
    }
    @GetMapping("/product/update/{id}")
    public ModelAndView updateProduct(@PathVariable int id, HttpSession session) {
        SonyAccounts user = (SonyAccounts) session.getAttribute("user");
        if (user == null || user.getRoleId() != 1) {
            session.invalidate();
            return new ModelAndView("redirect:/login");
        }
        SonyProducts product = sonyProductsService.getProductById(id);
        List<SonyCategories> categories = sonyCategoriesService.getAllCategories();
        ModelAndView mav = new ModelAndView();
        mav.addObject("product", product);
        mav.addObject("categories", categories);
        mav.setViewName("/product/update");
        return mav;
    }

    @PostMapping("/product/update")
    public ModelAndView updateProduct (@Valid SonyProducts product,
                                       BindingResult bindingResult,
                                       @RequestParam("cateId") int cateId,
                                       Model model, HttpSession session) {
        SonyAccounts user = (SonyAccounts) session.getAttribute("user");
        if (user == null || user.getRoleId() != 1) {
            session.invalidate();
            return new ModelAndView("redirect:/login");
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            model.addAttribute("categories", sonyCategoriesService.getAllCategories());
            return new ModelAndView("/product/update");
        }
        SonyCategories category = sonyCategoriesService.getCategoryById(cateId);
        product.setCategory(category);
        sonyProductsService.updateProduct(product.getProductID(), product);
        return new ModelAndView("redirect:/product/management");
    }
    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable int id, HttpSession session) {
        SonyAccounts user = (SonyAccounts) session.getAttribute("user");
        if (user == null || user.getRoleId() != 1) {
            session.invalidate();
            return "redirect:/login";
        }
        sonyProductsService.deleteProduct(id);
        return "redirect:/product/management";
    }


}
