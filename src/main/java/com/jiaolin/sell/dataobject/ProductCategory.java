package com.jiaolin.sell.dataobject;

import com.sun.scenario.effect.Identity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Entity 与实体表对应
 * DynamicUpdate 动态的更新时间
 * Data 用来进行get,set,toString方法的缩写
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

	/**
	 * 商品id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	/**
	 * 商品名字
	 */
	private String categoryName;
	/**
	 * 商品类型
	 */
	private Integer categoryType;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public ProductCategory(String categoryName, Integer categoryType) {
		this.categoryName = categoryName;
		this.categoryType = categoryType;
	}

	public ProductCategory() {
	}
}
