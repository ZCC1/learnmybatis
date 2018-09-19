package com.test.learnmybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zcz.learnmybatis.dao.UserDao;
import com.zcz.learnmybatis.entity.User;

import junit.framework.Assert;

public class UserDaoTest {
	@Test
	public void finUserById() {
		//获取SqlSession
		SqlSession sqlSession = getSessionFactory().openSession();
		//获取UserDao实现类
		UserDao userMapper = sqlSession.getMapper(UserDao.class);
		//执行查询
		User user = userMapper.findUserById(1);
		Assert.assertNotNull("not find", user);
		
	}
	
	/**
	 * 获取SqlSessionFactory
	 * @return
	 */
	private static SqlSessionFactory getSessionFactory() {
		SqlSessionFactory sessionFactory = null;
		//配置文件名称
		String resource = "configuration.xml";
		try {
			//使用配置文件构造SqlSessionFactory
			sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sessionFactory;
	}
}
