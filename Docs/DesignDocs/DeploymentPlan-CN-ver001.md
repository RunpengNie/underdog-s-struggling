# **部署方案**

ver001 / 2026-08-16

## 1. 前提条件

- 预算：第一步 0 成本，第二步每月 5 美元以内，第三步上正经云服务（AWS/Azure）
- 域名：先用平台的免费二级域名（如 xxx.vercel.app）
- 访问者：大陆和海外都有

## 2. 三步走

| 步骤 | 用途 | 后端跑在哪 | 成本 |
| --- | --- | --- | --- |
| 一 | 本地运行，仅开发期用 | Ubuntu 虚拟机，裸跑 | 0 |
| 二 | 小规模上线，初步公开 | 境外 VPS，Docker | ≤ $5/月 |
| 三 | 正式部署 | 见 DesignDoc 里的 AWS 方案 | 待定 |

先裸跑把功能跑通，要迁到第二步之前再补 Docker。

前端从第一步起先放 Vercel 免费档。

## 3. 第一步：本地运行（开发期）

#### (1) 组成
- 前端：Vercel Hobby，域名 xxx.vercel.app
- 后端：Ubuntu 虚拟机，`java -jar` 直接跑，:8080
- 数据库：同一台虚拟机，`apt install mysql-server`，只监听 localhost
- 对外暴露：Cloudflare Tunnel

环境依赖仅 openjdk-17-jdk 与 mysql-server，构建后以 `java -jar` 启动，不引入 Docker。

#### (2) 对外暴露方式
本机跑 cloudflared，主动向 Cloudflare 建出站连接，外部请求由 Cloudflare 转发回本机。cloudflared 装在 Ubuntu 虚拟机里，或装在 Windows 宿主机上指向虚拟机 IP，两种都行。家宽无公网 IPv4 也能用，不必配路由器端口映射，HTTPS 证书由 Cloudflare 签发。

该方式只用于开发期，公开后转第二步，风险见第 8 节。

#### (3) 拓扑
```
浏览器
  ├── https://xxx.vercel.app ──► Vercel（Next.js 前端）
  └── https://xxx.trycloudflare.com
          └──► Cloudflare 边缘 ──(出站隧道)──► Ubuntu 虚拟机
                                                        ├── java -jar :8080
                                                        └── mysqld    :3306
```

#### (4) 前端托管

Vercel 是 Next.js 官方团队的托管平台，Hobby 为其免费个人套餐。前端代码推到 GitHub 后授权 Vercel 连接仓库，每次 push 自动构建并发布，无需自建服务器、配置 Nginx 或申请证书。

免费档额度：
- 域名 xxx.vercel.app，自带 HTTPS
- 每月 100GB 流量，全球 CDN
- 每个 PR 自动生成预览地址
- 支持 Next.js 的 SSR / API Routes

备选为 **Cloudflare Pages**：同样支持 Next.js，构建次数受限但不限流量、无商业用途限制，且与本方案的 Cloudflare Tunnel / DNS 共用控制台。引入广告后以其为主。

## 4. 第二步：小规模上线

#### (1) 组成
- 前端：Vercel Hobby，不变
- 后端：境外 VPS，Docker
- 数据库：与后端同机，Docker MySQL 8 + 数据卷，配 mysqldump 定时备份
- DNS / HTTPS / 基础 WAF：Cloudflare 免费档

数据库自建在同一台机器，不用托管数据库，省钱且延迟低，代价是备份要自己管。

#### (2) 服务器候选
- Oracle Cloud Always Free（日本区，ARM）：$0，配置高，但常年缺货
- RackNerd 年付 VPS（洛杉矶）：约 $15/年，对大陆访问较友好
- Hetzner CX22：约 €3.79/月，机房在欧洲，大陆访问差
- Railway / Render 入门档：省运维，但容易超预算

优先 Oracle，无法开通时以年付 VPS 保底。

## 5. 实施步骤

#### (1) 本地裸跑
1. Ubuntu 虚拟机装 openjdk-17-jdk、mysql-server，建库并建专用数据库账号（不用 root）
2. 配置外置：JWT secret、数据库账号密码改由环境变量注入，仓库内不再留明文，并轮换已泄露的 secret
3. `mvn package` 打 jar，`java -jar` 启动，验证 POST /api/auth/login 能返回 token
4. 配 systemd 服务，开机自启、崩溃自动重启

#### (2) 第一步上线
5. 装 cloudflared，建 tunnel 指向虚拟机 8080
6. 前端仓库接入 Vercel（或 Cloudflare Pages），push 自动构建发布，API 地址指向 tunnel 域名
7. 后端放行前端域名的 CORS
8. 按第 7 节验收标准跑一遍

#### (3) 容器化（迁移前才做）
9. 后端加 Dockerfile，多阶段构建，运行期用 eclipse-temurin:17-jre
10. 写 docker-compose.yml：app + mysql:8 + 命名数据卷，敏感配置走 .env
11. 本地 `docker compose up` 跑一遍，确认和裸跑行为一致

#### (4) 迁到第二步
12. 开 VPS，装 Docker，关掉密码登录只留密钥，配基础防火墙
13. 传 docker-compose.yml，`docker compose up -d`
14. 旧库 mysqldump 导出，导入新库
15. Cloudflare 接管 DNS、HTTPS、WAF，前端 API 地址切到新域名
16. 配 mysqldump 定时备份，并演练一次恢复

## 6. 涉及文件

| 文件 | 变更 |
| --- | --- |
| application.properties | 密钥、数据库配置改环境变量 |
| SpringSecurityConfig.java | 加 CORS，放行前端域名 |
| Dockerfile | 新增，步骤 (3) 才做 |
| docker-compose.yml | 新增，放仓库根目录，步骤 (3) 才做 |
| .env.example | 新增，列出所需环境变量名，不含真实值 |

## 7. 验收标准

- 手机 4G（不连家里 WiFi）打开前端域名，能登录并拉到词条列表
- 地址栏 HTTPS 证书有效
- 后端重启后数据不丢（容器化后额外验：`docker compose down` 再 `up` 数据还在）
- 境内、海外网络各测一次首屏加载耗时，记为基线

## 8. 薄弱环节

#### (1) 家宽 + Cloudflare Tunnel（仅第一步）
- 笔记本断电断网即下线
- 家宽上行一般只有 30–50 Mbps，并发能力有限
- 部分 ISP 协议禁止家宽建站，存在被限速或停服的风险
- 笔记本成为暴露在公网上的攻击面
- 缓解：严格限定为开发期，一旦对外公开立即转第二步

#### (2) 前端托管
- Vercel Hobby 仅限个人非商业用途，里程碑 (4) 引入广告后需升 Pro（$20/月）或迁 Cloudflare Pages
- serverless 函数有执行时长上限
- 大陆访问速度不稳定

#### (3) 单机单实例（第二步）
- 应用与 MySQL 同机，无冗余，机器宕机即全站不可用
- 无自动扩缩容，流量突增只能手动升配
- 备份靠自建 mysqldump，恢复流程需实际演练过才算数
- 若机型仅 1 GB 内存，JVM 与 MySQL 争抢内存，易被 OOM Killer 杀进程

#### (4) 大陆访问
- 无 ICP 备案，只能用境外节点，大陆首屏耗时不可控，线路质量取决于当时的国际出口状况

#### (5) 安全与密钥
- 当前 JWT secret 明文写在 application.properties 且已进入 git 历史，数据库为 root + 空密码；改环境变量的同时必须轮换密钥，仅改配置不算修复
- JwtAuthenticationFilter 尚未挂进 SecurityFilterChain，JWT 校验实际未生效，接口鉴权形同虚设
- 第二步之前只有 Cloudflare 免费档的基础防护，无限流、无告警

#### (6) 成本与供应商
- Oracle Always Free 常年缺货，大概率被迫走年付 VPS，成本从 $0 变为约 $15/年
- 免费档策略随时可能调整，全链路无 SLA

## 9. 本方案不做的事

- 不上 Kubernetes、多实例、自动扩缩容
- 第一、二步不用 AWS S3 + CloudFront，那是第三步的事
- 不做 ICP 备案，不用大陆境内服务器
- 不买自有域名
- 不用托管数据库

## 10. 待定

- 小内存机型的 JVM 调优：若最终机型仅 1 GB 内存，需以 -Xmx384m 之类限制堆，并调小 MySQL buffer pool。是否并入步骤 (1) 待定
- 前端第一版只做只读展示页，登录相关推至第二步
