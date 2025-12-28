package com.battlegame.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //通过lombok里面的工具，自动实现一些get、tostring等基本操作
@NoArgsConstructor //无参构造
@AllArgsConstructor //有参构造
public class User {
    private Integer id;
    private String username;
    private String password;
}
