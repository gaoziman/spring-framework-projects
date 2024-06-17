package org.javatop.orginal.dao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-06-17 17:00
 * @description :
 */
public class DemoDaoImpl implements DemoDao {


    @Override
    public List<String> findAll() {
        // 此处应该是访问数据库的操作，用临时数据代替
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}
