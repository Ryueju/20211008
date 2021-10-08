package co.eju.prj.exe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.eju.prj.service.MemberService;
import co.eju.prj.service.MemberVO;
import co.eju.prj.serviceImpl.MemberServiceImpl;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);

	private MemberService memberService = new MemberServiceImpl();
	
	private void menuTitle() {
		System.out.println("=============================");
		System.out.println("===== 멤   버    관   리  =====");
		System.out.println("=============================");
		System.out.println("======= 1. 전체목록 조회 ========");
		System.out.println("======= 2. 회   원 조회 ========");
		System.out.println("======= 3. 회   원 등록 ========");
		System.out.println("======= 4. 회원정보 수정 ========");
		System.out.println("======= 5. 회원정보 삭제 ========");
		System.out.println("======= 6. 종       료 ========");
		System.out.println("===== 원하는 작업번호 선택하세요=====");
	}
	
	public void run() {
		
		while(true) {
			menuTitle();
			int key = sc.nextInt(); sc.nextLine(); //enter키 값을 제거하기 위해서
			switch(key) {
				case 1 :
					selectMemberList();
					break;
				case 2 :
					selectMember();
					break;
				case 3 :
					insertMember();
					break;
				case 4 :
					updateMember();
					break;
				case 5 :
					deleteMember();
					break;	
				case 6 :
					sc.close();
					return; //완전종료될 것,,
			}
		}
	}

	private void deleteMember() {
		//멤버객체를 전달해줘야함
		MemberVO vo = new MemberVO();
		System.out.println("============================");
		System.out.println("삭제할 회원의 아이디를 입력하세요>>>");
		System.out.println("============================");
		
		vo.setId(sc.nextLine()); //id 입력하고 enter치면 된다
		int n = memberService.deleteMember(vo);
		if(n !=0) {
			System.out.println("==========================");
			System.out.println("정상적으로 삭제되었습니다.");
			System.out.println("아무 키나 눌러주세요>>>");
			
		}else {
			System.out.println("===========================");
			System.out.println("삭제를 실패했습니다.");
			System.out.println("아무 키나 눌러주세요>>>");
		}
		sc.nextLine();
	}

	private void updateMember() {
		MemberVO vo = new MemberVO();
		System.out.println("변경하는 곳입니다.");
		System.out.println("============================");
		System.out.println("변경할 회원의 아이디를 입력하세요>>>");
		System.out.println("============================");
		
		vo.setId(sc.nextLine());
		
		int n = memberService.updateMember(vo);
		
		if(n !=0) {
			System.out.println("==========================");
			System.out.println("정상적으로 변경되었습니다.");
			System.out.println("아무 키나 눌러주세요>>>");
			
		}else {
			System.out.println("===========================");
			System.out.println("변경 실패했습니다.");
			System.out.println("아무 키나 눌러주세요>>>");
		}
		vo.toString();
		sc.nextLine();
		
	}

	private void insertMember() {
		MemberVO vo = new MemberVO();
		System.out.println("회원정보를 등록하는 곳입니다.");
		System.out.println("============================");
		System.out.println("등록할 회원의 아이디를 입력하세요>>>");
		System.out.println("============================");
		vo.setId(sc.nextLine());
		
		int n = memberService.insertMember(vo);
		vo.toString();
		System.out.println("=========================");
		System.out.println("Enter키를 눌러주세요>>>>>");
		sc.nextLine();
	}

	private void selectMember() {
		MemberVO vo = new MemberVO();
		System.out.println("회원정보를 검색하는 곳입니다.");
		
		System.out.println("============================");
		System.out.println("검색할 회원의 아이디를 입력하세요>>>");
		System.out.println("============================");
		
		vo.setId(sc.nextLine()); //id 입력하고 enter치면 된다
		MemberVO n = memberService.selectMember(vo);
		vo.toString();
		System.out.println("=========================");
		System.out.println("Enter키를 눌러주세요>>>>>");
		sc.nextLine();
		
	}

	private void selectMemberList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = memberService.selectMemberList();
		System.out.println("=============================");
		System.out.println("=======  회원 정보 목록 ========");
			for(MemberVO vo : list) {
				vo.toString();
			}
			System.out.println("===========================");
			System.out.println("Please Enter Key >>>>>>>>");
			sc.nextLine();
	}

}
