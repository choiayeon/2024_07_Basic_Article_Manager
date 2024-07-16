import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*

게시물 상세보기

(2번 게시물이 존재하는 경우)

article detail 2

(2번 게시물이 존재하지 않는 경우)

사용자가 원하는 게시물이 있나 없나 검증

게시물은 어디에 저장되고 있나



*/
public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작==");
		
		Scanner sc = new Scanner(System.in);
		
		int lastArticleId = 0; //while문 안에 있으면 값이 최기화 됨 
		
		List<Article> articles = new ArrayList<>();
		
	
		
		while (true) {
			System.out.printf("명령어) ");
			
			String cmd = sc.nextLine().trim();
			
			if (cmd.equals("exit")) {
	
				break;
			}
			
			if (cmd.length() == 0) {
				// cmd.equals("")
				System.out.println("명령어를 입력해 주세요");
				continue; //밑으로 내려가면 else를 만나기 때문에 처음으로 올라감
			}
			
			
			if (cmd.equals("article write")) {
				
				System.out.printf("제목: ");
				String title = sc.nextLine();
				
				System.out.printf("내용: ");
				String body = sc.nextLine();
				
				lastArticleId++;
				
				Article article = new Article(lastArticleId,title,body);
				
				articles.add(article);
				
				System.out.println(lastArticleId + "번 글을 생성합니다.");
			}
			
			else if (cmd.equals("article list")) {
				
				if (articles.size()==0) {
					System.out.println("게시글이 없습니다.");
					continue;
					
				}
					
				System.out.println("번호	|	제목");
					
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d	|	%s\n", article.id,article.title);
					}
				
			}
			else if (cmd.startsWith("article detail ")) {
				//cmd.startsWith("article detail")
				//cmd가 가진 String값이 startsWtith메서드를 실행할때
				//넘겨주고 있는 인자값으로 시작하면 true 그렇제 않으면 false
				//article detail만 치면 입력을 받을때 trim이 있어 공백이 제거되
				//false를 반환한다.
				String[] cmdBits = cmd.split(" "); //리턴 타입 String array
				//split(" ") > 공백을 기점으로 String을 잘라냄
				//cmd.substring(3); > 리턴 타입 String
				//3번 인덱스 부터 데이터를 가져와라.
				int id = Integer.parseInt(cmdBits[2]);
				
//				int a = 0; // for문이 실행됬는지 판단하기 위한 변수
//				
//				for (Article article : articles) {
//					if (id == article.id) {
//						// == 은 둘이 타입이 다르기 때문에 (String,int) 안됨
//						// 올바른 값 비교  
//						//게시물이 가진 데이터는 이미 만들어진 데이터
//						// > 개발자의 입장에서 한번 재가공한 뒤 검증하겠다.
//						// > 데이터의 무결성이 보장되지 못한 상황이 된다.
//						System.out.printf("번호 : %d\n",article.id);
//						System.out.printf("제목 : %s\n",article.title);
//						System.out.printf("내용 : %s\n",article.body);
//						
//						a = 1; 
//					}
//				if( a == 0 ){
//					System.out.println(id + "번 게시물은 존재하지 않습니다.");
//					}
				
				Article foundArticle = null;
				
				for (Article article : articles) {
					if(id == article.id) {
						foundArticle =article;
						break;
					}
				
				}
				if (foundArticle == null) {
					System.out.println(id  + "번 게시물은 존재하지 않습니다." );
					continue;
				}
				
			}
			
			else {
				System.out.println("존재하지 않는 명령어 입니다");
			}

		}
		sc.close();
		
		System.out.println("==프로그램 종류==");
	}

}

class Article {
	int id;
	String title;
	String body;
	
	public Article(int id,String title,String body) { //생성자

		this.id = id;
		this.title = title;
		this.body = body;
			
	}

	
	
	
}

