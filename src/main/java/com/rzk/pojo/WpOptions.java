package com.rzk.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2022-07-28
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("wp_options")
public class WpOptions {
    /**
     * 
     */
	@TableId(value = "option_id", type = IdType.AUTO)
	private Long optionId;
    /**
     * 
     */
	@ApiModelProperty(value = "设置名")
	private String optionName;
    /**
     * 
     */
	@ApiModelProperty(value = "设置值")
	private String optionValue;
    /**
     * 
     */
	@ApiModelProperty(value = "自动加载")
	private String autoload;
}