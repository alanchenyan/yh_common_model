package com.yh.common.model.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yh.common.model.user.entity.base.BaseEntity;
import com.yh.common.model.user.entity.enums.ClientSourceEnum;
import com.yh.common.model.user.entity.enums.SexTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author Alan Chen
 * @description App用户
 * @date 2020-01-02
 */
@Data
public class User extends BaseEntity {

    @ApiModelProperty("会员等级ID")
    private String memberGradeId;

    @NotBlank(message = "area_code_not_empty")
    @ApiModelProperty("区号")
    private String areaCode;

    @NotBlank(message = "phone_not_empty")
    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("中文名")
    private String chineseName;

    @ApiModelProperty("英文名")
    private String englishName;

    @ApiModelProperty("昵称")
    private String nickName;

    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    @ApiModelProperty("性别（请传数字）")
    private SexTypeEnum sex;

    @ApiModelProperty("积分")
    private Long integral;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("头像")
    private String headerAvatar;

    @ApiModelProperty("相册封面")
    private String coverImage;

    @ApiModelProperty("邮箱")
    private String email;

    @JSONField(format="yyyy-MM-dd")
    @ApiModelProperty("生日")
    private Date birthday;

    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    @ApiModelProperty("注册途径")
    private ClientSourceEnum registSource;

}
