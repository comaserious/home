package com.lee.run;

import com.lee.common.MenuDTO;

import java.util.List;

public class PrintResult {
    public void printList(List<MenuDTO> menuList) {
        if(menuList!=null && menuList.size()>0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("해당 가격대의 메뉴가 존재하지 않습니다");
        }
    }
}
