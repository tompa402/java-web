package hr.java.web.novak.moneyapp.controller;

import hr.java.web.novak.moneyapp.model.Expense;
import hr.java.web.novak.moneyapp.model.ExpenseType;
import hr.java.web.novak.moneyapp.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }


    @GetMapping
    public String expensesList(Model model){
        model.addAttribute("expenses", expenseService.findAll());
        return "expense/index";
    }

    @GetMapping("/new")
    public String newExpense(Model model){
        model.addAttribute("expense", new Expense());
        model.addAttribute("expenseTypes", ExpenseType.values());
        return "expense/newExpense";
    }

    @PostMapping("/new")
    public ModelAndView processExpense(Expense expense){
        expenseService.save(expense);
        ModelAndView mav = new ModelAndView("expense/details");
        mav.addObject(expense);
        return mav;
    }

    @GetMapping("/view")
    public String singleExpense(){
        return "details";
    }

}
