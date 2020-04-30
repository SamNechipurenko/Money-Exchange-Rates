package com.rates.exchange.controller;

import com.rates.exchange.clients.cryptoRates.model.BtcModel;
import com.rates.exchange.clients.cryptoRates.model.EthModel;
import com.rates.exchange.clients.cryptoRates.service.CryptaRatesService;
import com.rates.exchange.clients.moneyRates.model.DollarMoneyRatesModel;
import com.rates.exchange.clients.moneyRates.model.EuroMoneyRatesModel;
import com.rates.exchange.clients.moneyRates.service.MoneyRatesService;
import com.rates.exchange.model.User;
import com.rates.exchange.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ExchangeController {
    UserDetails principal;
    String username;
    @Autowired
    UserService userService;

    MoneyRatesService moneyRatesService = new MoneyRatesService();
    CryptaRatesService cryptaRatesService = new CryptaRatesService();

    @GetMapping("/")
    public String main(Model mav){
        principal =(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        username = principal.getUsername();
        //service.getAll()
        //RestTemplate
        mav.addAttribute("username", username);
        return "main";
    }
    @PostMapping("/addNewUser")
    public String addNewUser(@RequestParam("username") String username,
                             @RequestParam("email") String email,
                             RedirectAttributes redirectAttributes){
        User user = new User();
        user.setUsername(username);
        user.setPassword("1111");
        user.setEmail(email);
        String saveUserMsg = userService.saveUser(user);
        redirectAttributes.addAttribute("exceptionMsg", saveUserMsg);
        return"redirect:/users";
    }


    @GetMapping("/currents")
    public String currents(Model mav){
        // Money
        DollarMoneyRatesModel dollarMoneyRatesModel = moneyRatesService.getDollarCurrentRates("USD");
        EuroMoneyRatesModel euroMoneyRatesModel = moneyRatesService.getEuroCurrentRates("EUR");
        Double usdToUah = dollarMoneyRatesModel.getConversion_rates().getUAH();
        Double usdToRub = dollarMoneyRatesModel.getConversion_rates().getRUB();
        Double euroToUsd = euroMoneyRatesModel.getConversion_rates().getUSD();
        // Date
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date(moneyRatesService.getDollarCurrentRates("USD").getTime_last_update()));
        // Crypto
        BtcModel btcModel = cryptaRatesService.getBtcCurrentRates();
        EthModel ethModel = cryptaRatesService.getEthCurrentRates();
        Double btcToUsd = btcModel.getUSD();
        Double btcToEth = btcModel.getETH();
        Double btcToUah = btcModel.getUAH();
        Double ethToUsd = ethModel.getUSD();

        mav.addAttribute("usdToUah", usdToUah);
        mav.addAttribute("usdToRub", usdToRub);
        mav.addAttribute("euroToUsd", euroToUsd);

        mav.addAttribute("date", date);

        mav.addAttribute("btcToUsd", btcToUsd);
        mav.addAttribute("btcToEth", btcToEth);
        mav.addAttribute("btcToUah", btcToUah);
        mav.addAttribute("ethToUsd", ethToUsd);
        return "currents";
    }

    @GetMapping("/users")
    public String users(@NotNull Model mav, @RequestParam("exceptionMsg") String exceptionMsg){
        List<User> userList = userService.findAllUsers();
        mav.addAttribute("userList", userList);
        mav.addAttribute("exceptionMsg", exceptionMsg);
        return "users";
    }

    @GetMapping("/account")
    public String office(Model mav, @RequestParam("exceptionMsg") String exceptionMsg){
        User user = userService.findUserByUsername(username);
        mav.addAttribute("username", username);
        mav.addAttribute("email", user.getEmail());
        mav.addAttribute("password", user.getPassword());
        mav.addAttribute("exceptionMsg", exceptionMsg);
        return "office";
    }

    @PostMapping("/changeData")
    public String changeData(@RequestParam("password") String password,
                             RedirectAttributes redirectAttributes){

        String editUserMsg = userService.editUser(username, password);
        redirectAttributes.addAttribute("exceptionMsg", editUserMsg);
        return"redirect:/account";
    }


}
