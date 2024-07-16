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

				String[] cmdBits = cmd.split(" "); //리턴 타입 String array
		
				//cmdBits[2] -> 2
				//cmdBits[2] -> asd
				//cmdBits[2] 값이 형변환이 가능한지 아닌지
				
				int id = 0;
				
				try { //예외처리
					id = Integer.parseInt(cmdBits[2]); //정수로 형 변환 
				} catch (NumberFormatException e) {
					System.out.println("명령어가 올바르지 않습니다.");
					continue;
				} catch (Exception e) { //모든예외처리 
					System.out.println("error : " + e);
				}
				
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
				
				System.out.printf("번호 : %d\n",foundArticle.id);
				System.out.printf("제목 : %s\n",foundArticle.title);
				System.out.printf("내용 : %s\n",foundArticle.body);
				
				
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

