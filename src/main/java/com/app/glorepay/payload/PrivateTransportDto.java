package com.app.glorepay.payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/*
    * Add the appropriate annotation for the fields to handle the validation
      using hibernate validator. Requirements are:
      * type should not be null or blank
      * date should not be null
      * miles should not be null and should be a positive number
      * amount should not be null and should be a positive number
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PrivateTransportDto {
    private Long id;
    @NotEmpty(message = "Type cannot be blank")
    private String type;
    @NotNull(message = "Date cannot be null")
    private Date date;
    @Min(value = 0L,message = "Miles must be a positive number")
    private Integer miles;
    @Min(value = 0L,message = "Amount must be a positive number")
    private Integer amount;
}
