package com.exercise.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountAccount
 */
@Validated
@javax.annotation.Generated(value = "com.exercise.codegen.languages.SpringCodegen", date = "2019-10-27T21:02:29.588Z")

public class AccountAccount   {
  @JsonProperty("availableLimit")
  private int availableLimit = 0;

  @JsonProperty("activeCard")
  private Boolean activeCard = null;

  public AccountAccount availableLimit(int availableLimit) {
    this.availableLimit = availableLimit;
    return this;
  }

  /**
   * Get availableLimit
   * @return availableLimit
  **/
  @ApiModelProperty(value = "")


  public int getAvailableLimit() {
    return availableLimit;
  }

  public void setAvailableLimit(int availableLimit) {
    this.availableLimit = availableLimit;
  }

  public AccountAccount activeCard(Boolean activeCard) {
    this.activeCard = activeCard;
    return this;
  }

  /**
   * Get activeCard
   * @return activeCard
  **/
  @ApiModelProperty(value = "")


  public Boolean isActiveCard() {
    return activeCard;
  }

  public void setActiveCard(Boolean activeCard) {
    this.activeCard = activeCard;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountAccount accountAccount = (AccountAccount) o;
    return Objects.equals(this.availableLimit, accountAccount.availableLimit) &&
        Objects.equals(this.activeCard, accountAccount.activeCard);
  }

  @Override
  public int hashCode() {
    return Objects.hash(availableLimit, activeCard);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountAccount {\n");
    
    sb.append("    availableLimit: ").append(toIndentedString(availableLimit)).append("\n");
    sb.append("    activeCard: ").append(toIndentedString(activeCard)).append("\n");
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

