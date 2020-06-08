package com.g7go.pagehelperdemo.demo.service.impl;

import com.g7go.pagehelperdemo.demo.dao.PersonsMapper;
import com.g7go.pagehelperdemo.demo.domain.Persons;
import com.g7go.pagehelperdemo.demo.service.PersonsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr_Lee
 * @date 2020-06-08 14:09
 */
@Service
@SuppressWarnings("ALL")
public class PersonsServiceImpl implements PersonsService {

    @Autowired
    private PersonsMapper personsMapper;

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<Persons> findAll() {

        //第一种，RowBounds方式的调用
        //List<Persons> list = sqlSession.selectList("com.g7go.pagehelperdemo.demo.dao.PersonsMapper.selectByExample", null, new RowBounds(0, 10));

        //第二种，Mapper接口方式的调用，推荐这种使用方式。
        Page<Persons> objects = PageHelper.startPage(1, 10);
        List<Persons> list = personsMapper.selectByExample(null);

        //第三种，参数方法调用
        //存在以下 Mapper 接口方法，你不需要在 xml 处理后两个参数
        //或者逆向工程生成的时候直接生成此类方法
        //配置supportMethodsArguments=true
        //List<Persons> list = personsMapper.selectByPageNumSize(null, 1, 10);

        //第五种，参数对象
        //如果 pageNum 和 pageSize 存在于 User 对象中，只要参数有值，也会被分页
        //有如下 Persons 对象
        //public class Persons {
        //    //其他fields
        //    //下面两个参数名和 params 配置的名字一致
        //    private Integer pageNum;
        //    private Integer pageSize;
        //}
        //存在以下 Mapper 接口方法，你不需要在 xml 处理后两个参数
        //public interface CountryMapper {
        //    List<Persons> selectByPageNumSize(Persons user);
        //}
        //当 user 中的 pageNum!= null && pageSize!= null 时，会自动分页
        //Persons persons = new Persons();
        //persons.setPageNum(1);
        //persons.setPageSize(10);
        //List<Persons> list = personsMapper.selectByPageNumSize2(persons);

        //第六种，ISelect 接口方式

        //jdk6,7用法，创建接口
        //Page<Persons> page = PageHelper.startPage(1, 10).doSelectPage(new ISelect() {
        //    @Override
        //    public void doSelect() {
        //        personsMapper.selectByExample(null);
        //    }
        //});
        //List<Persons> list = page.getResult();

        //jdk8 lambda用法
        //Page<Persons> page = PageHelper.startPage(1, 10).doSelectPage(() -> personsMapper.selectByExample(null));
        //List<Persons> list = page.getResult();
        //也可以直接返回PageInfo，注意doSelectPageInfo方法和doSelectPage
        //PageInfo<Persons> pageInfo = PageHelper.startPage(1, 10).doSelectPageInfo(new ISelect() {
        //    @Override
        //    public void doSelect() {
        //        personsMapper.selectByExample(null);
        //    }
        //});
        //List<Persons> list = pageInfo.getList();
        //对应的lambda用法
        //PageInfo<Persons>  pageInfo = PageHelper.startPage(1, 10).doSelectPageInfo(() -> personsMapper.selectGroupBy());

        //count查询，返回一个查询语句的count数
        //long total = PageHelper.count(new ISelect() {
        //   @Override
        //   public void doSelect() {
        //        personsMapper.selectByExample(null);
        //   }
        //});
        //lambda
        //total = PageHelper.count(() -> personsMapper.selectByExample(null));
        return null;
    }
}
