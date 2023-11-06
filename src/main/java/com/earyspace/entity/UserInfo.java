package com.earyspace.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_info")
public class UserInfo {

    @TableId()
    @TableField("user_id")
    private String userId;

    @TableField("password")
    private String password;

    @TableField("nick_name")
    private String nickName;

    @TableField("email")
    private String email;

    @TableField("avatar")
    private String avatar;

    @TableField("join_time")
    private Date joinTime;

    @TableField("last_login_time")
    private Date lastLoginTime;

    @TableField("status")
    private byte status;

}
