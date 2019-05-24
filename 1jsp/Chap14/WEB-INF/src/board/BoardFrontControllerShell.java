package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import board.command.*;


public class BoardFrontControllerShell extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFrontControllerShell() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmdURI = requestURI.substring(contextPath.length());
		
		BoardCmd cmd = null;
		String viewPage = null;
		
		// 글 목록 조회 처리
		if(cmdURI.equals("/boardList.bbs")){}

		// 글 작성 화면 제공
		if(cmdURI.equals("/boardWriteForm.bbs")){}
		
		// 글 작성 처리
		if(cmdURI.equals("/boardWrite.bbs")){}
		
		// 글 열람 처리
		if(cmdURI.equals("/boardRead.bbs")){}
		
		// 글 수정 비밀번호 확인 화면 제공
		if(cmdURI.equals("/boardUpdatePassword.bbs")){}
		
		// 글 수정 비밀번호 확인 처리
		if(cmdURI.equals("/boardUpdateCheck.bbs")){}
		
		// 글 수정 비밀번호 오류 화면 제공
		if(cmdURI.equals("/boardUpdateError.bbs")){}
		
		// 글 수정 화면 제공
		if(cmdURI.equals("/boardUpdateForm.bbs")){}
		
		// 글 수정 처리
		if(cmdURI.equals("/boardUpdate.bbs")){}
		
		// 글 삭제 비밀번호 확인 화면 제공
		if(cmdURI.equals("/boardDeletePassword.bbs")){}
		
		// 글 삭제 비밀번호 확인 처리
		if(cmdURI.equals("/boardDeleteCheck.bbs")){}
		
		// 글 작세 비밀번호 오류 화면 제공
		if(cmdURI.equals("/boardDeleteError.bbs")){}
		
		// 글 삭제 처리
		if(cmdURI.equals("/boardDelete.bbs")){}
		
		// 글 검색 처리
		if(cmdURI.equals("/boardSearch.bbs")){}
		
		// 답글 작성 화면 제공
		if(cmdURI.equals("/boardReplyForm.bbs")){}
		
		// 답글 작성 처리
		if(cmdURI.equals("/boardReply.bbs")){}
	
		RequestDispatcher dis = request.getRequestDispatcher(viewPage);
		dis.forward(request, response);
	}
}
