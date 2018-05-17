package com.jiaolin.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class SellInfo {

	@Id
	private String id;
	//用户名
	private String username;
	//密码
	private String password;

	//微信openid
	private String openid;

	private Date createTime;

	private Date updateTime;

}
