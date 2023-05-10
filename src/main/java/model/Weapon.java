package model;

import Util.Print;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weapon {
  private String name;
  private int enhancementLevel = 0;
  private boolean isBroken = false;
  private int attackPower;

  //5. 게임뷰에서 무기를 선택하면 생성자 매개변수에 인자값을 넣어준다
  public Weapon(String name, int attackPower) {
    this.name = name;
    this.attackPower = attackPower;
  }

  //TODO:"적절한 예외처리 방법을 선택해 메소드를 호출한 곳에 예외를 전달하세요."

  //9 강화 로직 실행
  public void enhance() throws Exception{
    //조건문이라 순번 안넣음 강화 레벨이 15 거나 더크면 예외 로직 실행
    if (enhancementLevel >= 15) {
      //TODO:"최고 강화단계에 도달했습니다. 게임에서 승리했습니다."는 예외을 전달하세요.
      throw new Exception("최고 강화단계에 도달했습니다. 게임에서 승리했습니다.");
    }
    double successRate = 1.0 - (enhancementLevel * 0.03);
    double Failure = 1.0 - (enhancementLevel * 0.06);
    if (Math.random() < successRate) {
      this.enhancementLevel += 1;
      this.attackPower += 10;
      //10 예를들어 강화를 성공했다하면 콘솔창에 성공 입력하기 그리고 6번에 while 문이 true 면 다시 돌아가서 반복실행
      Print.printSuccess(
          "축하합니다! 강화에 성공했습니다!!\n" + "강화단계 : " + enhancementLevel + "\n공격력 " + attackPower);
    }
    else if(Math.random() < Failure){
      this.enhancementLevel -= 1;
      this.attackPower -= 10;
      Print.printFailure(
              "아쉽습니다... 강화에 실패했습니다...\n" + "강화단계 : " + enhancementLevel + "\n공격력 " + attackPower);
    }
    else {
      this.isBroken = true;
      Print.printFailure("강화에 실패하여 무기가 파괴되었습니다.");
      Print.printGameOver();

      //TODO:"게임을 종료합니다" 는 예외를 전달하세요.
      throw new Exception("게임 종료");
    }
  }
}
