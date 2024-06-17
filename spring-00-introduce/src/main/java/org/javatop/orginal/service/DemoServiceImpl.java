package org.javatop.orginal.service;

import org.javatop.orginal.dao.DemoDao;
import org.javatop.orginal.factory.BeanFactory;

import java.util.List;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-06-17 17:01
 * @description :
 */
public class DemoServiceImpl implements DemoService {

    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");


    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }

    public DemoServiceImpl() {
        for (int i = 0; i < 10; i++) {
            System.out.println(BeanFactory.getBean("demoDao"));
        }
    }
}
