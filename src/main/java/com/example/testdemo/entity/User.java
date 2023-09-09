package com.example.testdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_info")
public class User {

    /** 用户id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "address")
    /** 地址 */
    private String address;

    /** 创建时间 */
    private String createAt;

    /** 性别 */
    private String gender;

    /** 头像 */
    private String imageUrl;

    /** 用户余额 */
    private BigDecimal jifen;

    /** 用户名称 */
    private String name;

    /** 昵称 */
    private String nickName;

    private String openId;

    private String openUid;

    /** 电话 */
    private String phone;

    /** 密码 */
    private String pwd;

    /** 会员id */
    private String relationId;

    /** 状态 */
    private String state;

    /** 支付宝账号 */
    private String zhifubao;

    /** 支付宝昵称 */
    private String zhifubaoName;

    /** 分销比例 */
    private String grade;

    /** 邀请人邀请码 */
    private String invitation;

    /** 邀请结算状态 */
    private Integer balance;

    private Integer isInvitation;

    /** 积分 */
    private BigDecimal orderJifen;

    private String platform;

    /** 京东pid */
    private String jd;

    /** 拼多多pid */
    private String pdd;

    /** 小程序id */
    private String mpId;

    /** 是否是会员 */
    private Integer isRelation;

    /** 是否是团长 */
    private Integer isTuan;

    /** 等级描述 */
    private String gradeDes;

    /** 邀请了几人 */
    private String gradeIndex;

    /** 还差几人 */
    private String gradeNumber;

    /** 淘宝id */
    private String tbOpenid;

    /** 微信公众id */
    private String unionid;

    /** 消息推送id */
    private String clientid;

    /** 六位邀请码 */
    private String invitationCode;

    /** 苹果id */
    private String appleUserId;

    /** 是否是系统用户 */
    private String isSysUser;

    private String whp;

    private String wxImg;

    /** 销售等级 */
    private String rankLevel;

    /** 套餐等级 */
    private String rankPackageLevel;

    /** 销售量 */
    private Integer salesNum;

    /** 销售业绩 */
    private BigDecimal salesMoney;

    /** 推荐链（-a-b-c-) */
    private String parentLink;

    /** 我的销量 */
    private Integer mySalesNum;

    /** 是否公点位 */
    private Integer isPublicPoint;

    private Integer teamMembersCount;

    private Integer isNoBonusDay;

    private Integer cashLimitNum;

    @Version
    private Integer version;

}