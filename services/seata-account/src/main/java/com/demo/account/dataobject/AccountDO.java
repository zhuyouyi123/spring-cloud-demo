package com.demo.account.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("account")
public class AccountDO {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String gender;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
