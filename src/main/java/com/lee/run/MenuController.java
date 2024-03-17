package com.lee.run;

import com.lee.common.MenuDTO;

import java.util.*;

public class MenuController {
    
    private final MenuService menuService;
    private final PrintResult printResult;
    
    public MenuController(){
        
        menuService = new MenuService();
        printResult = new PrintResult();
    }
    public void ifSub() {
        Scanner scr = new Scanner(System.in);
        
        do {
            
            System.out.println("========================================");
            System.out.println("1. 원하는 금액대에 적합한 추천메뉴 목록 보여주기");
            System.out.println("2. 메뉴 이름 or 카테고리명으로 검색하여 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("메뉴를 선택하세요 : ");
            int no = scr.nextInt();
            switch (no){
                case 1 : 
                    List<MenuDTO> menuList=menuService.selectMenuByPrice(inputPrice());
                    printResult.printList(menuList);
                    break;
                case 2 :
                    List<MenuDTO> menuDTOS = menuService.selectMenuByNameOrCategory(inputNameOrCategory());
                    printResult.printList(menuDTOS);
                    break;
                case 9 : return;
                
            }
        
        }while(true);
        
    }

    private Map<String,String> inputNameOrCategory() {

        Scanner scr = new Scanner(System.in);
        Map<String,String> parameter = new HashMap<>();
        System.out.print("메뉴 이름으로 입력 하실려면 name category 명으로 조회하려면 category를 입력하세요 : ");
        String condition = scr.nextLine();
        String value ;
        if(condition.equals("name")){
            System.out.print("검색하실 메뉴의 이름을 적으세요 : ");
            value = scr.nextLine();
            parameter.put("name",value);

        }else if (condition.equals("category")){
            System.out.print("검색하실 카테고리명을 입력하세요 : ");
            value = scr.nextLine();
            parameter.put("category",value);
        }
        return parameter;
    }

    private Map<String,Integer> inputPrice() {
        Scanner scr = new Scanner(System.in);
        System.out.print("원하는 가격대의 최고 금액을 적으세요 : ");
        int price = scr.nextInt();

        Map<String,Integer> parameter = new HashMap<>();
        parameter.put("price",price);

        return  parameter;

    }

    public void chooseSub() {
        Scanner scr = new Scanner(System.in);
        
        do {
        System.out.println("=========================================");
        System.out.println("1. 카테고리 상위 분류별 메뉴 보여주기 (식사, 음료, 디저트)");
        System.out.println("9. 이전 메뉴로 돌아가기");
        System.out.print("메뉴 번호를 입력해주세요 : ");
        int no = scr.nextInt();
        switch (no){
            case 1 : 
                List<MenuDTO> menuList=menuService.selectMenuBySupCategory(inputSupCategory());
                printResult.printList(menuList);
                break;
            case 9 : return;
        }
        }while(true);
    }

    private Map<String,String> inputSupCategory() {
        Scanner scr = new Scanner(System.in);
        System.out.print("검색할 상위 카테고리를 입력하세요 (식사/음료/디저트) : ");
        String supCate = scr.nextLine();
        Map<String,String> parameter = new HashMap<>();
        parameter.put("supCategory",supCate);
        return parameter;
    }

    public void foreach() {

        Scanner scr = new Scanner(System.in);

        do {
            System.out.println("======================================");
            System.out.println("1. 랜덤한 메뉴 5개 조회하기");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("메뉴를 선택해주세요 : ");
            int no = scr.nextInt();
            switch (no){
                case 1 :
                    List<MenuDTO> menuList = menuService.selectMenuByRandom(inputRandom());
                    printResult.printList(menuList);
                    break;
                case 9 : return;

            }

        }while(true);
    }

    private Map<String,List<Integer>> inputRandom() {
        Map<String,List<Integer>> randomArr = new HashMap<>();
        Set<Integer> random5 = new HashSet<>();
        while(random5.size()<5){
            random5.add((int)(Math.random()*22)+1);
        }
        List<Integer> ranArr = new ArrayList<>(random5);
        Collections.sort(ranArr);

        randomArr.put("randomNumbers",ranArr);

        return randomArr;



    }

    public void trimSub() {
        Scanner scr = new Scanner(System.in);
        do {
            System.out.println("1. 검색조건이 있는 경우 메뉴코드로 조회, 단 없으면 전체 조회");
            System.out.println("2. 메뉴 혹은 카테고리 코드로 검색, 단 메뉴와 카테고리 고드 둘다 일치 하는경우도 검색, 검색 조건이 없는 경우 전체 조회");
            System.out.println("3. 원하는 메뉴 정보만 수정하기");
            System.out.println("9. 이전 메뉴로 ");
            System.out.print("메뉴를 선택하세요 : ");
            int no = scr.nextInt();

            switch (no){
                case 1 :
                    List<MenuDTO> menuList =menuService.selectMenuOneOrAll(inputMenuCode());
                    printResult.printList(menuList);
                    break;
                case 2 :
                    List<MenuDTO> menuDTOS = menuService.selectOneOrAllByNameOrCategory(inputSome());
                    printResult.printList(menuDTOS);
                    break;
                case 3 : break;
                case 9 : return;
            }


        }while(true);

    }

    private Map<String,Object> inputSome() {
        Scanner scr = new Scanner(System.in);
        Map<String,Object> parameter= new HashMap<>();

            System.out.println("1. 메뉴로 검색");
            System.out.println("2. 카테고리코드로 검색");
            System.out.println("3. 둘다 검색");
            System.out.println("4. 전체 조회");
            System.out.print("선택한 메뉴를 입력하세요 : ");
            int no = scr.nextInt();
            String name;
            int category;
            switch (no){
                case 1 :
                    System.out.print("검색할 메뉴이름을 입력하세요 : ");
                    scr.nextLine();
                    name = scr.nextLine();
                    parameter.put("name",name);
                    break;
                case 2 :
                    System.out.print("검색할 카테고리 코드를 입력하세요 : ");
                    category = scr.nextInt();
                    parameter.put("category",category);
                    break;
                case 3 :
                    System.out.print("검색할 메뉴이름을 입력하세요 : ");
                    scr.nextLine();
                    name = scr.nextLine();
                    System.out.print("동시에 검색할 카테고리 코드를 입력하세요 : ");
                    scr.nextLine();
                    category = scr.nextInt();
                    parameter.put("name",name);
                    parameter.put("category",category);



                    break;
                case 4 :break;

            }

            return parameter;
    }

    private Map<String,Integer> inputMenuCode() {

        Scanner scr = new Scanner(System.in);
        Map<String,Integer> parameter = new HashMap<>();
        System.out.println("검색조건이 있으면 yes 그렇지 않으면 no");
        String answer = scr.nextLine();
        if(answer.equals("yes")){
            System.out.println("검색할 메뉴코드를 입력하세요 : ");
            String code = scr.nextLine();
            int value = Integer.parseInt(code);
            parameter.put("menuValue",value);
        }

        return parameter;
    }
}
