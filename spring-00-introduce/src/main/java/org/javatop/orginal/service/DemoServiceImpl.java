package org.javatop.orginal.service;

import org.javatop.orginal.dao.DemoDao;
import org.javatop.orginal.dao.DemoDaoImpl;

import java.util.List;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-06-17 17:01
 * @description :
 */
public class DemoServiceImpl implements DemoService {

    private DemoDao demoDao = new DemoDaoImpl();

    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
