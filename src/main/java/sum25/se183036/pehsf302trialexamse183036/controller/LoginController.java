package sum25.se183036.pehsf302trialexamse183036.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sum25.se183036.pehsf302trialexamse183036.entity.SonyAccounts;
import sum25.se183036.pehsf302trialexamse183036.service.SonyAccountsService;

@Controller
public class LoginController {
    @Autowired
    SonyAccountsService sonyAccountsService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String processLogin(HttpSession session,
                               @RequestParam String phone,
                               @RequestParam String password,
                               RedirectAttributes redirectAttributes) {
        SonyAccounts sonyAccounts = sonyAccountsService.getSonyAccounts(phone, password);

        if (sonyAccounts == null) {
            redirectAttributes.addFlashAttribute("error", "Invalid phone or password!");
            return "redirect:/login";
        }

        if (!sonyAccountsService.checkRole(phone)) {
            return "redirect:/403";
        }

        session.setAttribute("user", sonyAccounts);
        return "redirect:/product/management";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.invalidate();
        redirectAttributes.addFlashAttribute("message", "You have been logged out successfully.");
        return "redirect:/login";
    }

    @GetMapping("/403")
    public String accessDenied(){
        return "403";
    }
}
