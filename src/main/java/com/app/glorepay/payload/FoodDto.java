package com.app.glorepay.payload;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
    * Add the appropriate annotation for the fields to handle the validation
      using hibernate validator. Requirements are:
      * type should not be null or blank
      * date should not be null
      * amount should not be null and should be a positive number or zero
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
    private Long id;
    @NotEmpty(message = "Type cannot be blank")
    private String type;
    @NotNull(message = "Date must not be null")
    private Date date;
    @Min(value =0L,message = "Amount must be a positive number or zero")

    private Integer amount;
}
