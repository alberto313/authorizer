package com.exercise.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Detailed Transaction information to perform over an account
 */
@Validated
@javax.annotation.Generated(value = "com.exercise.codegen.languages.SpringCodegen", date = "2019-10-27T21:02:29.588Z")

public class TransactionTransaction   {
  @JsonProperty("merchant")
  private String merchant = null;

  @JsonProperty("amount")
  private int amount = 0;

  @JsonProperty("time")
  private String time = null;

  public TransactionTransaction merchant(String merchant) {
    this.merchant = merchant;
    return this;
  }

  /**
   * 
   * @return merchant
  **/
  @ApiModelProperty(value = "")


  public String getMerchant() {
    return merchant;
  }

  public void setMerchant(String merchant) {
    this.merchant = merchant;
  }

  public TransactionTransaction amount(int amount) {
    this.amount = amount;
    return this;
  }

  /**
   * 
   * @return amount
  **/
  @ApiModelProperty(value = "")


  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public TransactionTransaction time(String time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
  **/
  @ApiModelProperty(example = "2019-02-13T10:00:00.000Z", value = "")


  public LocalDateTime getTime() {
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	  LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
    return dateTime;
  }

  public void setTime(String time) {
    this.time = time;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionTransaction transactionTransaction = (TransactionTransaction) o;
    return Objects.equals(this.merchant, transactionTransaction.merchant) &&
        Objects.equals(this.amount, transactionTransaction.amount) &&
        Objects.equals(this.time, transactionTransaction.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchant, amount, time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionTransaction {\n");
    
    sb.append("    merchant: ").append(toIndentedString(merchant)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
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

