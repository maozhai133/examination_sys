package com.rgobj.generalproblemdemo;

import com.rgobj.generalproblemdemo.bean.StuUserBean;
import com.rgobj.generalproblemdemo.mapper.StuUserMapper;
import com.rgobj.generalproblemdemo.service.StuUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class GeneralproblemdemoApplicationTests {

//    @Autowired
//    StuUserService stuUserService;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        connection.close();
    }

    @Autowired
    StuUserMapper stuUserMapper;
    @Test
    public void toTest(){
        List<StuUserBean> stuUserBeans = stuUserMapper.queryAll();
        stuUserBeans.forEach(e ->System.out.println(e));
    }
}
