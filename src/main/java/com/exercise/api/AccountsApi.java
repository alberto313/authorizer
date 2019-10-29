package com.exercise.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exercise.model.Account;
import com.exercise.model.AccountResponse;
import com.exercise.model.Transaction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "com.exercise.codegen.languages.SpringCodegen", date = "2019-10-27T21:02:29.588Z")

@Api(value = "accounts", description = "the accounts API")
public interface AccountsApi {

    /**
     * Endpoint that creates a new account in a in-memory cache
     * @param body
     * @return
     */
    @ApiOperation(value = "Creates a new cash account.", nickname = "accountsPost", notes = "", response = AccountResponse.class, tags={ "accounts", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = AccountResponse.class) })
    @RequestMapping(value = "/accounts",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<AccountResponse> accountsPost(@ApiParam(value = "Account object needed to perform transactions." ,required=true )  @Valid @RequestBody Account body);


    /**
     * Endpoint that handles the transactions to perform against the previously created account
     * @param body
     * @return
     */
    @ApiOperation(value = "Authorize and perform transactions", nickname = "accountsPut", notes = "", response = AccountResponse.class, tags={ "transactions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = AccountResponse.class) })
    @RequestMapping(value = "/accounts",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<AccountResponse> accountsPut(@ApiParam(value = "Transaction object to perform." ,required=true )  @Valid @RequestBody Transaction body);

}
