package com.demo.account.controller;

import com.demo.account.dataobject.AccountDO;
import com.demo.account.mapper.AccountMapper;
import com.demo.account.pojo.AccountAddDTO;
import com.demo.model.common.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("account")
public class AccountController {

    @Resource
    private AccountMapper accountMapper;

    @GetMapping("{id}")
    public R get(@PathVariable("id") String id) {
        AccountDO accountDO = accountMapper.selectById(id);
        return R.ok(accountDO);
    }

    @PostMapping("add")
    public R add(@RequestBody AccountAddDTO addDTO) {
        AccountDO accountDO = new AccountDO();
        accountDO.setUsername(addDTO.getUsername());
        accountDO.setCreateTime(LocalDateTime.now());
        accountDO.setUpdateTime(LocalDateTime.now());
        accountDO.setGender(addDTO.getGender());
        accountMapper.insert(accountDO);
        return R.ok();
    }
}
