# SUD GI White Demo

Android 接入示例。启动后进入 White 首页，可体验游戏、分享和桌面快捷方式。

源码仓库：[SUD-GLOBAL/sud-gi-white-demo](https://github.com/SUD-GLOBAL/sud-gi-white-demo)。

## 运行

使用 JDK 17、Android SDK 37，最低 Android 8.0（API 26）。

GitHub 工程已包含 `app/libs/sud-gi-white.aar`，第三方依赖在 `app/build.gradle.kts` 中声明。

1. 将 `app/demo.local.properties.example` 复制为 `app/demo.local.properties`，填写自己的 SUD AppID、AppKey。
2. 在 `app/demo.gradle` 中设置应用包名及 `SUDGIWhiteApp`，与申请的应用配置一致。
3. 用 Android Studio 打开工程，运行 `app`；也可执行 `./gradlew :app:assembleDebug`。

聚合包为 PRO 环境，使用正式环境凭据。

努比亚 Maven 下载凭据配置在用户级 `~/.gradle/gradle.properties` 的 `nubia.maven.username`、`nubia.maven.password`，也可通过 `NUBIA_MAVEN_USERNAME`、`NUBIA_MAVEN_PASSWORD` 环境变量提供。

本地凭据和签名文件不提交到 Git。

## 初始化

`SUDWhiteDemoApplication` 使用公共接口初始化，桌面入口由 White 提供。需要调整实名认证、个人资料只读或页面上限时，通过带 `SUDGIWhiteConfig` 的初始化重载设置。

## 打开游戏

在前台 Activity 中调用：

```java
SUDGIWhite.openHome(activity);
SUDGIWhite.openGame(activity, gameId);
```

`SUDGIWhiteApp = "whitedemo"` 对应以下两种链接：

- App Links：`https://app.sud.link/whitedemo/white/{gameid}`
- Deep Link：`whitedemo://white/{gameid}`

App Links 需使用已完成域名关联的应用标识、包名和签名。已有链接路由的宿主可使用 `SUDGIWhite.handleGameLink(activity, uri)`。

游戏状态订阅使用 `observeGames`，页面结束时取消订阅。`closeGame` 默认关闭最近启动的指定游戏，也可传入 `LATEST`、`OLDEST` 或 `ALL`。

## 分享和桌面

`shareGame` 打开分享入口；`requestPinGameShortcut` 请求添加桌面；`queryGameShortcut` 查询桌面状态。游戏右上角菜单提供相应操作。

## 登录和支付配置

使用努比亚登录时，修改 `app/src/main/res/values/sud_gi_white_config.xml` 中的登录渠道并填写参数：

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string-array
        name="sud_gi_white_login_providers"
        translatable="false">
        <item>nubia</item>
    </string-array>
    <string name="sud_nubia_login_environment" translatable="false">RELEASE</string>
    <string name="sud_nubia_login_app_id" translatable="false"></string>
    <string name="sud_nubia_login_app_key" translatable="false"></string>
    <string name="sud_nubia_login_redirect_uri" translatable="false"></string>
</resources>
```

支付宝使用正式环境，无需填写客户端 AppID。微信支付在同一个 XML 中填写 `sud_gi_white_payment_wechat_app_id`，其包名、签名须与微信开放平台登记一致。
