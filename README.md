# 快乐出行

# 本地开发

项目使用Maven构建，推荐使用IntelliJ IDEA开发。

## 客户端代码生成工具
swagger-codegen
对应的 mvn 插件

### 本地开发首先执行两个命令
```shell script
mvn clean install
mvn clean compile
```

### 编译镜像
1.先暴露集群端口
```shell script
kubectl port-forward service/docker-registry
 5000:5000 -n happyride
```

2.设置环境变量
```shell script
export CONTAINER_REGISTRY=127.0.0.1:5000
```

检查环境变量
```shell script
env | grep CONTAINER_REGISTRY
```

3.执行 mvn 命令
```shell script
mvn -B -ntp -Dmaven.test.failure.ignore install
```


本地开发需要Docker Compose的支持，在`dev`目录下有开发所需的Docker Compose文件。

# 本地部署

请参考`k8s`目录下的文档来部署到Kubernetes。

# 服务列表

下表是应用的服务及其说明。

| 服务名称  | Maven模块   |  API本地端口  |
|---|---|---|
| 乘客管理服务 |  `happyride-passenger-service`  |  `8500` |
| 行程管理服务 |  `happyride-trip-service`  |  `8501` |
| 地址管理服务  |  `happyride-address-service`  | `8502`  |
| 司机管理服务 |  `happyride-driver-service`  |  `8503` |
| 行程派发服务  |  `happyride-dispatch-service`  | 无  |
| 支付服务  |  `happyride-payment-service`  | `8504`  |
| 行程验证服务  |  `happyride-payment-service`  | `8505`  |
| 历史行程服务  |  `happyride-trip-history-service`  | `8506`  |
| 乘客管理界面的GraphQL服务  |  `happyride-passenger-web-api-graphql`  | `8610`  |


在Minikube中访问服务，首先显示乘客API服务的URL：

```sh
$ minikube service --url passenger-api-graphql -n happyride
```

再访问GraphQL提供的GraphiQL的界面 `<url>/graphiql`.