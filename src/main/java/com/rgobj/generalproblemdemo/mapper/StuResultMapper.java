package com.rgobj.generalproblemdemo.mapper;

import com.rgobj.generalproblemdemo.bean.StuResultBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nekotaku
 * @create 2021-05-23 22:36
 */
@Mapper
@Repository
public interface StuResultMapper {

    //添加数据
    public int add(StuResultBean stuResultBean);

    //查询
    public List<StuResultBean> queryAllByName(String stu_username);

    //删除
    public int deleteBySelect(String stu_username,String stu_finishtime);
}
