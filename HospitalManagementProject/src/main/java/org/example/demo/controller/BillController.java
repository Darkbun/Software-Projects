package org.example.demo.controller;

import org.example.demo.dto.BillDto;
import org.example.demo.exception.ResourceNotFoundException;
import org.example.demo.models.Bill;
import org.example.demo.service.BillService;
import org.example.demo.util.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping
    public ResponseEntity<BillDto> createBill(@RequestBody BillDto billDto){
        System.out.println("Creating Bill");
        System.out.println("Received DTO: " + billDto.toString());
        
        Bill bill = DtoConverter.toBill(billDto);
        System.out.println("Converted to Entity: " + bill.toString());
        
        Bill createdBill = billService.createBill(bill);
        if (createdBill != null) {
            BillDto responseDto = DtoConverter.toBillDto(createdBill);
            System.out.println("Response DTO: " + responseDto.toString());
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity<List<BillDto>> getAllBill(){
        System.out.println("Fetching the Bills");
        List<Bill> bills = billService.getAllBills();
        if (bills != null) {
            List<BillDto> billDtos = bills.stream()
                    .map(DtoConverter::toBillDto)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(billDtos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillDto> getBillById(@PathVariable Long id){
        System.out.println("Fetching the Bill by ID");
        Bill bill = billService.getBillById(id);
        if (bill != null) {
            return new ResponseEntity<>(DtoConverter.toBillDto(bill), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Bill not found with id: " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillDto> updateBill(@PathVariable Long id, @RequestBody BillDto billDto){
        System.out.println("Updating the Bill by ID");
        Bill bill = DtoConverter.toBill(billDto);
        Bill updatedBill = billService.updateBill(id, bill);
        if (updatedBill != null) {
            return new ResponseEntity<>(DtoConverter.toBillDto(updatedBill), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Bill not found with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable Long id){
        System.out.println("Deleting the Bill by ID");
        Bill bill = billService.getBillById(id);
        if (bill != null) {
            billService.deleteBill(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        throw new ResourceNotFoundException("Bill not found with id: " + id);
    }

}
