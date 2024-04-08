package com.fcabrera89.rest_api_demo.Person;



import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
  @Id
  @GeneratedValue
  private Integer id;
  @Basic
  @NotNull
  @Size(min = 2, message = "First Name should have atleast 2 characters")
  private String firstname;
  @NotNull
  @Size(min = 2, message = "Last Name should have atleast 2 characters")
  private String lastname;
  @Email
  @NotBlank
  private String email;
  @NotNull
  private int age;
}
