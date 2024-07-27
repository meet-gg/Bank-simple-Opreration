package com.example.varachha.Controller;

import com.example.varachha.Model.VarachhaBank;
import com.example.varachha.Srevices.BankSer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    BankSer bankSer;
    @PostMapping(path = "/save")
    public VarachhaBank save(@Valid @RequestBody VarachhaBank bank){
      return bankSer.save(bank);
    }
    @GetMapping(path = "/getAll")
    public List<VarachhaBank> getall(){
        return bankSer.getall();
    }

    @GetMapping(path = "getbalance/ig")
    public VarachhaBank getbalance(@PathVariable @Valid Long id){
        return bankSer.getbalance(id);
    }

    @PostMapping(path = "/deposit")
    public void deposit(@RequestParam @Valid Long acno,@RequestParam @Valid Long money) throws Exception {
        bankSer.deposit(acno,money);
    }
    @PostMapping(path = "/withdraw")
    public void withdraw(@RequestParam @Valid Long acno,@RequestParam @Valid Long money) throws Exception {
        bankSer.withdraw(acno, money);
    }
    @PostMapping(path = "/transfer")
    public void transfer(@RequestParam @Valid Long source,@RequestParam @Valid Long dest ,@RequestParam @Valid Long money) throws Exception {
        bankSer.transfer(source,dest,money);
    }
}
