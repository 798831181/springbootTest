### SpringBoot学习笔记

###### 1.1SpringBoot2.x特性

- SpringApplication应用类

- 自动配置

- 外化配置

- 内嵌容器

- starter组件、对日志、web、消息、测试及扩展等支持

###### springboot的parent依赖
```
@Controller
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(){
        return "hello springboot";
    }
}
```

@controller对控制层进行标注，是控制层能够接受请求，处理请求并响应。

@ResponseBody注解

对控制层类的方法进行标注，指定相应体为方法的返回值。

###### 建议架构

- 终端显示层

- web层

- service层

- manager层

- dao层

- 数据源

###### @RequestBody的使用

```
@RequestBody
```

> Controller里面的参数声明为@RequestBofy,前端传参必须以json格式传入，否则报错415错误。

###### 问题：

1. biz-web中怎么import biz-center项目中的包？

已解决，源码下载develp分支。

###### @Component的使用

因为在持久层、业务层和控制层中，分别采用@Repository、@Service和@Controller对分层中的类进行凝视，而用@Component对那些比较中立的类进行凝视。

###### @value注解的使用

- 作用：将配置文件中的属性读出来，有@value("${xxx}")和@value("#{xxx}")两种方式。

- @Value("#{xxx}") 表示SpEl表达式通常用来获取bean的属性，或者调用bean的某个方法。

- @Value("${}") 可以获取对应属性文件中定义的属性值

```
    @Value("${global.domain.cduapi}")
    private String cduApi;
```

###### RequestMapping中produces属性作用

>  注解RequestMapping中produces属性可以设置返回数据的类型以及编码，可以是json或者xml

```
@Slf4j
@Component
public class BizClient {

    public JSONObject getResponse(String url, Map<String, Object> paramMap, RequestMethod httpMethod) throws Exception {
        log.info("CSP[]DtCenterClient[]getResponse url: {},paramMap,httMethod", url, paramMap, httpMethod);
        if (RequestMethod.POST == httpMethod) {
            // 创建slb请求体bodyJson
            String body = paramMap == null ? null : JSONObject.toJSONString(paramMap);
            log.info("CSP[]DtCenterClient[]getResponse url: {},paramMap:{} ", url, paramMap);
            return HttpRequestUtil.httpPost(url, body, null);
        }
        if (RequestMethod.DELETE ==  httpMethod) {
            // 删除操作没有多余的参数
//            url = httpAddress + action;
            log.info("CSP[]DtCenterClient[]getResponse url: {}", url);
            return HttpRequestUtil.httpDelete(url, null);
        }
        log.info("CSP[]DtCenterClient[]getResponse url: {}", url);
        return HttpRequestUtil.httpGet(url, null);
    }

}
```

```
BizClient
```

> BizCilent是一个工具类，getResponse()对请求做出响应。

##### 常用的逻辑：

1. 判断参数是否为空

   ```
          //Guava框架
          if (Strings.isNullOrEmpty(bizName)) {
               return Response.fail(BizAcsErrorMessage.PARAM_IS_NULL.toString());
           }
           
   ```

   如果为空

```
 Response.fail(BizAcsErrorMessage.PARAM_IS_NULL.toString());
```

##### 更新用户功能的理解

- 获得当前登陆用户

```
LoginUser loginUser = UserUtil.getCurrentUser();
```

- 得到用户的accountId

```
 Long accountId = loginUser.getAccountId();//获得登陆用户的id
```

- 设置employeeParam的bizId和accountId

```
//设置employeeParam的bizId
        employeeParam.setBizId(bizContactInfoResponse.getData().getId());
//        设置employeeParam的accountId
        employeeParam.setAccountId(accountId);
```

- 更新用户信息

```
 Response<Boolean> result = businessInfoService.updateUser(employeeParam);
```

##### 校验企业名称

- 问题：andNameEqualTo(bizName)方法？

```
            BizContactInfoExample example = new BizContactInfoExample();
//            标准(criteria)
            BizContactInfoExample.Criteria criteria = example.createCriteria();
            criteria.andNameEqualTo(bizName);
```
andNameEqualTo方法

``` java

        /**
         * 
         * @param value
         * @return
         */
        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }
```
标准类，继承于GeneratedCriteria
```java
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

```

```java
        /**
         * 增加标准
         * @param condition
         * @param value
         * @param property
         */
        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }
```
新建标准
```java
        /**
         * 新建标准
         * @param condition
         * @param value
         */
        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }
```

```java
        /**
         * 
         * @param condition
         * @param value
         * @param typeHandler
         */
        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }
```

​        

- criteria

```
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

```



```java

    @Override
    public Response<Boolean> checkBusinessName(Long bizId, String bizName, Boolean isCreate) {
        log.info("Business[]BusinessInfoServiceImpl[]checkBusinessName[] param bizId is:{},param bizName is:{},param isCreate is:{}", bizId, bizName, isCreate);
        if (Strings.isNullOrEmpty(bizName)) {
            return Response.fail(BizAcsErrorMessage.PARAM_IS_NULL.toString());
        }
        try {
            BizContactInfoExample example = new BizContactInfoExample();
//            标准(criteria)
            BizContactInfoExample.Criteria criteria = example.createCriteria();
            criteria.andNameEqualTo(bizName);
            //如果不是新创建的则效验的时候要排除自身名称
            if (!isCreate) {
                criteria.andIdNotEqualTo(bizId);
            }
            List<BizContactInfo> bizContactInfoList = bizContactInfoMapper.selectByExample(example);
            return Response.ok(!(bizContactInfoList != null && bizContactInfoList.size() > 0));
        } catch (Exception e) {
            log.error("Business[]BusinessInfoServiceImpl[]checkBusinessName[] fail:bizName:{},cause:{}", bizName, Throwables.getStackTraceAsString(e));
            return Response.fail(BizAcsErrorMessage.CHECK_BUSINESS_NAME_FAIL.toString());
        }
    }
```

##### BeanUtils的使用

```
//将bizContactInfo拷贝到authorizedContactDto
BeanUtils.copyProperties(bizContactInfo, authorizedContactDto);
```

##### 企业上云模块使用

> AuthorizedContactDto包括联系信息和注册信息两部分

- 根据登陆用户id查询得到contactInfos

- 根据contactId查询得到registerInfo

#### 企业用户控制

- 查询当前企业id

- 用户创建OSSak

```
return bizBidService.createOssAk(loginUser.getAccountId());
```

创建ossak createOssAk(Long)



根据请求参数employeeParam

Response.isSuccess()方法理解？

Response类中有一个code变量，用于标记是否响应。类初始化的时候，将code置为SUCCESS。

selectBusinessInfoByUserId(Long userId)

> 通过userId查询bizContactInfo信息，返回类型为Response。

- 待解决：BizTaskViewPagingDto实体类的使用？

- bizbid是指什么？
>供应商
##### 获取授权列表
- 查询得到bidList
- 从bizbid中拿到id,name,providercode封装成bidAndNameDto
- 返回List<BidAndNameDto>
##### 阿里云接口
- 设置用户限额
- 查询用户限额

问题：com.gitee.maskit.utils.Response<Boolean> 和Response<Boolean>有什么区别吗？
- 重置密码的过程
如果账户类型是管理员账户，则不允许修改密码。


这个东西并没有看懂...

``` java
/**
     * 重置密码
     *
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(
            value = {"/resetPasswordByMobile"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    @ResponseBody
    public Response<Boolean> resetPasswordByMobile(HttpServletRequest request, @RequestBody ForgotPasswordMobile param) {
//        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("(?![0-9]+$)[\\x21-\\x7e]{6,16}");
//        if(!Strings.isNullOrEmpty(param.getPassword()) && pattern.matcher(param.getPassword()).matches()) {
//            if(!this.uaaProperties.getDebugOn().booleanValue()) {
//                this.smsComponent.validateSmsCaptcha(param.getMobile(), param.getCaptcha());
//            }
        log.info("uaa-web[]forgotPasswordByMobile []start [] param:{}", param);
        com.gitee.maskit.utils.Response response = null;
        if (Strings.isNullOrEmpty(param.getCategory())) {
            param.setCategory(Category.DEALER.value());
        }
        log.info("uaa-web[]forgotPasswordByMobile email = {},mobile = {}, category = {}", param.getEmail(), param.getMobile(), param.getCategory());
//       如果是管理员
        if (Category.OEM.value().equals(param.getCategory())) {
            return Response.fail(BizAcsErrorMessage.NOT_ENTERPRISE_CAN_NOT_CHANGE_PASSWORD.toString());
//            return Response.ok(Boolean.TRUE);
        } else {
            //江苏移动不用手机号和邮箱登录，直接通过accountId来重置密码
            if (null != param.getAccountId()){
//                accountReadService是什么类啊？
                com.gitee.maskit.utils.Response result = this.accountReadService.findById(param.getAccountId());
                if (result.success() && result.getData() != null) {
                    Account mainAccount = (Account) result.getData();
                    if (mainAccount == null) {
                        return Response.fail(BizAcsErrorMessage.GET_ACCOUNT_FAIL.toString());
                    } else {
                        try {
                            response = this.accountWriteService.resetPassword(param.getAccountId(), "123456");
                        } catch (Exception e) {
                            log.error("failed to reset password where accountId={},error code:{}", new Object[]{param.getAccountId(), response.getError()});
                        }
                        log.info("OP_LOG[][]uaa-web[]忘记密码[]通过accountId忘记密码[][][]");
                        return Response.ok(Boolean.TRUE);
                    }
                } else {
                    log.warn("failed to find user where accountId={} , error code:{}", new Object[]{param.getAccountId(),result.getError()});
                    return Response.fail(BizAcsErrorMessage.RESET_PASSWORD_FAIL.toString());
                }
            }else {
                return Response.fail(BizAcsErrorMessage.RESET_PASSWORD_FAIL.toString());
            }

        }
    }
```
- 删除用户
- 更新用户
- 停用

### 4 maven的基本命令

- install

> 还有一点需要理解的是，当我们运行install的时候，Maven实际上是将项目生成的构件安装到了本地仓库，也就是说，只有install了之后，其它项目才能使用此项目生成的构件。

### 5 负载均衡组件Ribbon

#### 5.1 What is Ribbon

> Ribbon是Netflix发布的负载均衡器，有助于控制HTTP和TCP客户端的行为。为Ribbon配置服务提供者地址列表后，Ribbon就可以基于某种负载均衡算法，自动的帮助消费者去请求服务。Ribbon提供了很多负载均衡算法，如：轮询，随机等。

### 根据用户ID查询角色列表

返回结果List<AppTreeDto>

`payload`

> 有效载荷

### 6 Mybatis

6.1 `namespace`

> Mybatis中namespace用于绑定dao接口，dao接口的方法对应mapper中的sql语名。

### 7 EDAS

#### 7.1 What is EDAS?

EDAS 服务注册中心实现了 Dubbo 所提供的 SPI 标准的[注册中心扩展](http://dubbo.apache.org/zh-cn/docs/dev/impls/registry.html)，能够完整地支持 Dubbo 服务注册、[路由规则](http://dubbo.apache.org/zh-cn/docs/user/demos/routing-rule.html)、[配置规则功能](http://dubbo.apache.org/zh-cn/docs/user/demos/config-rule.html)。

EDAS 服务注册中心能够完全代替 ZooKeeper 和 Redis，作为您 Dubbo 服务的注册中心.

#### 7.2 Why is EDAS?

与zookeeper和redis相比具有以下优势：

- EDAS服务注册中心为共享组件，节省运维，部署zookeeper等组件的机器成本。
- EDAS 服务注册中心在通信过程中增加了鉴权加密功能，为您的服务注册链路进行了安全加固。
- EDAS 服务注册中心与 EDAS 其他组件紧密结合，为您提供一整套的微服务解决方案。

### 8 HSF

### 9 RocketMQ

#### 9.1 What is RocketMQ?

Rocket是一款低延迟，可伸缩，易于使用的消息中间件，支持高并发，亿级的消息堆积能力，在高并发的电商，金融等业务场景中多有使用。

#### 9.2 Feature

- 支持发布/订阅（pub/push）和点对点（P2P)消息模型

