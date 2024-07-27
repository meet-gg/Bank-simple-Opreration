package com.example.varachha.Srevices;

import com.example.varachha.Exception.ResourceNotFoundException;
import com.example.varachha.Model.VarachhaBank;
import com.example.varachha.Reposi.VrachhaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankSer {
    @Autowired
    VrachhaRepo varachharepo;

    public List<VarachhaBank> getall(){
        return varachharepo.findAll();
    }
    public VarachhaBank save(VarachhaBank bank){

        return varachharepo.save(bank);
    }
    public VarachhaBank getbalance(Long acno){
        isAccountexist(acno);
        return varachharepo.findById(acno).get();
    }
    public void isAccountexist(Long acno){
        boolean isexist=varachharepo.existsById(acno);
        if (!isexist) throw new ResourceNotFoundException("Account Number Not found" +acno);
    }

    public void withdraw(Long acno,Long money) throws Exception {
//        try {
            isAccountexist(acno);
            VarachhaBank varachhaBank=varachharepo.findById(acno).get();
            if (varachhaBank.getBalance()<money){
                throw new Exception("not sufficient amount of balance" + acno);
            }
            varachhaBank.setBalance(varachhaBank.getBalance()-money);
            varachharepo.save(varachhaBank);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            throw new Exception("server error money not withdraw from account");
//        }
    }
    public void deposit(Long acno,Long money) throws Exception {
        try {
            isAccountexist(acno);
            VarachhaBank varachhaBank=varachharepo.findById(acno).get();
            varachhaBank.setBalance(varachhaBank.getBalance()+money);
            varachharepo.save(varachhaBank);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception("server error money not Deposit to your account" +acno);
        }
    }
    public void transfer(Long sourceacno,Long destinationacno,Long money) throws Exception {
        try {
            withdraw(sourceacno,money);
            deposit(destinationacno,money);
        }
        catch (Exception e){
            throw new Exception("not sufficient amount for transfer money");
        }
    }
}
