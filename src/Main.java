import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
article write를 통해 게시물이 작성되면 
- 사용자가 입력한 제목, 내용의 데이터를 가진 게시물이 저장되어야 한다.
- 게시물로 저장할 데이터에는 제목, 내용 그리고 번호가지 포함을 시켜야 한다
- 저장된 게시물들의 데이터를 article list시에 보여줄 수 있어야 하므로, 
서로 다른 조건 부분에서 공통으로 접근 할 수 있는 무언가가 필요할 것

article list를 했을 때 실제로 작성된 게시물의 목록이 나오도록
게시물이 2개 존재할 때의 예시
번호    |		제목
2		|		제목2
1		|		제목3
> 반복문을 돌려서 list에 들어있는 것을 하나하나 보여준다.

명령어가 article list

1. 제목, 내용을 입력받아서 변수에 저장

2. 변수는 값을 하나밖에 가지지 못하기 때문에 게시물들에 대한 처리가 불가능하구나

3. 복수의 데이터를 처리하기 위해서 무엇을 사용해야 하는가? >객체사용

4. list를 사용해서 게시물들에 대한 데이터를 저장해두면 되겠구나

5. 게시물이라는 데이터 타입을 생성해서 번호, 제목, 내용 데이터를 저장해야겠다.

6. 계시물이라는 타입을 생성해서 객체로 활용할 때 연관성 부분에 문제가 없으니
정말로 생성해도 되겠구나


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

