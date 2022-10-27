package com.spring.webmvc.board.controller;

import com.spring.webmvc.board.domain.Board;
import com.spring.webmvc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor    // 주입을 위해 생성자를 만든다
@Controller
@RequestMapping("/board")   // 공통 URL 진입점 설정
@Log4j2  // Lombok 라이브러리
public class BoardController {

    private final BoardService service;

    // 게시물 목록 조회 요청
    // 예전 버전 : @RequestMapping(value = "/list", method = RequestMethod.GET)
    @GetMapping("/list")
    public String list(Model model) throws IOException {

        int a = 10;
        List<Board> boardList = service.getList();
        log.info("/board/list GET ! 요청 발생 !  {}", a);   // {} 부분에 선언한 a 가 들어온다

        model.addAttribute("bList", boardList);     // 뷰 템플릿에 보내기 위하여 model을 사용한다

        return "board/list";

        /*

            TRACE - 잡다한 자잘한 로그
            DEBUG - 개발단계의 디버깅
            INFO - 정보
            WARN - 심각하진 않지만 경고
            ERROR - 심각한 에러     :: 밑으로 갈수록 중요한 로그이다

         */

    }
}