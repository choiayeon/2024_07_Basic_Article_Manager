import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작==");
		
		Scanner sc = new Scanner(System.in);
		
		int lastArticleId = 0; //while문 안에 있으면 값이 최기화 됨 
		
		while (true) {
			System.out.printf("명령어) ");
			
			String cmd = sc.nextLine().trim();
			// cmd = cmd.trim();
			
			//trim : 앞뒤 공백을 제거함 > 중간에 있는 공백은 제거하지 못함
			
			
			//equals > 순수한 값 비교
			// == > 주소 비교
			//null은 공백이 아니다.
			
			
			if (cmd.equals("exit")) {
				//cmd.trim().equals("exit")
				//맨 위에 두는 것이 좋음
				//굳이 묶어두지 않아도 됨
				
				break;
			}
			
			if (cmd.equals("")) {
				System.out.println("명령어를 입력해 주세요");
			}
			
			
			else if (cmd.equals("article write")) {
				System.out.printf("제목: ");
				sc.nextLine();
				
				System.out.printf("내용: ");
				sc.nextLine();
				
				System.out.println(++lastArticleId + "번 글을 생성합니다.");
				// ++id : 증가후 출력
			}
			
			else if (cmd.equals("article list")) {
				System.out.println("게시글이 없습니다.");
			}
			
			else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
			// if ,else if ,else로 한덩어리로 묶지 않고 else만 적어도 결과가 제대로 출력됨
			// 하지만 else를 마지막에 쓰지 않고 중간에 쓰면 else문이 같이 나오는 오류 발생
			
		}
		
		System.out.println("==프로그램 종류==");
	}

}
