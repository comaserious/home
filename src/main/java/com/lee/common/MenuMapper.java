package com.lee.common;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
    List<MenuDTO> selectMenuByPrice(Map<String, Integer> parameter);

    List<MenuDTO> selectMenuByNameOrCategory(Map<String, String> parameter);

    List<MenuDTO> selectMenuBySupCategory(Map<String, String> parameter);

    List<MenuDTO> selectMenuByRandom(Map<String, List<Integer>> stringListMap);

    List<MenuDTO> selectMenuOneOrAll(Map<String, Integer> parameter);

    List<MenuDTO> selectOneOrAllByNameOrCategory(Map<String, Object> parameter);
}
