/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.controller;


import com.wonderlabz.bankaccountservice.dto.DepositWithdrawDto;
import com.wonderlabz.bankaccountservice.dto.DepositWithdrawMsgDto;
import com.wonderlabz.bankaccountservice.dto.TransactionDto;
import com.wonderlabz.bankaccountservice.dto.TransferDto;
import com.wonderlabz.bankaccountservice.exception.BankAccountOperationException;
import com.wonderlabz.bankaccountservice.exception.NoRecordFoundException;
import com.wonderlabz.bankaccountservice.mapper.TransactionMapper;
import com.wonderlabz.bankaccountservice.service.TransactionServiceImpl;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */

@RestController
@RequestMapping("/api")
public class TransactionController {
    @Autowired
    TransactionServiceImpl transactionServiceImpl;
   private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
   /**
    * 
    * @param accountnumber
     * @param depositWithdrawDto
    * @return
    * @throws NoRecordFoundException
    * @throws BankAccountOperationException 
    */
   @PostMapping("/deposit/{accountnumber}")
   public  ResponseEntity<DepositWithdrawMsgDto>  deposit(@Valid @PathVariable("accountnumber") String accountnumber ,@Valid @RequestBody  DepositWithdrawDto  depositWithdrawDto) throws NoRecordFoundException, BankAccountOperationException{
        
       DepositWithdrawMsgDto depositWithdrawMsgDto=  TransactionMapper.INSTANCE.toDepositWithdrawMsgDto(transactionServiceImpl.deposit(accountnumber, depositWithdrawDto.getAmount()));
       return new ResponseEntity<>(depositWithdrawMsgDto, HttpStatus.OK);   
   }
   /**
    * 
    * @param accountnumber
     * @param depositWithdrawDto 
     * @return  
     * @throws NoRecordFoundException 
     * @throws BankAccountOperationException 
    */
    @PostMapping("/withdraw/{accountnumber}")
   public  ResponseEntity<DepositWithdrawMsgDto> withdraw(@Valid @PathVariable("accountnumber") String accountnumber ,@Valid @RequestBody  DepositWithdrawDto  depositWithdrawDto) throws NoRecordFoundException, BankAccountOperationException{
         
            
          DepositWithdrawMsgDto depositWithdrawMsgDto=  TransactionMapper.INSTANCE.toDepositWithdrawMsgWDto(transactionServiceImpl.withdraw(accountnumber, depositWithdrawDto.getAmount()));
                   
          return new ResponseEntity<>(depositWithdrawMsgDto, HttpStatus.OK);   
   }
  
   /**
    * 
     * @param accountnumberfrom
     * @param transferDto
     * @param depositWithdrawDto
    * @return
    * @throws NoRecordFoundException
    * @throws BankAccountOperationException 
    */
   //@PostMapping("/queryCurWeatherNullById/{id}/{name}")

   @PostMapping("/transfer/{accounnumberfrom}")
   public ResponseEntity< DepositWithdrawMsgDto>  transfer( @PathVariable("accounnumberfrom") String accountnumberfrom,
                                                            @Valid @RequestBody  TransferDto  transferDto)
                                                            throws NoRecordFoundException, BankAccountOperationException{
      
           DepositWithdrawMsgDto depositWithdrawMsgDto=  TransactionMapper.INSTANCE.toDepositWithdrawMsgDto(transactionServiceImpl.transfer(accountnumberfrom, transferDto.getAccountnumberTo(), transferDto.getAmount()));
          depositWithdrawMsgDto.setMessage("Successful Transfered R "+transferDto.getAmount()+" "+" To Account Number :"+transferDto.getAccountnumberTo());
          return new ResponseEntity<>(depositWithdrawMsgDto, HttpStatus.OK); 
   }
   /**
    * This method is used to retrieve the list all transaction History
    * @return List of TransactionHistory
    */
   @GetMapping("/transactionhistory")
   public ResponseEntity <List<TransactionDto>> allTransactionHistory(){
       
       List<TransactionDto> transactionDtoList=TransactionMapper.INSTANCE.toTransactionDtolist(transactionServiceImpl.getAllTransaction());
       
        return new ResponseEntity<>(transactionDtoList, HttpStatus.OK);
       
   }
   /**
    * 
    * @param startdate
    * @param enddate
    * @return 
    */
   @GetMapping("/transactionhistory/{startdate}/{enddate}")
   public ResponseEntity <List<TransactionDto>> transactionHistoryByDate(@PathVariable("startdate")String startdate,@PathVariable("enddate")String enddate){
        LocalDate localDatestart = LocalDate.parse(startdate);
        LocalDate localDateend = LocalDate.parse(enddate);
        List<TransactionDto> transactionDtoList=       TransactionMapper.INSTANCE
                .toTransactionDtolist(transactionServiceImpl.getAllTransactionByDateRange(localDatestart, localDateend));
         return new ResponseEntity<>(transactionDtoList, HttpStatus.OK);
   }
   /**
    * 
    * @param transactionid 
     * @return  
     * @throws NoRecordFoundException 
    */
   @GetMapping("/transaction/{transactionid}")
   public TransactionDto transactionHistoryByTransactionId(@Valid @PathVariable("transactionid")long transactionid) throws NoRecordFoundException{
        TransactionDto transactionDto=       TransactionMapper.INSTANCE
                .toTransactionDtolist(transactionServiceImpl.getTransactionsByTransactionId(transactionid));
        return transactionDto;
   }
   /**
    * 
    * @param accountnumber
    * @return List of TransactionHistory
    * @throws NoRecordFoundException 
    */
   @GetMapping(value="/transactionhistory/{accounnumber}",produces= MediaType.APPLICATION_JSON_VALUE) 
   public ResponseEntity <List<TransactionDto>>   transactionHistoryByAccountNumber(@Valid @PathVariable("accounnumber") String accountnumber)
           throws NoRecordFoundException{
     
      List<TransactionDto> transactionDto=TransactionMapper.INSTANCE
              .toTransactionDtolist(transactionServiceImpl.getTransactionByAcountNumber(accountnumber));
      
       return new ResponseEntity<>(transactionDto, HttpStatus.OK); 
       
   }
   /**
    * 
    * @param accountnumber
    * @param startdate
    * @param enddate
    * @return
    * @throws NoRecordFoundException 
    */
   @GetMapping("/transactionhistory/{accounnumber}/{startdate}/{enddate}")
   public ResponseEntity <List<TransactionDto>> transactionHistoryByAccountNumberByDate(@Valid @PathVariable("accounnumber")String accountnumber,@PathVariable("startdate") String startdate,@PathVariable("enddate") String enddate) throws NoRecordFoundException{
            LocalDate localDatestart = LocalDate.parse(startdate);
            LocalDate localDateend = LocalDate.parse(enddate);
          List<TransactionDto> transactionDto=TransactionMapper.INSTANCE
              .toTransactionDtolist(transactionServiceImpl.getTransactionByAcountNumberByDate(accountnumber, localDatestart, localDateend));
           return new ResponseEntity<>(transactionDto, HttpStatus.OK); 
   }
}
