package co.eju.prj.service;

import java.util.List;

public interface MemberService {
	List<MemberVO> selectMemberList();//전체목록가져오기
	MemberVO selectMember(MemberVO vo); //어떤사람을 조회할 것이냐 원하는 한명을 가져오기
	int insertMember(MemberVO vo); //한명의 데이터 삽입
	int updateMember(MemberVO vo);	//데이터 변경
	int deleteMember(MemberVO vo);	//데이터 삭제
}
