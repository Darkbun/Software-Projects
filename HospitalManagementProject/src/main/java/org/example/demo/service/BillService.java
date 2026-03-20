package org.example.demo.service;

import org.example.demo.models.Bill;
import org.example.demo.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public Bill createBill(Bill bill) {
        try{
            return billRepository.save(bill);
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }

    public List<Bill> getAllBills() {
        try{
            return billRepository.findAll();
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }

    public Bill getBillById(long id) {
        try{
            return billRepository.findById(id).orElse(null);
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }

    public Bill updateBill(long id, Bill bill){
        try{
            Bill existingBill = billRepository.findById(id).orElse(null);
            if (existingBill != null) {
                existingBill.setPatientId(bill.getPatientId());
                existingBill.setDoctorId(bill.getDoctorId());
                existingBill.setAmount(bill.getAmount());
                existingBill.setStatus(bill.getStatus());
                return billRepository.save(existingBill);
            }
            return null;
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }

    public void deleteBill(long id) {
        try{
            billRepository.deleteById(id);
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
        }
    }
}
