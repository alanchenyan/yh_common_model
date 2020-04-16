package com.yh.common.model.user.app.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Alan Chen
 * @description 用户反馈
 * @date 2020-01-14
 */
@Data
public class UserFeedbackAddVO {

    @NotBlank(message = "user_id_not_empty")
    @ApiModelProperty("用户ID")
    private String userId;

    @NotBlank(message = "feedback_message_not_empty")
    @ApiModelProperty("用户反馈意见")
    private String feedbackMessage;
}
