package com.lee.run;

import com.lee.common.MenuDTO;
import com.lee.common.MenuMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.lee.common.Template.getSqlSession;

public class MenuService {
    private MenuMapper mapper;
    public List<MenuDTO> selectMenuByPrice(Map<String, Integer> parameter) {

        SqlSession session = getSqlSession();
        mapper = session.getMapper(MenuMapper.class);

        return mapper.selectMenuByPrice(parameter);
    }

    public List<MenuDTO> selectMenuByNameOrCategory(Map<String, String> parameter) {
        SqlSession session = getSqlSession();
        mapper =session.getMapper(MenuMapper.class);

        return  mapper.selectMenuByNameOrCategory(parameter);
    }

    public List<MenuDTO> selectMenuBySupCategory(Map<String, String> parameter) {

        SqlSession session = getSqlSession();
        mapper = session.getMapper(MenuMapper.class);
        return mapper.selectMenuBySupCategory(parameter);

    }

    public List<MenuDTO> selectMenuByRandom(Map<String, List<Integer>> stringListMap) {
        SqlSession session = getSqlSession();
        mapper = session.getMapper(MenuMapper.class);

        return mapper.selectMenuByRandom(stringListMap);
    }

    public List<MenuDTO> selectMenuOneOrAll(Map<String, Integer> parameter) {

        SqlSession session = getSqlSession();
        mapper = session.getMapper(MenuMapper.class);
        return mapper.selectMenuOneOrAll(parameter);
    }

    public List<MenuDTO> selectOneOrAllByNameOrCategory(Map<String, Object> parameter) {
        SqlSession session = getSqlSession();
        mapper =session.getMapper(MenuMapper.class);
        return mapper.selectOneOrAllByNameOrCategory(parameter);
    }
}
