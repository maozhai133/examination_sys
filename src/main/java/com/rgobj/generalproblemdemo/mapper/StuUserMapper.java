package com.rgobj.generalproblemdemo.mapper;

import com.rgobj.generalproblemdemo.bean.StuUserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nekotaku
 * @create 2021-05-04 20:55
 */

@Mapper
@Repository
public interface StuUserMapper {

    //查询
    public List<StuUserBean> queryAll();

    //添加数据
    public int add(StuUserBean stuUserBean);

    //根据用户查询数据
    public StuUserBean queryByName(String username);

    //用户密码验证
    public StuUserBean loginCheck(String username,String password);
}
