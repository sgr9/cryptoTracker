package com.cryptoTracker.demo.Controller;


import com.cryptoTracker.demo.model.CryptoCoin;
import com.cryptoTracker.demo.Service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class CryptoController {
    @Autowired
    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/track")
    public String track(@RequestParam String coins, Model model) {
        List<String> coinList = Arrays.asList(coins.split(","));
        List<CryptoCoin> result = cryptoService.getCryptoPrices(coinList);
        model.addAttribute("coins", result);
        return "result";
    }
}