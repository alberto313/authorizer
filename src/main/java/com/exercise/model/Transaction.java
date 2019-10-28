package com.exercise.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.exercise.model.TransactionTransaction;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Transaction information
 */
@ApiModel(description = "Transaction information")
@Validated
@javax.annotation.Generated(value = "com.exercise.codegen.languages.SpringCodegen", date = "2019-10-27T21:02:29.588Z")

public class Transaction   {
  @JsonProperty("transaction")
  private TransactionTransaction transaction = null;

  public Transaction transaction(TransactionTransaction transaction) {
    this.transaction = transaction;
    return this;
  }

  /**
   * Get transaction
   * @return transaction
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TransactionTransaction getTransaction() {
    return transaction;
  }

  public void setTransaction(TransactionTransaction transaction) {
    this.transaction = transaction;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.transaction, transaction.transaction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transaction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

