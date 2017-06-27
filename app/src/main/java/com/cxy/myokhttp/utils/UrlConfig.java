package com.cxy.myokhttp.utils;

public class UrlConfig {

//    public static final String XMPP_CONN_IP = "192.168.1.245";
//    public static final String HOST_MOM = "http://192.168.1.244:8686";
//    public static final String HOST_SNS = "http://192.168.1.244:8686";
//    public static final String HOST_USER_PLATFORM = "http://192.168.1.244:8686";
    //   本地调试
//      public static final String HOST_MOM = "http://192.168.1.136:8080";
    // 外网
public static final String XMPP_CONN_IP = "im.yunbaober.cn";
    public static final String HOST_MOM = "http://www.yunbaober.cn:8686" ;
    public static final String HOST_SNS = "http://www.yunbaober.cn:8686";
    public static final String HOST_USER_PLATFORM = "http://www.yunbaober.cn:8686";
//    public static final String XMPP_CONN_IP = BuildConfig.IS_OUTERNET ? "im.yunbaober.cn" : "192.168.1.245";
//    public static final String HOST_MOM = BuildConfig.IS_OUTERNET ? "http://www.yunbaober.cn:8686" : "http://192.168.1.244:8686";
//    public static final String HOST_SNS = BuildConfig.IS_OUTERNET ? "http://www.yunbaober.cn:8686" : "http://192.168.1.244:8686";
//    public static final String HOST_USER_PLATFORM = BuildConfig.IS_OUTERNET ? "http://www.yunbaober.cn:8686" : "http://192.168.1.244:8686";

//    public static final String HOST_MOM = " http://thgk.xicp.net:8686";
//    public static final String HOST_SNS = " http://thgk.xicp.net:8686";
//    public static final String HOST_USER_PLATFORM = "http://thgk.xicp.net:8686";

    public static final String HOST_MOM_URL = HOST_MOM + "/mom";
    public static final String HOST_NC_URL = HOST_MOM + "/nc";
    public static final String HOST_DOCTOR_URL = HOST_MOM + "/doctor";
    public static final String HOST_MOM_PHOTO_URL = HOST_MOM + "/mom";
    public static final String HOST_SNS_URL = HOST_SNS + "/sns_doctor";
    public static final String HOST_SNS_PHOTO_URL = HOST_SNS + "/sns_doctor";
    public static final String HOST_USER_PLATFORM_URL = HOST_USER_PLATFORM + "/UserPlatform";
    //public static final String HOST_USER_PLATFORM_URL = HOST_USER_PLATFORM + "/UserPlatform";


    /**
     * 1
     * 上传附件 url.(帖子用、提问可用)
     */
    public static final String UploadFileUrl = HOST_SNS_URL + "/api/public/upload";

    /**
     * 2
     * 上传附件 url.音频
     */
    public static final String UploadVoiceFileUrl = HOST_MOM + "/mom/api/public/upload";

    /**
     * 2
     * 上传附件 url.视频
     */
    public static final String UploadVideoFileUrl = HOST_MOM + "/mom/api/public/upload";
    /**
     * 3
     * 上传附件 url.聊天专用
     */
    public static final String UploadFileUrlToChat = HOST_MOM + "/mom/api/public/upload";

    /**
     * 4
     * 上传头像
     */
    public static final String URL_UPLOAD_HEAD = HOST_USER_PLATFORM
            + "/UserPlatform/public/upload/";
    /**
     * 5
     * 更新新头像
     */
    public static final String URL_UPDATE_HEAD = HOST_USER_PLATFORM
            + "/UserPlatform/api/user/updateAvatar";

    /**
     * 6
     * 聊天
     *
     * @return
     */
    public static final String ChatUpFileBase = HOST_MOM + "/mom";
    /**
     * 16
     * 获取检查报告列表
     */
    public static final String URL_GET_CHECKREPORT = HOST_MOM + "/mom/api/checkReport/findList";
    /**
     * 17
     * 检查报告列表详情
     */
    public static final String URL_GET_CHECKREPORT_DETAILS = HOST_MOM + "/mom/api/checkReport/getDetail";

    /**
     * 18
     * 获取咨询会话就诊人信息
     */
    public static final String URL_GET_PATIONT_DETAILS = HOST_DOCTOR_URL + "/api/zxSession/patientHistorybySession";

    /**
     * 19
     * 获取咨询会话就诊人信息
     */
    public static final String URL_GET_ZX_SESSION_STATE = HOST_DOCTOR_URL + "/api/zxSession/status";

    /**
     * 20
     * 查询咨询业务状态等信息
     */
    public static final String URL_STOP_CHART_PATIONTS = HOST_DOCTOR_URL + "/api/zxSession/stop";
    /**
     * 登陆
     */
    public static final String URL_LOGIN = HOST_USER_PLATFORM + "/UserPlatform/api/user/signUpNoOrg";
    /**
     * 医生详情
     */
    public static final String DoctorDetails = HOST_USER_PLATFORM + "/doctor/api/doctor/findById";
    /**
     * 订单列表
     */
    public static final String MyOrderList = HOST_DOCTOR_URL + "/api/order/myOrderList";
    /**
     * 订单详情
     */
    public static final String MyOrderDetails = HOST_USER_PLATFORM + "/doctor/api/order/findById";
    /**
     * 评论列表
     */
    public static final String MyCommentList = HOST_USER_PLATFORM + "/doctor/api/comment/findList";
    /**
     * 获取订单评价
     */
    public static final String OrderComment = HOST_USER_PLATFORM + "/doctor/api/comment/findByOrderId";
    /**
     * 意见反馈列表
     */
    public static final String FeedBackList = HOST_USER_PLATFORM + "/mom/api/feedBack/list";
    /**
     * 意见反馈回复列表
     */
    public static final String FeedBackreplyList = HOST_USER_PLATFORM + "/mom/api/feedBack/replayList";
    /**
     * 意见反馈回复
     */
    public static final String FeedBackreply = HOST_USER_PLATFORM + "/mom/api/feedBack/replay";
    /**
     * 添加意见反馈
     */
    public static final String FeedBackAdd = HOST_USER_PLATFORM + "/mom/api/feedBack/add";
    /**
     * 医生TOP列表
     */
    public static final String DoctorTopList = HOST_USER_PLATFORM + "/doctor/api/doctor/findList";
    /**
     * 获取手机号验证码
     */
    public static final String PhoneVerificationCode = HOST_MOM + "/doctor/api/validate/";//{mobile}
    /**
     * 修改密码的地址
     */
    public static final String ChangeUserPwd = HOST_USER_PLATFORM + "/UserPlatform/api/user/modifyPassword";
    /**
     * 版本更新
     */
    public static final String URL_UPDATEVERSION = HOST_MOM_URL + "/api/version";//{"/" + version + "/" + name + "/" + sign};
    /**
     * 在线课堂轮播图
     */
    public static final String OnlineClassMarquee = HOST_DOCTOR_URL + "/api/onlineClassMarquee/findList";
    /**
     * 点播视频列表
     */
    public static final String VideoListURL = HOST_DOCTOR_URL + "/api/doc/video/list";
    /**
     * 专家互动列表
     */
    public static final String URL_ZHUANJIAINTERACT_LIST = HOST_DOCTOR_URL + "/api/doc/zhuanJiaInteract/list";
    /**
     * 专家互动详情
     */
    public static final String URL_ZHUANJIAINTERACT_DETAIL = HOST_DOCTOR_URL + "/api/doc/zhuanJiaInteract/detial/";
    /**
     * 专家讲义
     */
    public static final String URL_ZHUANJIAJIANGYI_DETAIL = HOST_DOCTOR_URL + "/api/doc/zhuanJiaInteract/notes";
    /**
     * 专家互动报名
     */
    public static final String URL_ZHUANJIA_USERJOIN = HOST_DOCTOR_URL + "/api/doc/zhuanJiaInteract/apply";
    /**
     * DOCTOR收藏
     */
    public static final String URL_ZHUANJIAINTERACT_COLLECTION = HOST_DOCTOR_URL + "/api/collection/create";
    /**
     * DOCTOR取消收藏
     */
    public static final String URL_CANNEL_COLLECTED = HOST_DOCTOR_URL + "/api/collection/remove";
    /**
     * 分享专家互动
     */
    public static final String URL_ZHUANJIAINTERACT_SHARE = HOST_DOCTOR_URL + "/api/doc/zhuanJiaInteract/share/";
    /**
     * 获取用户经验
     */
    public static final String URL_USER_EXP = HOST_USER_PLATFORM + "/UserPlatform/api/integral";
    /**
     * 订阅圈子
     */
    public static final String MyCircleDataBaseUrl = HOST_SNS_URL + "/api/sns/";

    /**
     * 轮播图
     */
    public static final String URL_MARQUEE = HOST_MOM + "/mom/api/marquee";

    /**
     * 热门帖子
     */
    public static final String CictorHomeHotLetter = HOST_SNS_URL + "/api/post/hotPosts";
    /**
     * 公司创建的科室列表
     */
    public static final String URL_GET_OFFICE_LIST = HOST_MOM + "/UserPlatform/api/units/findCommonList";
    /**
     * 发帖url
     */
    public static final String PublishLetterUrl = HOST_SNS_URL + "/api/post/create";
    /**
     * 热门搜索关键字
     */
    public static final String LetterHotSearchWrods = HOST_SNS_URL + "/api/post/hotSearch";
    /**
     * 帖子分类
     */
    public static final String LetterCategorys = HOST_SNS_URL + "/api/post/postCategorys";
    /**
     * 帖子搜索： http://182.150.22.47:7101/sns/api/post/sns keyword String 关键字
     * pageNo Integer 页码 pageSize Integer 每页显示条数 snsId String 可选-搜索该圈子下的帖子
     */
    public static final String URL_TIEZI_SEARCH = HOST_SNS_URL + "/api/post/sns";
    /**
     * 专题头部
     */
    public static final String SpecialSubHead = HOST_SNS_URL + "/api/post/topic";

    /**
     * 订阅圈子
     */
    /**
     * 专题帖子列表api/post/topicPosts
     */
    public static final String SpecialSubList = HOST_SNS_URL + "/api/post/topicPosts";
    /**
     * 联系人列表
     */
    public static final String ContactsList = HOST_MOM + "/UserPlatform/api/friend/findAll";
    /**
     * 获取好友列表
     */
    public static final String URL_GET_FRIENDS_LIST = HOST_USER_PLATFORM_URL + "/api/friend/findAll";
    /**
     * 添加还有
     */
    public static final String URL_ADD_NEW_FRIENDS = HOST_USER_PLATFORM_URL + "/api/friend/addFriend";
    /**
     * 好友详情
     */
    public static final String URL_FRIENDS_DETAIL = HOST_USER_PLATFORM_URL + "/api/friend/findById";
    /**
     * 发表点评 post
     */
    public static final String PublishCommentUrl = HOST_SNS_URL + "/api/post/comment";
    /**
     * 帖子和评论点赞
     */
    public static final String LetterDianZan = HOST_SNS_URL + "/api/post/support";
    public static final String URL_FRIENDS_VALID = HOST_USER_PLATFORM_URL + "/api/friend/validFriend";
    /**
     * 获取视频详情
     */
    public static final String VideoDetails = HOST_DOCTOR_URL + "/api/doc/video/detial/";
    /**
     * 金币支付
     */
    public static final String GlodPay = HOST_DOCTOR_URL + "/api/doc/video/payIntegral";
    /**
     * 创建订单
     */
    public static final String OrderSave = HOST_DOCTOR_URL + "/api/order/save";
    /**
     * 取消订单
     */
    public static final String OrderCancel = HOST_DOCTOR_URL + "/api/order/cancel";
    /**
     * 微信预支付订单接口
     */
    public static final String WeChatCallbackUrl = HOST_DOCTOR_URL + "/api/order/weixin/";//{orderId}
    /**
     * 咨询业务状态
     */
    public static final String URL_SESSION_STATUS = HOST_MOM + "/doctor/api/zxSession/status";
    /**
     * 视频点播分享
     */
    public static final String URL_VIDEO_SHARE = HOST_DOCTOR_URL + "/api/doc/video/share/";
    /**
     * 删除好友请求信息
     */
    public static final String URL_DELET_NEW_FRIEND_ASK = HOST_USER_PLATFORM_URL + "/api/friend/removeValidFriend";
    /**
     * 删除好友
     */
    public static final String URL_DELET_FRIEND_URL = HOST_USER_PLATFORM_URL + "/api/friend/removeFriend";
    /**
     * 获取用户信息
     */
    public static final String URL_GET_DOC_USERINFO = HOST_USER_PLATFORM_URL + "/api/friend/findByUserName";
    /**
     * 验证好友关系 	/api/friend/checkFriend
     */
    public static final String URL_CHECK_FRIEND = HOST_USER_PLATFORM_URL + "/api/friend/checkFriend";
    /**
     * 专家互动
     */
    public static final String HomeZhuanjiaInteract = HOST_DOCTOR_URL + "/api/doc/zhuanJiaInteract/home";
    /**
     * 文献库分类
     */
    public static final String DocumentLibCategory = HOST_DOCTOR_URL + "/api/category/categories";
    /**
     * 文献库列表
     */
    public static final String DocumentLibList = HOST_DOCTOR_URL + "/api/literature/findList";
    /**
     * 文献库详情
     */
    public static final String DocumentLibDetails = HOST_DOCTOR_URL + "/api/literature/findById";
    /**
     * 文献库分享url
     */
    public static final String DocumentLibShare = HOST_DOCTOR_URL + "/api/literature/share";
    /**
     * 我的收藏
     */
    public static final String URL_MY_COLLECT_DOCTOR = HOST_DOCTOR_URL + "/api/collection/list";
    /**
     * 21
     * 获取检查报告项目说明
     */
    public static String CheckReport_DetailItemDescription_URL = HOST_MOM
            + "/mom/api/checkReport/getDetailItemDescription";
    /**
     * 获取圈子下，全部帖子 基地址: 还需要 snsId、pageNo、pageSize
     */
    public static String BaseCircleAllLetterUrl = HOST_SNS_URL
            + "/api/post/sns";
    /**
     * 获取圈子下，我的帖子: 还需要 snsId、pageNo、pageSize
     */
    public static String BaseCircleMyLetterUrl = HOST_SNS_URL
            + "/api/post/posts";
    /**
     * 获取圈子下，精华帖子 基地址: 还需要 snsId、pageNo、pageSize
     */
    public static String BaseCircleMarrowLetterUrl = HOST_SNS_URL
            + "/api/post/sns/essences";
    /**
     * 8
     * 我的钱包
     */
    public static String URL_WALEET_INFO = HOST_DOCTOR_URL + "/api/wallet/findByDoctorId";
    /**
     * 9
     * 绑定银行卡
     */
    public static String URL_BIND_BANK = HOST_DOCTOR_URL + "/api/wallet/bindBank";
    /**
     * 10
     * 收支记录
     */
    public static String URL_INCOME_RECODE = HOST_DOCTOR_URL + "/api/daybook/findByMonth";
    /**
     * 11
     * 修改医生设置
     */
    public static String URL_DOCTOR_ZX_SET = HOST_DOCTOR_URL + "/api/doctorZxSetting/save";
    /**
     * 12
     * 获取手机号验证码
     */
    public static String URL_MOBILE_GETVERIFY_CODE = HOST_MOM + "/doctor/api/validate/";
    /**
     * 13
     * 申请提现
     */
    public static String URL_APPLY_TAKE_MONEY = HOST_DOCTOR_URL + "/api/withdraw/applyWithdraw";
    /**
     * 14
     * 分页获取医生端病历
     */
    public static String URL_DOCTOR_S_PATIENTS = HOST_DOCTOR_URL + "/api/zxSession/patientHistory";
    /**
     * 15
     * 获取就诊人详细信息
     */
    public static String URL_GET_PATIENTS_INFO = HOST_DOCTOR_URL + "/api/patients/info";
    /**
     * 圈子分类的标题
     */
    public static String URL_CIRCLE_TITLE = HOST_SNS_URL + "/api/category/categories";

    /**
     * 帖子详情
     */
    public static String getLetterDetailUrl(String postId) {
        return HOST_MOM + "/sns/api/post/info?postId=" + postId;
    }

    /**
     * 帖子详情(需要登录) if token =null means not need token(login)
     */
    public static String getLetterDetailUrl(String token, String postId) {
        if (token == null)
            return getLetterDetailUrl(postId);
        else {
            return HOST_SNS_URL + "/api/post/info/token?postId=" + postId
                    + "&token=" + token;
        }
    }

    /**
     * 7
     * 孕育 问答 图片访问基地址 //192.168.253.236:8080/sns/
     *
     * @return
     */
    public static String getBasePic() {
        return HOST_MOM + "/sns";
    }

    /**
     * 按分类获取圈子数据
     */
    public static String getCircleDataBaseUrl(String token) {
        String baseUrl;
        if (token == null) {
            baseUrl = HOST_SNS_URL + "/api/sns/categoryId";
        } else {
            baseUrl = HOST_SNS_URL + "/api/sns/categoryId/token";
        }
        return baseUrl;
    }

    /**
     * 删除帖子 token String 用户令牌 postId sns/api/post/delPost
     */
    public static final String URL_DEL_LETTER = HOST_SNS_URL + "/api/post/delPost";
    /**
     * 删除帖子评论 /api/post/delComment commentId
     */
    public static final String URL_DEL_LETTER_COMMENT = HOST_SNS_URL + "/api/post/delComment";
    //帖子分享
    public static final String URL_SHARE_LETTER = HOST_SNS_URL + "/api/post/share/";

    /**
     * 我发表的帖子 get (token,pageNo,pageSize)
     */
    public static final String MyPublishLetterUrl = HOST_SNS_URL + "/api/post/posts";
    /**
     * 我回复的帖子 get (token,pageNo,pageSize)
     */
    public static final String MyReplyLetterUrl = HOST_SNS_URL + "/api/post/replies";
    /**
     * 无效咨询
     */
    public static final String URL_SET_ZIXUN_INVALID = HOST_DOCTOR_URL + "/api/zxSession/invalid";
    /**
     * 医生回复咨询
     */
    public static final String URL_DOC_ZXSESSION_REPLY = HOST_DOCTOR_URL + "/api/zxSession/reply";

    /**
     * 会话界面头部胎监数据列表
     */
    public static final String URL_DOC_FHR_REPORT_LIST = HOST_MOM_URL + "/api/fhr/tmpFhrReportList";

    public static final String NoteDetailUrl = HOST_MOM_URL + "/api/fhr/findById";
    /**
     * 接诊用户胎监报告(抢单) /api/fhr/robOrder
     */
    public static final String URL_DOC_FHR_ROB_ORDER = HOST_MOM_URL + "/api/fhr/robOrder";
    /**
     * 医生回复胎监报告咨询
     */
    public static final String URL_DOC_FHR_DOC_REPLY = HOST_MOM_URL + "/api/fhr/reply";

    /**
     * 胎监咨询会话
     * /api/zxSession/fhrsession
     */
    public static final String URL_DOC_FHR_SESSION = HOST_DOCTOR_URL + "/api/zxSession/fhrsession";
    /**
     * 医生端获取咨询的胎监报告数据列表
     * /api/fhr/myFhrReportList
     */
    public static final String URL_DOC_FHR_MY_REPORT_LIST = HOST_MOM_URL + "/api/fhr/myFhrReportList";

    /**
     * 检查报告不分页获取
     */
    public static String GetCheckReportFindListWithNotPage=HOST_MOM+"/mom/api/checkReport/findListWithNotPage";
    /**
     * 手动上传检查报告的详情
     */
    public static String HandlerUploadCheckReportDetails=HOST_MOM+"/mom/api/myReport/findById";

    /**
     * 获取胎动数据
     */
    public static String FindQuickeningList = HOST_MOM + "/mom/api/fhr/findQuickeningList";

    /**
     * 胎监记录列表
     */
    public static String StatisticsRecords = HOST_MOM + "/mom/api/fhr/findList";

    /**
     * 会话列表
     */
    public static final String URL_SESSION_LIST = HOST_MOM + "/doctor/api/zxSession/list";

    public static final String NoteListUrl = HOST_MOM + "/mom/api/fhr/findList";

    /**
     * 获取首页孕妇信息
     */
    public static String getHpMotherInfoUrl=HOST_MOM + "/mom/api/mother/motherInfo";
    /*****************************************V4.4******************************************************/
    /**
     * 获取容云token
     */
    public static String URL_GET_RONGYUN_TOKEN = HOST_MOM + "/doctor/api/thrid/rc/token";

    /**
     * 网络诊间PersonalInfo获取个人情况
     */
    public static String URL_GET_PERSONAL_INFO = HOST_DOCTOR_URL + "/api/personal/getPersonalInfo";

    /**
     * 获取医生排班时间/doctor/api/doctorNcSchedule/info
     */
    public static String URL_GET_DOCTOR_SCHEDULE = HOST_DOCTOR_URL + "/api/doctorNcSchedule/info";

    /**
     * 拉取医生排班信息
     */
    public static String URL_GET_DOCTOR_SCHEDULE_EVERYDAY = HOST_DOCTOR_URL + "/api/doctorNcSchedule/list";
    /**
     * 添加医生排班信息/doctor/api/doctorNcSchedule/save
     */
    public static String URL_ADD_DOCTOR_SCHEDULE = HOST_DOCTOR_URL + "/api/doctorNcSchedule/save";
    /**
     * 药品分类接口
     */
    public static String URL_GET_MEDICS_CLASSIFY = HOST_DOCTOR_URL + "/api/medicineCategory/category/";
    /**
     * 检验检查分类接口
     */
    public static String URL_GET_CHECKS_CLASSIFY = HOST_DOCTOR_URL + "/api/examineCategory/category";
    /**
     * 检查检验列表
     */
    public static String URL_GET_CHECK_LIST = HOST_DOCTOR_URL + "/api/examine/list";
    /**
     * 获取当天预约列表/doctor/api/yuyue/curlist
     */
    public static String URL_GET_TODAY_ORDERED_LIST = HOST_DOCTOR_URL + "/api/yuyue/curlist";
    /**
     * 保存检验检查模板 /doctor/api/examineTemplate/saveOrUpdate
     */
    public static String URL_SAVE_CHECK_MOUDLE = HOST_DOCTOR_URL + "/api/examineTemplate/saveOrUpdate";
    /**
     * 检验检查的模板列表
     */
    public static String URL_GET_CHECK_MOUDLE_LIST = HOST_DOCTOR_URL + "/api/examineTemplate/list";
    /**
     * 检查检验模板详情
     */
    public static String URL_GET_CHECK_MOUDLE_DETAIL = HOST_DOCTOR_URL + "/api/examineTemplate/findById/";

    /**
     * 删除检验检查模板
     */
    public static String URL_GET_CHECK_MOUDLE_DELETE = HOST_DOCTOR_URL + "/api/examineTemplate/del";
    /**
     * 保存医嘱/doctor/api/yuyue/doctorAdvice
     */
    public static String URL_SAVE_DOCTOR_ORDERS = HOST_DOCTOR_URL + "/api/yuyue/doctorAdvice";
    /**
     * 诊断详细信息DiagnoYuyueID
     */
    public static String URL_GET_DIAGNOYYUE_ID = HOST_DOCTOR_URL + "/api/yuyue/detail/";

    /**
     * 保存预约检验检查 /doctor/api/yuyue/saveOrUpdate
     */
    public static String URL_SAVE_YYUE_CHECK_LIST = HOST_DOCTOR_URL + "/api/yuyue/saveOrUpdate";

    /**
     * 根据预约ID查询检验检查doctor/api/yuyue/findByYyid/
     */
    public static String URL_GET_YYUE_CHECK_LIST = HOST_DOCTOR_URL + "/api/yuyue/findByYyid/";
    /**
     * prescription
     * 保存药品处方/doctor/api/recipe/save
     */
    public static String URL_SAVE_MEDIC_PRESCRIPTION = HOST_DOCTOR_URL + "/api/recipe/save";
    /**
     * 根据预约id获取处方药品信息/doctor/api/recipe/detail/
     */
    public static String URL_GET_PRESCRIPTION_BY_YUYUEID = HOST_DOCTOR_URL + "/api/recipe/detail/";
    /**
     * 是否需要处方签名
     */
    public static String URL_GET_ISNEED_AUTOGRAPH_BY_YUYUEID = HOST_DOCTOR_URL + "/api/recipe/checkCompleteAble/";
    /**
     * 保存处方模板api/recipeTemp/save
     */
    public static String URL_SAVE_PRESCRIPTION_MOUDLE = HOST_DOCTOR_URL + "/api/recipeTemp/save";
    /**
     * 获取处方模板药品 /api/recipeTemp/detail/{tempId}
     */
    public static String URL_GET_MEDIC_FROM_PRESCRIPTION_MOUDLE = HOST_DOCTOR_URL + "/api/recipeTemp/detail/";
    /**
     * 分页获取处方模板列表 /api/recipeTemp/list
     */
    public static String URL_GET_PRESCRIPTION_MOUDLES_LIST = HOST_DOCTOR_URL + "/api/recipeTemp/list";
    /**
     * 删除模板 /doctor/api/recipeTemp/del/{tempId}
     */
    public static String URL_DEL_PRESCRIPTION_MOUDLE_BYID = HOST_DOCTOR_URL + "/api/recipeTemp/del/";
    /**
     * 完成预约 /doctor/api/yuyue/finished
     */
    public static String URL_DOC_COMMIT_DIAGNOSIS_AND_FINISH = HOST_DOCTOR_URL + "/api/yuyue/finished";
    /**
     * 获取药品详情 d/api/medicine/findById  /api/medicine/findListHtml
     */
    public static String URL_DOC_FIND_MEDIC_BY_CLASSIFYID = HOST_DOCTOR_URL + "/api/medicine/findById";
    /**
     * 获取所有药品列表
     */
    public static String URL_DOC_GET_ALL_MEDICS = HOST_DOCTOR_URL + "/api/medicine/list";
    /**
     * 药品用法选项
     */
    public static String URL_DOC_GET_MEDICS_USAGES = HOST_DOCTOR_URL + "/api/personalInfoCategory/category/";
    /**
     * 分页获取预约用户
     */
    public static String URL_GET_ALL_ORDERED_LIST = HOST_DOCTOR_URL + "/api/yuyue/list";
    /**
     * 获取用户在线状态
     */
    public static String URL_CHECK_IS_PATIONT_ONLINE = HOST_DOCTOR_URL + "/api/thrid/rc/checkOnline/";
    /**
     * 医生端拨打用户视频回调
     */
    public static String URL_SET_STATE_REMIND_DOC_CALLED_PATIONT = HOST_DOCTOR_URL + "/api/yuyue/called";
    /**
     * 医生调用短信接口提醒用户登录
     */
    public static String URL_POST_NOTIFY_MSG_TO_PATIONT = HOST_DOCTOR_URL + "/api/yuyue/sms/";
    /**
     * 获取诊断集
     */
    public static String URL_GET_DIAGNOSE_LIST = HOST_DOCTOR_URL + "/api/diagnose/list";
}