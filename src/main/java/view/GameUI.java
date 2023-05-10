package view;

import Util.Print;
import controller.EnhancementController;
import model.*;

import java.util.Scanner;

public class GameUI {
  public static void main(String[] args) {
    Weapon weapon;
    
    /*스캐너*/
    Scanner scanner = new Scanner(System.in);

    /*게임시작*/
    // 1.게임 시작 메소드 호출
    Print.gameStart();

    /*입력값*/
    //3. 콘솔창에 입력 주기
    int choice = scanner.nextInt();

    //TODO:Weapon 객체를 생성하고, 선택한 무기에 따라 weapon 변수에 할당하고, 올바르지 않은 입력이라면 게임을 종료시키세요.
    //4. 콘솔창에 받은 입력에 따라 객체 생성 웨폰 클래스로 넘어감
    if(choice == 1){
      weapon = new Bow("활",10);
    }
    else if(choice == 2){
      weapon = new Staff("스태프",8);
    }
    else if(choice == 3){
      weapon = new Sword("검",15);
    }
    else if(choice == 4){
      weapon = new Mace("둔기",12);
    }
    else{
      System.out.println("올바른 값 입력 해주세요. 게임을 종료합니다.");
      return;
    }
    
    //TODO:컨트롤러 객체를 생성하세요.
    EnhancementController controller = new EnhancementController();

    /*게임 강화 코드*/
    //6. 선택한 무기를 객체로 만들고 다음 선택지 고르기
    while (!weapon.isBroken()) {
      System.out.println("무기를 강화하시겠습니까? (yes/no)");
      String response = scanner.next();


      if (response.equalsIgnoreCase("yes")) {
        //TODO:컨트롤러 객체를 이용해 무기를 강화하는 메소드를 호출하고, 무기 변수를 파라미터로 전달하세요.
        //7 yes 입력시 강화 메소드 실행
        controller.enhanceWeapon(weapon);
      } else {
        System.out.println(
            "게임을 종료합니다. 무기 최종 스텟\n강화단계 : "
                + weapon.getEnhancementLevel()
                + "\n무기 공격력 :  "
                + weapon.getAttackPower());
        break;
      }
    }
  }
}
