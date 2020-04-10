package controller;

import Util.InputUtil;
import view.InputView;

public class PosController{
    public static void start(){
        try{
            final String featInput = InputView.inputFeatNumber();
            final int featNumber = InputUtil.convertNumber(featInput);
        }catch (NumberFormatException e){
            System.out.println("잘못된 값입니다. 다시 입력해주세요.");
        }
    }
}
