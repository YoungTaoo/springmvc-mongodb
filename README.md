**springmvc-mongodb**
    `在学习mongoDB的nosql后就想试着将其整合到我目前接触最多的spingmvc中来，所以就试着搭建。
    第一部分： 目前做了获取数据到MongoDB数据库中，后续我会将自己学到的东西或者技术集成到该项目中。项目目前并未做MongoDB
的复制（副本集），后续会尝试着搭建有关副本集。 在搭建过程中有一些东西值得自己去留心，如下：
    1、mongoDB集成到springMVC的时候采取提供统一的访问bean工程------org.springframework.data.mongodb.core.MongoTemplate。
其实很好理解，就类似于mybites统一访问dao是一样的性质。
    2、建议在创建分层的包名的时候区分model与entity，之前看到有些项目model就是entity，我之前的公司是分为controller、
service、dao、entity层的，但是按照 目前我知道的集成mongoDB的MongoTemplate会根据类名进行相应的创建数据库下的集合名称。
所以建议是将存储数据model和entity层分开。
    3、在入门的时候就知道了mongoDB在插入数据的时候如果集合不存在的时候会自动创建集合，和springMVC集成后，在配置文件里指
定的数据库，如果你的mongoDB不存在 那么会自动帮你创建。 
    4、网络上有很多mongoDB数据库客户端工具，推荐的也各不相同。自己用的可能功能没那么强大，但是页面足够看着舒服就用了：
Robo 3T 1.1.1。`