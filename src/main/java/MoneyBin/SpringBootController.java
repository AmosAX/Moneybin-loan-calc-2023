package MoneyBin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@Controller
public class SpringBootController {

    ArrayList<Customer> customerList = LoanCalculator.readFile("prospects.txt");

    @GetMapping("/WebPage")
    public String showAll(Model model) {
        model.addAttribute("customer", customerList);
        return "WebPage";
    }

    @PostMapping("/WebPage")
    public String addCustomer(@ModelAttribute Customer newCustomer, Model model) {
        customerList.add(newCustomer);
        model.addAttribute("customer", customerList);
        return "WebPage";
    }
}

