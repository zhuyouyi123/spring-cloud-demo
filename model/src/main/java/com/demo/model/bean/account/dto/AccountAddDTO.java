package com.demo.model.bean.account.dto;

import com.demo.model.common.BaseDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class AccountAddDTO extends BaseDTO {

    @NotBlank(message = "用户名不能为空")
    private String username;

    private String gender;

}
