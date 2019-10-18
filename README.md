# Oh-Today

> today hot movie music short-video

[Demo Site](http://today.songkaizong.top) 

### 使用说明

**物理机**

- 需要安装java8 及以上 环境

- 需要安装maven

- 测试 导入 idea 点击 OhTodayApplication.java main 方法即可 

- 打成jar包 mvn package -Dmaven.test.skip=true 

- 运行 java -jar oh-today-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod

**docker**

docker run yangrd/oh-today -p 8080:8080 -name oh-today


### 接口说明:

#### 获取所有站点

    
**简要描述：** 

-  获取所有站点

**请求URL：** 
- ` http://xx.com/sites `
  
**请求方式：**
- GET 

**参数：** 

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|page |否  |number |页码 默认第一页为0   |
|size |否  |number | 每页条数 默认值20    |

 **返回示例**
```
{
	"content": [{
		"id": 1,
		"icon": "https://www.v2ex.com/favicon.ico",
		"name": "V2EX",
		"scheme": "https",
		"host": "www.v2ex.com",
		"description": "V2EX",
		"bgImg": "",
		"createdTime": "2019-10-18T10:37:44.885"
	}],
	"totalPages": 1,
	"totalElements": 1
}
```
 **返回参数说明** 


|参数|类型|描述|
|:-------|:-------|:-------|
| - content |object  | 内容 |
| id | number| id |
| icon | string| 网站图标 |
| name | string| 名称 |
| scheme | string| scheme |
| host | string| host |
| description | string| 描述 |
| bgImg | string| 背景图 |
| createdTime | string| 创建时间 |
| totalPages | number| 总页数 |
| totalElements | number| 总条数 |


#### 获取站点文章


    
**简要描述：** 

-  获取站点文章

**请求URL：** 
- ` http://xx.com/articles `
  
**请求方式：**
- GET 

**参数：** 

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|page |否  |number |页码 默认第一页为0   |
|size |否  |number | 每页条数默认值50    |
|siteId |否  |number |   站点id  |

 **返回示例**
```
{
	"content": [{
		"id": "",
		"thumb": "",
		"title": "",
		"resourceUrl": "",
		"siteInfo": {
			"id": 0,
			"name": "",
			"icon": ""
		},
		"createdTime": "2019-10-18 09:45:23"
	}],
	"totalPages": 1,
	"totalElements": 1
}
```
 **返回参数说明** 
 
|参数|类型|描述|
|:-------|:-------|:-------|
| - content | Array  | 内容列表 |
| id | string| id |
| thumb | string| 缩略图 |
| title | string| 标题 |
| resourceUrl | string| 地址 |
| - - siteInfo |object  | 网站信息 |
| id | number| id |
| name | string| 名称 |
| icon | string| 图标 |
| createdTime | date | 创建时间 |
| totalPages | number| 总页数 |
| totalElements | number| 总条数 |


### 周边:

[oh-today-web (Vue)](https://github.com/oh-today/oh-today-web)
