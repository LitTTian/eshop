package com.lrz.eshop.common;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
 * @author 天天
 * @create 2023/3/7 3:16
 * @description
 */
public class ConstantResultCode implements ConstantBase<String> {
    /**
     * 一切 ok
     */
    public static final String SUCCESS = "00000";

    /**
     * 用户端错误 一级宏观错误码
     */
    public static final String ERROR_CLIENT = "A0001";

    /**
     * 用户注册错误 二级宏观错误码
     */
    public static final String ERROR_CLIENT_REGISTER = "A0100";

    /**
     * 用户未同意隐私协议
     */
    public static final String ERROR_CLIENT_NOT_AGREE = "A0101";
    /**
     * 注册国家或地区受限
     */
    public static final String ERROR_CLIENT_REGION_LIMIT = "A0102";

    /**
     * 用户名校验失败
     */
    public static final String ERROR_CLIENT_USERNAME_FAIL = "A0110";

    /**
     * 用户名已存在
     */
    public static final String ERROR_CLIENT_USERNAME_EXISTS = "A0111";
    /**
     * 用户名包含敏感词
     */
    public static final String ERROR_CLIENT_ILLEGAL_WORD = "A0112";
    /**
     * 用户名包含特殊字符
     */
    public static final String ERROR_CLIENT_SPECIAL_CHARACTER = "A0113";

    /**
     * 密码校验失败
     */
    public static final String ERROR_CLIENT_PASSWORD_FAIL = "A0120";

    /**
     * 密码长度不够
     */
    public static final String ERROR_CLIENT_PASSWORD_LENGTH_NOT_ENOUGH = "A0121";

    /**
     * 密码强度不够
     */
    public static final String ERROR_CLIENT_PASSWORD_STRENGTH_NOT_ENOUGH = "A0122";

    /**
     * 校验码输入错误
     */
    public static final String ERROR_CLIENT_CHECKCODE_INPUT_ERROR = "A0130";

    /**
     * 短信校验码输入错误
     */
    public static final String ERROR_CLIENT_SMS_CHECKCODE_INPUT_ERROR = "A0131";

    /**
     * 邮件校验码输入错误
     */
    public static final String ERROR_CLIENT_EMAIL_CHECKCODE_INPUT_ERROR = "A0132";

    /**
     * 语音校验码输入错误
     */
    public static final String ERROR_CLIENT_VOICE_CHECKCODE_INPUT_ERROR = "A0133";

    /**
     * 用户证件异常
     */
    public static final String ERROR_CLIENT_CERTIFICATE_ABNORMAL = "A0140";

    /**
     * 用户证件类型未选择
     */
    public static final String ERROR_CLIENT_CERTIFICATE_TYPE_UNSELECTED = "A0141";

    /**
     * 大陆身份证编号校验非法
     */
    public static final String ERROR_CLIENT_IDCARD_ILLEGAL = "A0142";

    /**
     * 护照编号校验非法
     */
    public static final String ERROR_CLIENT_PASSPORT_ILLEGAL = "A0143";

    /**
     * 军官证编号校验非法
     */
    public static final String ERROR_CLIENT_MILITARY_ID_NUMBER_ILLEGAL = "A0144";

    /**
     * 用户基本信息校验失败
     */
    public static final String ERROR_CLIENT_BASIC_INFORMATION_FAIL = "A0150";

    /**
     * 手机格式校验失败
     */
    public static final String ERROR_CLIENT_PHONE_FORMAT_FAIL = "A0151";

    /**
     * 地址格式校验失败
     */
    public static final String ERROR_CLIENT_ADDRESS_FORMAT_FAIL = "A0152";

    /**
     * 邮箱格式校验失败
     */
    public static final String ERROR_CLIENT_EMAIL_FORMAT_FAIL = "A0153";

    /**
     * 用户登录异常   二级宏观错误码
     */
    public static final String ERROR_CLIENT_LOGIN_ABNORMAL = "A0200";

    /**
     * 用户账户不存在
     */
    public static final String ERROR_CLIENT_ACCOUNT_NOTEXIST = "A0201";

    /**
     * 用户账户被冻结
     */
    public static final String ERROR_CLIENT_ACCOUNT_FREEZE = "A0202";

    /**
     * 用户账户已作废
     */
    public static final String ERROR_CLIENT_ACCOUNT_INVALID = "A0203";

    /**
     * 用户密码错误
     */
    public static final String ERROR_CLIENT_PASSWORD_ERROR = "A0210";

    /**
     * 用户输入密码错误次数超限
     */
    public static final String ERROR_CLIENT_PASSWORD_ERROR_TIMES_OVERRUN = "A0211";

    /**
     * 用户身份校验失败
     */
    public static final String ERROR_CLIENT_IDENTITY_FILE = "A0220";

    /**
     * 用户指纹识别失败
     */
    public static final String ERROR_CLIENT_FINGERPRINT_FILE = "A0221";

    /**
     * 用户面容识别失败
     */
    public static final String ERROR_CLIENT_COUNTENANCE_FILE = "A0222";

    /**
     * 用户未获得第三方登录授权
     */
    public static final String ERROR_CLIENT_NO_LOGIN_AUTHORIZATION = "A0223";

    /**
     * 用户登录已过期
     */
    public static final String ERROR_CLIENT_LOGIN_EXPIRED = "A0230";

    /**
     * 用户验证码错误
     */
    public static final String ERROR_CLIENT_CHECKCODE_ERROR = "A0240";

    /**
     * 用户验证码尝试次数超限
     */
    public static final String ERROR_CLIENT_CHECKCODE_TIMES_OVERRUN = "A0241";

    /**
     * 访问权限异常   二级宏观错误码
     */
    public static final String ERROR_CLIENT_ACCESS_EXCEPTION = "A0300";

    /**
     * 访问未授权
     */
    public static final String ERROR_CLIENT_ACCESS_UNAUTHORIZED = "A0301";

    /**
     * 正在授权中
     */
    public static final String ERROR_CLIENT_ACCESS_AUTHORIZING = "A0302";

    /**
     * 用户授权申请被拒绝
     */
    public static final String ERROR_CLIENT_REJECTED_AUTHORIZATION = "A0303";

    /**
     * 因访问对象隐私设置被拦截
     */
    public static final String ERROR_CLIENT_ACCESS_PRIVACY_SETTINGS_BLOCKED = "A0310";

    /**
     * 授权已过期
     */
    public static final String ERROR_CLIENT_AUTHORIZATION_EXPIRED = "A0311";

    /**
     * 无权限使用API
     */
    public static final String ERROR_CLIENT_NO_PROMISSIONS_TO_API = "A0312";

    /**
     * 用户访问被拦截
     */
    public static final String ERROR_CLIENT_ACCESS_BLOCKED = "A0320";

    /**
     * 黑名单用户
     */
    public static final String ERROR_CLIENT_BLACKLIST_USERS = "A0321";

    /**
     * 账号被冻结
     */
    public static final String ERROR_CLIENT_ACCOUNT_IS_FROZEN = "A0322";

    /**
     * 非法IP地址
     */
    public static final String ERROR_CLIENT_ILLEGAL_IP_ADDRESS = "A0323";

    /**
     * 网关访问受限
     */
    public static final String ERROR_CLIENT_GATEWAY_ACCESS_RESTRICTED = "A0324";

    /**
     * 地域黑名单
     */
    public static final String ERROR_CLIENT_REGIONAL_BLACKLIST = "A0325";

    /**
     * 服务已欠费
     */
    public static final String ERROR_CLIENT_SERVICE_ARREARS = "A0330";

    /**
     * 用户签名异常
     */
    public static final String ERROR_CLIENT_SIGNATURE_EXCEPTION = "A0340";

    /**
     * RSA签名错误
     */
    public static final String ERROR_CLIENT_RSA_SIGNATURE_ERROR = "A0341";

    /**
     * 用户请求参数错误  二级宏观错误码
     */
    public static final String ERROR_CLIENT_REQUEST_PARAMETER_ERROR = "A0400";

    /**
     * 包含非法恶意跳转链接
     */
    public static final String ERROR_CLIENT_ILLEGAL_MALICIOUS_LINKS = "A0401";

    /**
     * 无效的用户输入
     */
    public static final String ERROR_CLIENT_INVALID_INPUT = "A0402";

    /**
     * 请求必填参数为空
     */
    public static final String ERROR_CLIENT_REQUIRED_PARAMETER_EMPTY = "A0410";

    /**
     * 用户订单号为空
     */
    public static final String ERROR_CLIENT_ORDER_NUMBER_EMPTY = "A0411";

    /**
     * 订购数量为空
     */
    public static final String ERROR_CLIENT_ORDER_QUANTITY_EMPTY = "A0412";

    /**
     * 缺少时间戳参数
     */
    public static final String ERROR_CLIENT_TIMESTAMP_PARAMETER_MISSING = "A0413";

    /**
     * 非法的时间戳参数
     */
    public static final String ERROR_CLIENT_INVALID_TIMESTAMP_PARAMETER = "A0414";

    /**
     * 订单类型不匹配
     */
    public static final String ERROR_CLIENT_ORDER_TYPE_MISMATCHING = "A0415";

    /**
     * 产品日库存不足
     */
    public static final String ERROR_CLIENT_PRODUCT_INVENTORY_SHORTAGE = "A0416";

    /**
     * 统一下单失败
     */
    public static final String ERROR_CLIENT_ORDER_PLACE_FAIL = "A0417";

    /**
     * 请求参数值超出允许的范围
     */
    public static final String ERROR_CLIENT_PARAMETER_VALUES_BEYOND_ALLOWED_RANGE = "A0420";

    /**
     * 参数格式不匹配
     */
    public static final String ERROR_CLIENT_PARAMETER_FORMAT_NOT_MATCH = "A0421";

    /**
     * 地址不在服务范围
     */
    public static final String ERROR_CLIENT_ADDRESS_NOT_IN_SERVICE = "A0422";

    /**
     * 时间不在服务范围
     */
    public static final String ERROR_CLIENT_TIME_NOT_IN_SERVICE = "A0423";

    /**
     * 金额超出限制
     */
    public static final String ERROR_CLIENT_AMOUNT_EXCEEDS_LIMIT = "A0424";

    /**
     * 数量超出限制
     */
    public static final String ERROR_CLIENT_QUANTITY_EXCEEDS_LIMIT = "A0425";

    /**
     * 请求批量处理总个数超出限制
     */
    public static final String ERROR_CLIENT_BATCH_PROCESSING_TOTAL_EXCEEDS_LIMIT = "A0426";

    /**
     * 请求JSON解析失败
     */
    public static final String ERROR_CLIENT_REQUEST_JSON_PARSING_FAILED = "A0427";

    /**
     * 用户输入内容非法
     */
    public static final String ERROR_CLIENT_INPUT_ILLEGAL = "A0430";

    /**
     * 包含违禁敏感词
     */
    public static final String ERROR_CLIENT_PROHIBITED_SENSITIVE_WORD = "A0431";

    /**
     * 图片包含违禁信息
     */
    public static final String ERROR_CLIENT_IMAGE_PROHIBITED = "A0432";

    /**
     * 文件侵犯版权
     */
    public static final String ERROR_CLIENT_COPYRIGHT_INFRINGEMENT = "A0433";

    /**
     * 用户操作异常
     */
    public static final String ERROR_CLIENT_OPERATION_ABNORMAL = "A0440";

    /**
     * 用户支付超时
     */
    public static final String ERROR_CLIENT_PAY_OVERTIME = "A0441";

    /**
     * 确认订单超时
     */
    public static final String ERROR_CLIENT_ORDER_TIMEOUT = "A0442";

    /**
     * 订单已关闭
     */
    public static final String ERROR_CLIENT_ORDER_CLOSED = "A0443";

    /**
     * 用户支付失败
     */
    public static final String ERROR_CLIENT_PAY_FAIL = "A0444";

    /**
     * 用户请求服务异常   二级宏观错误码
     */
    public static final String ERROR_CLIENT_REQUEST_SERVICE_EXCEPTION = "A0500";

    /**
     * 请求次数超出限制
     */
    public static final String ERROR_CLIENT_REQUESTS_NUMBER_EXCEEDS_LIMIT = "A0501";

    /**
     * 请求并发数超出限制
     */
    public static final String ERROR_CLIENT_REQUESTS_CONCURRENT_NUMBER_EXCEEDS_LIMIT = "A0502";

    /**
     * 用户操作请等待
     */
    public static final String ERROR_CLIENT_OPERATION_WAIT = "A0503";

    /**
     * WebSocket连接异常
     */
    public static final String ERROR_CLIENT_WEBSOCKET_CONNECTION_EXCEPTION = "A0504";

    /**
     * WebSocket连接断开
     */
    public static final String ERROR_CLIENT_WEBSOCKET_CONNECTION_DISCONNECT = "A0505";

    /**
     * 用户重复请求
     */
    public static final String ERROR_CLIENT_REPEATED_REQUESTS = "A0506";

    /**
     * 用户资源异常   二级宏观错误码
     */
    public static final String ERROR_CLIENT_RESOURCE_EXCEPTION = "A0600";

    /**
     * 账户余额不足
     */
    public static final String ERROR_CLIENT_INSUFFICIENT_ACCOUNT_BALANCE = "A0601";

    /**
     * 用户磁盘空间不足
     */
    public static final String ERROR_CLIENT_INSUFFICIENT_DISK_SPACE = "A0602";

    /**
     * 用户内存空间不足
     */
    public static final String ERROR_CLIENT_INSUFFICIENT_MEMORY_SPACE = "A0603";

    /**
     * 用户OSS容量不足
     */
    public static final String ERROR_CLIENT_INSUFFICIENT_OSS_CAPACITY = "A0604";

    /**
     * 用户配额已用光   蚂蚁森林浇水数或每天抽奖数
     */
    public static final String ERROR_CLIENT_QUOTA_EXHAUSTED = "A0605";

    /**
     * 用户上传文件异常   二级宏观错误码
     */
    public static final String ERROR_CLIENT_UPLOAD_FILE_EXCEPTION = "A0700";

    /**
     * 用户上传文件类型不匹配
     */
    public static final String ERROR_CLIENT_UPLOAD_FILE_TYPE_NOT_MATCH = "A0701";

    /**
     * 用户上传文件太大
     */
    public static final String ERROR_CLIENT_UPLOAD_FILE_TOO_LARGE = "A0702";

    /**
     * 用户上传图片太大
     */
    public static final String ERROR_CLIENT_UPLOAD_PICTURE_TOO_LARGE = "A0703";

    /**
     * 用户上传视频太大
     */
    public static final String ERROR_CLIENT_UPLOAD_VIDEO_TOO_LARGE = "A0704";

    /**
     * 用户上传压缩文件太大
     */
    public static final String ERROR_CLIENT_UPLOAD_COMPRESSED_FILE_TOO_LARGE = "A0705";

    /**
     * 用户当前版本异常   二级宏观错误码
     */
    public static final String ERROR_CLIENT_CURRENT_VERSION_ABNORMAL = "A0800";

    /**
     * 用户安装版本与系统不匹配
     */
    public static final String ERROR_CLIENT_INSTALLED_VERSION_NOT_MATCH = "A0801";

    /**
     * 用户安装版本过低
     */
    public static final String ERROR_CLIENT_INSTALLED_VERSION_TOO_LOW = "A0802";

    /**
     * 用户安装版本过高
     */
    public static final String ERROR_CLIENT_INSTALLED_VERSION_TOO_HIGH = "A0803";

    /**
     * 用户安装版本已过期
     */
    public static final String ERROR_CLIENT_INSTALLED_VERSION_EXPIRED = "A0804";

    /**
     * 用户API请求版本不匹配
     */
    public static final String ERROR_CLIENT_API_VERSION_NOT_MATCH = "A0805";

    /**
     * 用户API请求版本过高
     */
    public static final String ERROR_CLIENT_API_VERSION_TOO_HIGH = "A0806";

    /**
     * 用户API请求版本过低
     */
    public static final String ERROR_CLIENT_API_VERSION_TOO_LOW = "A0807";

    /**
     * 用户隐私未授权   二级宏观错误码
     */
    public static final String ERROR_CLIENT_PRIVACY_NOT_AUTHORIZED = "A0900";

    /**
     * 用户隐私未签署
     */
    public static final String ERROR_CLIENT_PRIVACY_NOT_SIGNED = "A0901";

    /**
     * 用户摄像头未授权
     */
    public static final String ERROR_CLIENT_UNAUTHORIZED_CAMERA = "A0902";

    /**
     * 用户相机未授权
     */
    public static final String ERROR_CLIENT_CAMERA_NOT_AUTHORIZED = "A0903";

    /**
     * 用户图片库未授权
     */
    public static final String ERROR_CLIENT_UNAUTHORIZED_IMAGE_LIBRARY = "A0904";

    /**
     * 用户文件未授权
     */
    public static final String ERROR_CLIENT_UNAUTHORIZED_DOCUMENT = "A0905";

    /**
     * 用户位置信息未授权
     */
    public static final String ERROR_CLIENT_UNAUTHORIZED_LOCATION = "A0906";

    /**
     * 用户通讯录未授权
     */
    public static final String ERROR_CLIENT_UNAUTHORIZED_ADDRESS_BOOK = "A0907";

    /**
     * 用户设备异常   二级宏观错误码
     */
    public static final String ERROR_CLIENT_EQUIPMENT_ABNORMAL = "A1000";

    /**
     * 用户相机异常
     */
    public static final String ERROR_CLIENT_CAMERA_ABNORMAL = "A1001";

    /**
     * 用户麦克风异常
     */
    public static final String ERROR_CLIENT_MICROPHONE_ABNORMAL = "A1002";

    /**
     * 用户听筒异常
     */
    public static final String ERROR_CLIENT_EARPIECE_ABNORMAL = "A1003";

    /**
     * 用户扬声器异常
     */
    public static final String ERROR_CLIENT_SPEAKER_ABNORMAL = "A1004";

    /**
     * 用户GPS定位异常
     */
    public static final String ERROR_CLIENT_GPS_POSITIONING_ABNORMAL = "A1005";

    /**
     * 用户权限异常 二级宏观错误码
     */
    public static final String ERROR_CLIENT_PERMISSION = "A1100";

    /**
     * 用户请求无权限
     */
    public static final String ERROR_CLIENT_PERMISSION_NO_FOUNT = "A1101";

    /**
     * 用户权限过期
     */
    public static final String ERROR_CLIENT_PERMISSION_TIME_OUT = "A1102";

    /**
     * 用户权限无效
     */
    public static final String ERROR_CLIENT_PERMISSION_INVALID = "A1103";


    /**
     * 系统执行出错   一级宏观错误码
     */
    public static final String ERROR_SYS = "B0001";
    /**
     * 系统执行超时   二级宏观错误码
     */
    public static final String ERROR_SYS_RUN_TIME_OUT = "B0100";

    /**
     * 系统订单处理超时
     */
    public static final String ERROR_SYS_ORDER_TIME_OUT = "B0101";

    /**
     * 系统数据转换失败
     */
    public static final String ERROR_SYS_FAILED_DATA_CONVERT = "B0102";

    /**
     * 数据结构异常
     * <p>相关数据缺失</p>
     * <p>系统不可能出行的数据错误，一般由手工修改导致的错误</p>
     */
    public static final String ERROR_SYS_DATA_STRUCTURE = "B0103";

    /**
     * 系统配置参数异常
     * <p>获取配置参数异常</p>
     */
    public static final String ERROR_SYS_CONF = "B0104";

    /**
     * 系统编码逻辑
     * <p>1.内部方法调用不符合预期的调用</p>
     */
    public static final String ERROR_SYS_CODE = "B0105";

    /**
     * 系统容灾功能被触发   二级宏观错误码
     */
    public static final String ERROR_SYS_DISASTER_TRCOVERY_FUNCTION_TRIGGERED = "B0200";

    /**
     * 系统限流
     */
    public static final String ERROR_SYS_CURRENT_LIMITING = "B0210";

    /**
     * 系统功能降级
     */
    public static final String ERROR_SYS_FUNCTIONAL_DEGRADATION = "B0220";


    /**
     * 系统资源异常   二级宏观错误码
     */
    public static final String ERROR_SYS_RESOURCES_ABNORMAL = "B0300";

    /**
     * 系统资源耗尽
     */
    public static final String ERROR_SYS_RESOURCE_EXHAUSTION = "B0310";

    /**
     * 系统磁盘空间耗尽
     */
    public static final String ERROR_SYS_OUT_OF_DISK_SPACE = "B0311";

    /**
     * 系统内存耗尽
     */
    public static final String ERROR_SYS_OUT_OF_MEMORY = "B0312";

    /**
     * 文件句柄耗尽
     */
    public static final String ERROR_SYS_FILE_HANDLE_EXHAUSTED = "B0313";

    /**
     * 系统连接池耗尽
     */
    public static final String ERROR_SYS_CONNECTION_POOL_DEPLETION = "B0314";

    /**
     * 系统线程池耗尽
     */
    public static final String ERROR_SYS_THREAD_POOL_DEPLETION = "B0315";

    /**
     * 系统资源访问异常
     */
    public static final String ERROR_SYS_RESOURCE_ACCESS_EXCEPTION = "B0320";

    /**
     * 系统读取磁盘文件失败
     */
    public static final String ERROR_SYS_FAILED_READ_DISK_FILE = "B0321";

    /**
     * 系统执行SQL出错
     */
    public static final String ERROR_SYS_RUN_SQL = "B0322";

    /**
     * 请求404，无相关服务
     */
    public static final String ERROR_SYS_ACTION_NOT_FOUND = "B0341";

    /**
     * 系统请求未定义权限标记,参考权限标记 LuTagPermission
     *
     * @see com.lucun.wltour.common.permission.LuTagPermission
     */
    public static final String ERROR_SYS_PERMISSION_ACTION_NO = "B0342";


    /**
     * 系统参数异常
     */
    public static final String ERROR_SYS_PARAM = "B0400";

    /**
     * 系统配置参数禁用
     */
    public static final String ERROR_SYS_PARAM_CONFIG_DISABLE = "B0401";

    /**
     * 系统配置参数为空
     */
    public static final String ERROR_SYS_PARAM_CONFIG_EMPTY = "B0402";

    /**
     * 系统配置参数类型错误
     */
    public static final String ERROR_SYS_PARAM_CONFIG_TYPE = "B0403";
    /**
     * 系统配置参数类型过小
     */
    public static final String ERROR_SYS_PARAM_CONFIG_SMALL = "B0404";

    /**
     * 系统配置参数类型过大
     */
    public static final String ERROR_SYS_PARAM_CONFIG_BIG = "B0405";

    /**
     * 调用第三方服务出错 一级宏观错误码
     */
    public static final String ERROR_REMOTE = "C0001";

    /**
     * 中间件服务出错 二级宏观错误码
     */
    public static final String ERROR_REMOTE_MIDDLEWARE = "C0100";

    /**
     * RPC服务出错
     */
    public static final String ERROR_REMOTE_RPC = "C0110";

    /**
     * RPC服务未找到
     */
    public static final String ERROR_REMOTE_RPC_NOT_FOUND = "C0111";

    /**
     * RPC服务未注册
     */
    public static final String ERROR_REMOTE_RPC_NOT_REGISTER = "C0112";

    /**
     * 接口不存在
     */
    public static final String ERROR_REMOTE_API_NOT_REGISTER = "C0113";

    /**
     * 消息服务出错
     */
    public static final String ERROR_REMOTE_MESSAGE_SERVICE_ERROR = "C0120";

    /**
     * 消息投递出错
     */
    public static final String ERROR_REMOTE_MESSAGE_DELIVERY_ERROR = "C0121";

    /**
     * 消息消费出错
     */
    public static final String ERROR_REMOTE_MESSAGE_CONSUMPTION_ERROR = "C0122";

    /**
     * 消息订阅出错
     */
    public static final String ERROR_REMOTE_MESSAGE_SUBSCRIPTION_ERROR = "C0123";

    /**
     * 消息分组未查到
     */
    public static final String ERROR_REMOTE_MESSAGE_GROUPING_NOT_FOUND = "C0124";

    /**
     * 缓存服务出错
     */
    public static final String ERROR_REMOTE_CACHE_SERVICE_ERROR = "C0130";

    /**
     * key长度超过限制
     */
    public static final String ERROR_REMOTE_KEY_LENGTH_OVER_LIMIT = "C0131";

    /**
     * value长度超过限制
     */
    public static final String ERROR_REMOTE_VALUE_LENGTH_OVER_LIMIT = "C0132";

    /**
     * 存储容量已满
     */
    public static final String ERROR_REMOTE_STORAGE_CAPACITY_FULL = "C0133";

    /**
     * 不支持的数据格式
     */
    public static final String ERROR_REMOTE_UNSUPPORTED_DATA_FORMATS = "C0134";

    /**
     * 配置服务出错
     */
    public static final String ERROR_REMOTE_CONFIGURATION_SERVICE_ERROR = "C0140";

    /**
     * 网络资源服务出错
     */
    public static final String ERROR_REMOTE_NETWORK_RESOURCE_SERVICE_ERROR = "C0150";

    /**
     * VPN服务出错
     */
    public static final String ERROR_REMOTE_VPN_SERVICE_ERROR = "C0151";

    /**
     * CDN服务出错
     */
    public static final String ERROR_REMOTE_CDN_SERVICE_ERROR = "C0152";

    /**
     * 域名解析服务出错
     */
    public static final String ERROR_REMOTE_DOMAIN_NAME_RESOLUTION_SERVICE_ERROR = "C0153";

    /**
     * 网关服务出错
     */
    public static final String ERROR_REMOTE_GATEWAY_SERVICE_ERROR = "C0154";

    /**
     * 第三方系统执行超时   二级宏观错误码
     */
    public static final String ERROR_REMOTE_THIRD_PARTY_SYSTEM_EXECUTION_TIMEOUT = "C0200";

    /**
     * RPC执行超时
     */
    public static final String ERROR_REMOTE_RPC_TIMEOUTS = "C0210";

    /**
     * 消息投递超时
     */
    public static final String ERROR_REMOTE_MESSAGE_DELIVERY_TIMEOUT = "C0220";

    /**
     * 缓存服务超时
     */
    public static final String ERROR_REMOTE_CACHE_SERVICE_TIMEOUT = "C0230";

    /**
     * 配置服务超时
     */
    public static final String ERROR_REMOTE_CONFIGURE_SERVICE_TIMEOUT = "C0240";

    /**
     * 数据库服务超时
     */
    public static final String ERROR_REMOTE_DATABASE_SERVICE_TIMEOUT = "C0250";

    /**
     * 数据库服务出错   二级宏观错误码
     */
    public static final String ERROR_REMOTE_DATABASE_SERVICE_ERROR = "C0300";

    /**
     * 表不存在
     */
    public static final String ERROR_REMOTE_TABLE_DOES_NOT_EXIST = "C0311";

    /**
     * 列不存在
     */
    public static final String ERROR_REMOTE_COLUMN_DOES_NOT_EXIST = "C0312";

    /**
     * 多表关联中存在多个相同名称的列
     */
    public static final String ERROR_REMOTE_MULTIPLE_COLUMNS_WITH_THE_SAMENAME = "C0321";

    /**
     * 数据库死锁
     */
    public static final String ERROR_REMOTE_DATABASE_DEADLOCK = "C0331";

    /**
     * 主键冲突
     */
    public static final String ERROR_REMOTE_PRIMARY_KEY_CONFLICT = "C0341";

    /**
     * 第三方容灾系统被触发  二级宏观错误码
     */
    public static final String ERROR_REMOTE_THIRD_PARTY_DISASTER_TRCOVERY_SYSTEM_TRIGGERED = "C0400";

    /**
     * 第三方系统限流
     */
    public static final String ERROR_REMOTE_THIRD_PARTY_SYSTEMS_ARE_CURRENT_LIMITING = "C0401";

    /**
     * 第三方功能降级
     */
    public static final String ERROR_REMOTE_THIRD_PARTY_FUNCTION_DEGRADATION = "C0402";

    /**
     * 通知服务出错   二级宏观错误码
     */
    public static final String ERROR_REMOTE_NOTIFICATION_SERVICE_ERROR = "C0500";

    /**
     * 短信提醒服务失败
     */
    public static final String ERROR_REMOTE_SMS_ALERT_SERVICE_FAIL = "C0501";

    /**
     * 语音提醒服务失败
     */
    public static final String ERROR_REMOTE_VOICE_REMINDER_SERVICE_FAIL = "C0502";

    /**
     * 邮件提醒服务失败
     */
    public static final String ERROR_REMOTE_MAIL_REMINDER_SERVICE_FAILED = "C0503";


    @Override
    public String getName(String val) {
        if (StringUtils.isBlank(val)) {
            return "";
        }
        switch (val) {
            case SUCCESS:
                return "成功";
            case ERROR_CLIENT:
                return "用户端错误";
            case ERROR_CLIENT_REGISTER:
                return "用户注册错误";
            case ERROR_CLIENT_NOT_AGREE:
                return "用户未同意隐私协议";
            case ERROR_CLIENT_REGION_LIMIT:
                return "注册国家或地区受限";
            case ERROR_CLIENT_USERNAME_FAIL:
                return "用户名校验失败";
            case ERROR_CLIENT_USERNAME_EXISTS:
                return "用户名已存在";
            case ERROR_CLIENT_ILLEGAL_WORD:
                return "用户名包含敏感词";
            case ERROR_CLIENT_SPECIAL_CHARACTER:
                return "用户名包含特殊字符";
            case ERROR_CLIENT_PASSWORD_FAIL:
                return "密码校验失败";
            case ERROR_CLIENT_PASSWORD_LENGTH_NOT_ENOUGH:
                return "密码长度不够";
            case ERROR_CLIENT_PASSWORD_STRENGTH_NOT_ENOUGH:
                return "密码强度不够";
            case ERROR_CLIENT_CHECKCODE_INPUT_ERROR:
                return "校验码输入错误";
            case ERROR_CLIENT_SMS_CHECKCODE_INPUT_ERROR:
                return "短信校验码输入错误";
            case ERROR_CLIENT_EMAIL_CHECKCODE_INPUT_ERROR:
                return "邮件校验码输入错误";
            case ERROR_CLIENT_VOICE_CHECKCODE_INPUT_ERROR:
                return "语音校验码输入错误";
            case ERROR_CLIENT_CERTIFICATE_ABNORMAL:
                return "用户证件异常";
            case ERROR_CLIENT_CERTIFICATE_TYPE_UNSELECTED:
                return "用户证件类型未选择";
            case ERROR_CLIENT_IDCARD_ILLEGAL:
                return "大陆身份证编号校验非法";
            case ERROR_CLIENT_PASSPORT_ILLEGAL:
                return "护照编号校验非法";
            case ERROR_CLIENT_MILITARY_ID_NUMBER_ILLEGAL:
                return "军官证编号校验非法";
            case ERROR_CLIENT_BASIC_INFORMATION_FAIL:
                return "用户基本信息校验失败";
            case ERROR_CLIENT_PHONE_FORMAT_FAIL:
                return "手机格式校验失败";
            case ERROR_CLIENT_ADDRESS_FORMAT_FAIL:
                return "地址格式校验失败";
            case ERROR_CLIENT_EMAIL_FORMAT_FAIL:
                return "邮箱格式校验失败";
            case ERROR_CLIENT_LOGIN_ABNORMAL:
                return "用户登录异常";
            case ERROR_CLIENT_ACCOUNT_NOTEXIST:
                return "用户账户不存在";
            case ERROR_CLIENT_ACCOUNT_FREEZE:
                return "用户账户被冻结";
            case ERROR_CLIENT_ACCOUNT_INVALID:
                return "用户账户已作废";
            case ERROR_CLIENT_PASSWORD_ERROR:
                return "用户密码错误";
            case ERROR_CLIENT_PASSWORD_ERROR_TIMES_OVERRUN:
                return "用户输入密码错误次数超限";
            case ERROR_CLIENT_IDENTITY_FILE:
                return "用户身份校验失败";
            case ERROR_CLIENT_FINGERPRINT_FILE:
                return "用户指纹识别失败";
            case ERROR_CLIENT_COUNTENANCE_FILE:
                return "用户面容识别失败";
            case ERROR_CLIENT_NO_LOGIN_AUTHORIZATION:
                return "用户未获得第三方登录授权";
            case ERROR_CLIENT_LOGIN_EXPIRED:
                return "用户登录已过期";
            case ERROR_CLIENT_CHECKCODE_ERROR:
                return "用户验证码错误";
            case ERROR_CLIENT_CHECKCODE_TIMES_OVERRUN:
                return "用户验证码尝试次数超限";
            case ERROR_CLIENT_ACCESS_EXCEPTION:
                return "访问权限异常";
            case ERROR_CLIENT_ACCESS_UNAUTHORIZED:
                return "访问未授权";
            case ERROR_CLIENT_ACCESS_AUTHORIZING:
                return "正在授权中";
            case ERROR_CLIENT_REJECTED_AUTHORIZATION:
                return "用户授权申请被拒绝";
            case ERROR_CLIENT_ACCESS_PRIVACY_SETTINGS_BLOCKED:
                return "因访问对象隐私设置被拦截";
            case ERROR_CLIENT_AUTHORIZATION_EXPIRED:
                return "授权已过期";
            case ERROR_CLIENT_NO_PROMISSIONS_TO_API:
                return "无权限使用API";
            case ERROR_CLIENT_ACCESS_BLOCKED:
                return "用户访问被拦截";
            case ERROR_CLIENT_BLACKLIST_USERS:
                return "黑名单用户";
            case ERROR_CLIENT_ACCOUNT_IS_FROZEN:
                return "账号被冻结";
            case ERROR_CLIENT_ILLEGAL_IP_ADDRESS:
                return "非法IP地址";
            case ERROR_CLIENT_GATEWAY_ACCESS_RESTRICTED:
                return "网关访问受限";
            case ERROR_CLIENT_REGIONAL_BLACKLIST:
                return "地域黑名单";
            case ERROR_CLIENT_SERVICE_ARREARS:
                return "服务已欠费";
            case ERROR_CLIENT_SIGNATURE_EXCEPTION:
                return "用户签名异常";
            case ERROR_CLIENT_RSA_SIGNATURE_ERROR:
                return "RSA签名错误";
            case ERROR_CLIENT_REQUEST_PARAMETER_ERROR:
                return "用户请求参数错误";
            case ERROR_CLIENT_ILLEGAL_MALICIOUS_LINKS:
                return "包含非法恶意跳转链接";
            case ERROR_CLIENT_INVALID_INPUT:
                return "无效的用户输入";
            case ERROR_CLIENT_REQUIRED_PARAMETER_EMPTY:
                return "请求必填参数为空";
            case ERROR_CLIENT_ORDER_NUMBER_EMPTY:
                return "用户订单号为空";
            case ERROR_CLIENT_ORDER_QUANTITY_EMPTY:
                return "订购数量为空";
            case ERROR_CLIENT_TIMESTAMP_PARAMETER_MISSING:
                return "缺少时间戳参数";
            case ERROR_CLIENT_INVALID_TIMESTAMP_PARAMETER:
                return "非法的时间戳参数";
            case ERROR_CLIENT_PARAMETER_VALUES_BEYOND_ALLOWED_RANGE:
                return "请求参数值超出允许的范围";
            case ERROR_CLIENT_PARAMETER_FORMAT_NOT_MATCH:
                return "参数格式不匹配";
            case ERROR_CLIENT_ADDRESS_NOT_IN_SERVICE:
                return "地址不在服务范围";
            case ERROR_CLIENT_TIME_NOT_IN_SERVICE:
                return "时间不在服务范围";
            case ERROR_CLIENT_AMOUNT_EXCEEDS_LIMIT:
                return "金额超出限制";
            case ERROR_CLIENT_QUANTITY_EXCEEDS_LIMIT:
                return "数量超出限制";
            case ERROR_CLIENT_BATCH_PROCESSING_TOTAL_EXCEEDS_LIMIT:
                return "请求批量处理总个数超出限制";
            case ERROR_CLIENT_REQUEST_JSON_PARSING_FAILED:
                return "请求JSON解析失败";
            case ERROR_CLIENT_INPUT_ILLEGAL:
                return "用户输入内容非法";
            case ERROR_CLIENT_PROHIBITED_SENSITIVE_WORD:
                return "包含违禁敏感词";
            case ERROR_CLIENT_IMAGE_PROHIBITED:
                return "图片包含违禁信息";
            case ERROR_CLIENT_COPYRIGHT_INFRINGEMENT:
                return "文件侵犯版权";
            case ERROR_CLIENT_OPERATION_ABNORMAL:
                return "用户操作异常";
            case ERROR_CLIENT_PAY_OVERTIME:
                return "用户支付超时";
            case ERROR_CLIENT_PAY_FAIL:
                return "用户支付失败";
            case ERROR_CLIENT_ORDER_TIMEOUT:
                return "确认订单超时";
            case ERROR_CLIENT_ORDER_CLOSED:
                return "订单已关闭";
            case ERROR_CLIENT_ORDER_TYPE_MISMATCHING:
                return "订单类型不匹配";
            case ERROR_CLIENT_PRODUCT_INVENTORY_SHORTAGE:
                return "产品日库存不足";
            case ERROR_CLIENT_ORDER_PLACE_FAIL:
                return "统一下单失败";
            case ERROR_CLIENT_REQUEST_SERVICE_EXCEPTION:
                return "用户请求服务异常";
            case ERROR_CLIENT_REQUESTS_NUMBER_EXCEEDS_LIMIT:
                return "请求次数超出限制";
            case ERROR_CLIENT_REQUESTS_CONCURRENT_NUMBER_EXCEEDS_LIMIT:
                return "请求并发数超出限制";
            case ERROR_CLIENT_OPERATION_WAIT:
                return "用户操作请等待";
            case ERROR_CLIENT_WEBSOCKET_CONNECTION_EXCEPTION:
                return "WebSocket连接异常";
            case ERROR_CLIENT_WEBSOCKET_CONNECTION_DISCONNECT:
                return "WebSocket连接断开";
            case ERROR_CLIENT_REPEATED_REQUESTS:
                return "用户重复请求";
            case ERROR_CLIENT_RESOURCE_EXCEPTION:
                return "用户资源异常";
            case ERROR_CLIENT_INSUFFICIENT_ACCOUNT_BALANCE:
                return "账户余额不足";
            case ERROR_CLIENT_INSUFFICIENT_DISK_SPACE:
                return "用户磁盘空间不足";
            case ERROR_CLIENT_INSUFFICIENT_MEMORY_SPACE:
                return "用户内存空间不足";
            case ERROR_CLIENT_INSUFFICIENT_OSS_CAPACITY:
                return "用户OSS容量不足";
            case ERROR_CLIENT_QUOTA_EXHAUSTED:
                return "用户配额已用光";
            case ERROR_CLIENT_UPLOAD_FILE_EXCEPTION:
                return "用户上传文件异常";
            case ERROR_CLIENT_UPLOAD_FILE_TYPE_NOT_MATCH:
                return "用户上传文件类型不匹配";
            case ERROR_CLIENT_UPLOAD_FILE_TOO_LARGE:
                return "用户上传文件太大";
            case ERROR_CLIENT_UPLOAD_PICTURE_TOO_LARGE:
                return "用户上传图片太大";
            case ERROR_CLIENT_UPLOAD_VIDEO_TOO_LARGE:
                return "用户上传视频太大";
            case ERROR_CLIENT_UPLOAD_COMPRESSED_FILE_TOO_LARGE:
                return "用户上传压缩文件太大";
            case ERROR_CLIENT_CURRENT_VERSION_ABNORMAL:
                return "用户当前版本异常";
            case ERROR_CLIENT_INSTALLED_VERSION_NOT_MATCH:
                return "用户安装版本与系统不匹配";
            case ERROR_CLIENT_INSTALLED_VERSION_TOO_LOW:
                return "用户安装版本过低";
            case ERROR_CLIENT_INSTALLED_VERSION_TOO_HIGH:
                return "用户安装版本过高";
            case ERROR_CLIENT_INSTALLED_VERSION_EXPIRED:
                return "用户安装版本已过期";
            case ERROR_CLIENT_API_VERSION_NOT_MATCH:
                return "用户API请求版本不匹配";
            case ERROR_CLIENT_API_VERSION_TOO_HIGH:
                return "用户API请求版本过高";
            case ERROR_CLIENT_API_VERSION_TOO_LOW:
                return "用户API请求版本过低";
            case ERROR_CLIENT_PRIVACY_NOT_AUTHORIZED:
                return "用户隐私未授权";
            case ERROR_CLIENT_PRIVACY_NOT_SIGNED:
                return "用户隐私未签署";
            case ERROR_CLIENT_UNAUTHORIZED_CAMERA:
                return "用户摄像头未授权";
            case ERROR_CLIENT_CAMERA_NOT_AUTHORIZED:
                return "用户相机未授权";
            case ERROR_CLIENT_UNAUTHORIZED_IMAGE_LIBRARY:
                return "用户图片库未授权";
            case ERROR_CLIENT_UNAUTHORIZED_DOCUMENT:
                return "用户文件未授权";
            case ERROR_CLIENT_UNAUTHORIZED_LOCATION:
                return "用户位置信息未授权";
            case ERROR_CLIENT_UNAUTHORIZED_ADDRESS_BOOK:
                return "用户通讯录未授权";
            case ERROR_CLIENT_EQUIPMENT_ABNORMAL:
                return "用户设备异常";
            case ERROR_CLIENT_CAMERA_ABNORMAL:
                return "用户相机异常";
            case ERROR_CLIENT_MICROPHONE_ABNORMAL:
                return "用户麦克风异常";
            case ERROR_CLIENT_EARPIECE_ABNORMAL:
                return "用户听筒异常";
            case ERROR_CLIENT_SPEAKER_ABNORMAL:
                return "用户扬声器异常";
            case ERROR_CLIENT_GPS_POSITIONING_ABNORMAL:
                return "用户GPS定位异常";
            case ERROR_CLIENT_PERMISSION:
                return "用户权限异常";
            case ERROR_CLIENT_PERMISSION_NO_FOUNT:
                return "用户无相关权限";
            case ERROR_CLIENT_PERMISSION_TIME_OUT:
                return "用户权限过期";
            case ERROR_CLIENT_PERMISSION_INVALID:
                return "用户权限无效";

            case ERROR_SYS:
                return "系统错误";
            case ERROR_SYS_RUN_TIME_OUT:
                return "系统执行超时";
            case ERROR_SYS_ORDER_TIME_OUT:
                return "系统订单处理超时";
            case ERROR_SYS_DISASTER_TRCOVERY_FUNCTION_TRIGGERED:
                return "系统容灾功能被触发";
            case ERROR_SYS_CURRENT_LIMITING:
                return "系统限流";
            case ERROR_SYS_FUNCTIONAL_DEGRADATION:
                return "系统功能降级";
            case ERROR_SYS_RESOURCES_ABNORMAL:
                return "系统资源异常";
            case ERROR_SYS_RESOURCE_EXHAUSTION:
                return "系统资源耗尽";
            case ERROR_SYS_OUT_OF_DISK_SPACE:
                return "系统磁盘空间耗尽";
            case ERROR_SYS_OUT_OF_MEMORY:
                return "系统内存耗尽";
            case ERROR_SYS_FILE_HANDLE_EXHAUSTED:
                return "文件句柄耗尽";
            case ERROR_SYS_CONNECTION_POOL_DEPLETION:
                return "系统连接池耗尽";
            case ERROR_SYS_THREAD_POOL_DEPLETION:
                return "系统线程池耗尽";
            case ERROR_SYS_RESOURCE_ACCESS_EXCEPTION:
                return "系统资源访问异常";
            case ERROR_SYS_FAILED_READ_DISK_FILE:
                return "系统读取磁盘文件失败";
            case ERROR_SYS_FAILED_DATA_CONVERT:
                return "数据转换失败";
            case ERROR_SYS_DATA_STRUCTURE:
                return "数据结构异常";
            case ERROR_SYS_CONF:
                return "系统参数异常";
            case ERROR_SYS_CODE:
                return "系统编码异常";
            case ERROR_SYS_ACTION_NOT_FOUND:
                return "未找到相关请求";
            case ERROR_SYS_PERMISSION_ACTION_NO:
                return "系统请求未定义权限标记";

            case ERROR_SYS_PARAM:
                return "系统参数异常";
            case ERROR_SYS_PARAM_CONFIG_DISABLE:
                return "系统配置参数禁用";
            case ERROR_SYS_PARAM_CONFIG_EMPTY:
                return "系统配置参数为空";
            case ERROR_SYS_PARAM_CONFIG_TYPE:
                return "系统配置参数类型错误";
            case ERROR_SYS_PARAM_CONFIG_SMALL:
                return "系统配置参数过小";
            case ERROR_SYS_PARAM_CONFIG_BIG:
                return "系统配置参数过大";

            case ERROR_REMOTE:
                return "第三方服务错误";
            case ERROR_REMOTE_MIDDLEWARE:
                return "中间件服务出错";
            case ERROR_REMOTE_RPC:
                return "RPC服务出错";
            case ERROR_REMOTE_RPC_NOT_FOUND:
                return "RPC服务未找到";
            case ERROR_REMOTE_RPC_NOT_REGISTER:
                return "RPC服务未注册";
            case ERROR_REMOTE_API_NOT_REGISTER:
                return "接口不存在";
            case ERROR_REMOTE_MESSAGE_SERVICE_ERROR:
                return "消息服务出错";
            case ERROR_REMOTE_MESSAGE_DELIVERY_ERROR:
                return "消息投递出错";
            case ERROR_REMOTE_MESSAGE_CONSUMPTION_ERROR:
                return "消息消费出错";
            case ERROR_REMOTE_MESSAGE_SUBSCRIPTION_ERROR:
                return "消息订阅出错";
            case ERROR_REMOTE_MESSAGE_GROUPING_NOT_FOUND:
                return "消息分组未查到";
            case ERROR_REMOTE_CACHE_SERVICE_ERROR:
                return "缓存服务出错";
            case ERROR_REMOTE_KEY_LENGTH_OVER_LIMIT:
                return "key长度超过限制";
            case ERROR_REMOTE_VALUE_LENGTH_OVER_LIMIT:
                return "value长度超过限制";
            case ERROR_REMOTE_STORAGE_CAPACITY_FULL:
                return "存储容量已满";
            case ERROR_REMOTE_UNSUPPORTED_DATA_FORMATS:
                return "不支持的数据格式";
            case ERROR_REMOTE_CONFIGURATION_SERVICE_ERROR:
                return "配置服务出错";
            case ERROR_REMOTE_NETWORK_RESOURCE_SERVICE_ERROR:
                return "网络资源服务出错";
            case ERROR_REMOTE_VPN_SERVICE_ERROR:
                return "VPN服务出错";
            case ERROR_REMOTE_CDN_SERVICE_ERROR:
                return "CDN服务出错";
            case ERROR_REMOTE_DOMAIN_NAME_RESOLUTION_SERVICE_ERROR:
                return "域名解析服务出错";
            case ERROR_REMOTE_GATEWAY_SERVICE_ERROR:
                return "网关服务出错";
            case ERROR_REMOTE_THIRD_PARTY_SYSTEM_EXECUTION_TIMEOUT:
                return "第三方系统执行超时";
            case ERROR_REMOTE_RPC_TIMEOUTS:
                return "RPC执行超时";
            case ERROR_REMOTE_MESSAGE_DELIVERY_TIMEOUT:
                return "消息投递超时";
            case ERROR_REMOTE_CACHE_SERVICE_TIMEOUT:
                return "缓存服务超时";
            case ERROR_REMOTE_CONFIGURE_SERVICE_TIMEOUT:
                return "配置服务超时";
            case ERROR_REMOTE_DATABASE_SERVICE_TIMEOUT:
                return "数据库服务超时";
            case ERROR_REMOTE_DATABASE_SERVICE_ERROR:
                return "数据库服务出错";
            case ERROR_REMOTE_TABLE_DOES_NOT_EXIST:
                return "表不存在";
            case ERROR_REMOTE_COLUMN_DOES_NOT_EXIST:
                return "列不存在";
            case ERROR_REMOTE_MULTIPLE_COLUMNS_WITH_THE_SAMENAME:
                return "多表关联中存在多个相同名称的列";
            case ERROR_REMOTE_DATABASE_DEADLOCK:
                return "数据库死锁";
            case ERROR_REMOTE_PRIMARY_KEY_CONFLICT:
                return "主键冲突";
            case ERROR_REMOTE_THIRD_PARTY_DISASTER_TRCOVERY_SYSTEM_TRIGGERED:
                return "第三方容灾系统被触发";
            case ERROR_REMOTE_THIRD_PARTY_SYSTEMS_ARE_CURRENT_LIMITING:
                return "第三方系统限流";
            case ERROR_REMOTE_THIRD_PARTY_FUNCTION_DEGRADATION:
                return "第三方功能降级";
            case ERROR_REMOTE_NOTIFICATION_SERVICE_ERROR:
                return "通知服务出错'";
            case ERROR_REMOTE_SMS_ALERT_SERVICE_FAIL:
                return "短信提醒服务失败";
            case ERROR_REMOTE_VOICE_REMINDER_SERVICE_FAIL:
                return "语音提醒服务失败";
            case ERROR_REMOTE_MAIL_REMINDER_SERVICE_FAILED:
                return "邮件提醒服务失败";
            default:
                return "";
        }
    }
}
