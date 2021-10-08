package co.eju.prj;

import java.util.ArrayList;
import java.util.List;

import co.eju.prj.exe.MainMenu;
import co.eju.prj.service.MemberService;
import co.eju.prj.service.MemberVO;
//import co.eju.prj.dao.DataSource;
import co.eju.prj.serviceImpl.MemberServiceImpl;

public class MainApp {
	
	
	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
		mainMenu.run();
		
		//db���� �����غ��� //singleton class�� �ν��Ͻ��� ������ ��
//		DataSource dao = DataSource.GetInstance();
//		dao.getConnection(); //���� ��ü ȣ��
		
		
//		System.out.println("Hello ~");
		
		//전체데이터 조회
//		MemberService memberService = new MemberServiceImpl();
//		List<MemberVO> members = new ArrayList<MemberVO>();
//		members = memberService.selectMemberList();
//		//한명 분의 데이터를 조회하는 방법 입력할 때
//		MemberVO vo = new MemberVO();
//		vo.setId("riocute");
//		vo.setName("리오");
//		vo.setPassword("1234");
//		vo.setTel(null);
//		vo.setAddress(null);
//		vo.setAuthor("USER"); //필수항목까지 담았음
//		
//		int n = memberService.insertMember(vo); //입력해주세요~
//		if(n != 0) { //n이 0이 아니라면 = 입력성공
//			System.out.println("잘 입력되었습니다! ^^");
//		} else {
//			System.out.println("입력 실패.......");
//		}
		
	//	vo = memberService.selectMember(vo);
	//	vo.toString();
//		System.out.println("==============================");
	
	

//		for(MemberVO member : members) {
//		member.toString();
//		}
		

		
	}
}
