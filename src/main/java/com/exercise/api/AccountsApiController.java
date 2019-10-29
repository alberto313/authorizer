package com.exercise.api;

import static org.springframework.http.HttpStatus.OK;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.exercise.model.Account;
import com.exercise.model.AccountResponse;
import com.exercise.model.Transaction;
import com.exercise.service.IBankService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "com.exercise.codegen.languages.SpringCodegen", date = "2019-10-27T21:02:29.588Z")

@Controller
public class AccountsApiController implements AccountsApi {

    private static final Logger log = LoggerFactory.getLogger(AccountsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private IBankService bankService;

    @org.springframework.beans.factory.annotation.Autowired
    public AccountsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AccountResponse> accountsPost(@ApiParam(value = "Account object needed to perform transactions." ,required=true )  @Valid @RequestBody Account body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<AccountResponse>(bankService.createAccount(body), OK);
        }

        return new ResponseEntity<AccountResponse>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<AccountResponse> accountsPut(@ApiParam(value = "Transaction object to perform." ,required=true )  @Valid @RequestBody Transaction body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	return new ResponseEntity<AccountResponse>(bankService.performTransaction(body), OK);
        }
        
        return new ResponseEntity<AccountResponse>(HttpStatus.BAD_REQUEST);
    }

}
