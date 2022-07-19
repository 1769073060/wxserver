package com.rzk.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Rzk
 * @since 2022-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="WxResource对象", description="")
public class WxResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "创建者")
    private String createMaster;

    @ApiModelProperty(value = "url地址")
    private String url;

    @ApiModelProperty(value = "uri地址")
    private String uri;

    @ApiModelProperty(value = "提取码")
    private String fetchCode;

    @ApiModelProperty(value = "文件名")
    private String fileName;

    @ApiModelProperty(value = "目录名")
    private String directoryName;

    @ApiModelProperty(value = "系统版本")
    private String systemVersion;

    @ApiModelProperty(value = "是否失效:0否1是")
    private Integer failureType;

    @ApiModelProperty(value = "生成二维码")
    private String qrCode;

    @ApiModelProperty(value = "pdf")
    private String pdf;

    @ApiModelProperty(value = "使用次数")
    private String userNumber;

    @ApiModelProperty(value = "逻辑删除:0未删除1已删除")
    private Integer deleted;

    @ApiModelProperty(value = "修改时间")
    private Long updateTime;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "下载源:1.百度云,2蓝奏云")
    private String downloadSource;

    @ApiModelProperty(value = "微信文章地址")
    private String articleAddresses;
}
