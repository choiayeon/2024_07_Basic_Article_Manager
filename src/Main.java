import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
조회수 기능

조회수 데이터는 어디에 저장되어 있어야 할까?

articles -> 각각의 article 
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
				
				Article article = new Article(lastArticleId,Util.getDateStr(),title,body,0);
				
				articles.add(article);
				
				System.out.println(lastArticleId + "번 글을 생성합니다.");
			}
			
			else if (cmd.equals("article list")) {
				
				if (articles.size()==0) {
					System.out.println("게시글이 없습니다.");
					continue;
					
				}
					
				System.out.println("번호	|	제목	|	작성일	|	조회수");
					
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d	|	%s	|	%s	|	%d\n", article.id,article.title,article.regDate,article.viewCnt);
					}
				
			}
			else if (cmd.startsWith("article detail ")) {

				String[] cmdBits = cmd.split(" "); //리턴 타입 String array
		
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
				
				foundArticle.viewCnt++;
				
				System.out.printf("번호 : %d\n",foundArticle.id);
				System.out.printf("작성일 : %s\n",foundArticle.regDate);
				System.out.printf("제목 : %s\n",foundArticle.title);
				System.out.printf("내용 : %s\n",foundArticle.body);
				System.out.printf("조회수 : %d\n",foundArticle.viewCnt);
				
			}
			else if (cmd.startsWith("article modify ")) {

				String[] cmdBits = cmd.split(" "); //리턴 타입 String array
		
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
					if (id == article.id) {
						foundArticle = article;
						break;
					}
				}
				
				if (foundArticle == null) {
					System.out.println(id  + "번 게시물은 존재하지 않습니다." );
					continue;
				}
				//수정할 제목과 내용을 사용자에게 입력 받고 
				System.out.printf("수정할 제목: ");
				String title = sc.nextLine();
				
				System.out.printf("수정할 내용: ");
				String body = sc.nextLine();
				
				//입력받은 애용으로 값을 수정 
				foundArticle.title = title;
				foundArticle.body = body;
				
				
				
				System.out.println(id + "번 계시물을 수정했습니다.");	
			}
			
			else if (cmd.startsWith("article delete ")) {

				String[] cmdBits = cmd.split(" "); //리턴 타입 String array
		
				int id = 0;
				
				try { //예외처리
					id = Integer.parseInt(cmdBits[2]); //정수로 형 변환 
				} catch (NumberFormatException e) {
					System.out.println("명령어가 올바르지 않습니다.");
					continue;
				} catch (Exception e) { //모든예외처리 
					System.out.println("error : " + e);
				}
				
				//Article foundArticle = null;
				int foundIndex = -1;//절대가질수없는 인덱스값을 초기값으로 설명 
				
				int i = 0;
				for (Article article : articles) {
					if (id == article.id) {
						foundIndex = i;
						break;
					}
					i++;
				}
				
				if (foundIndex == -1) {
					System.out.println(id  + "번 게시물은 존재하지 않습니다." );
					continue;
				}
				
				
				//사용자가 지우고자 하는 게시글이 articles의 안에 몇번 인덱스에 들어있는지
				//index버전 remove
				articles.remove(foundIndex); //지우고자 하는 게시물을 넣는다.
				
				
				System.out.println(id + "번 계시물을 삭제했습니다.");	
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
	String regDate;
	String title;
	String body;
	int viewCnt;
	
	public Article(int id,String regDate,String title,String body,int viewCnt) { //생성자
		
		
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
		this.viewCnt = viewCnt;
	}	
}

