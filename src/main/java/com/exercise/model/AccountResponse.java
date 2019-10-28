package com.exercise.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountResponse
 */
@Validated
@javax.annotation.Generated(value = "com.exercise.codegen.languages.SpringCodegen", date = "2019-10-27T21:02:29.588Z")

public class AccountResponse extends Account  {
  @JsonProperty("violations")
  @Valid
  private List<String> violations = null;

  public AccountResponse violations(List<String> violations) {
    this.violations = violations;
    return this;
  }

  public AccountResponse addViolationsItem(String violationsItem) {
    if (this.violations == null) {
      this.violations = new ArrayList<String>();
    }
    this.violations.add(violationsItem);
    return this;
  }

  /**
   * Get violations
   * @return violations
  **/
  @ApiModelProperty(value = "")


  public List<String> getViolations() {
    return violations;
  }

  public void setViolations(List<String> violations) {
    this.violations = violations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountResponse accountResponse = (AccountResponse) o;
    return Objects.equals(this.violations, accountResponse.violations) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(violations, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountResponse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    violations: ").append(toIndentedString(violations)).append("\n");
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

