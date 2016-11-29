package com.dinfree.spring.edu.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.dinfree.spring.edu.addrbook.AddrBookController;

import java.util.ArrayList;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Spring boot - MVC 단일 테스트
 * <HR>
 * <ul>
 *  <li>Spring boot 에서 Spring MVC 부분을 따로 테스트 하는 경우임</li>
 *
 * </ul>
 * Created by dinfree on 2016. 8. 13..
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AddrBookController.class)
@ComponentScan(basePackages = {"com.dinfree.spring.edu"})
public class TestController {

    @Autowired
    private MockMvc mvc;

    /**
     * 뷰 연동 테스트
     */
    @Test
    public void listViewTest() throws Exception {
        MvcResult result = this.mvc.perform(get("/addrbook/"))
                .andExpect(status().isOk())
                .andExpect(view().name("addrbook_list"))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertNotNull(content);

        // 모델에 저장된 속성값을 가지고와 정상적으로 처리 되었는지 비교함. 컨트롤러에서 기본값은 HITLAB로 되어 있음
        // model 접근을 좀 더 쉽게 할 수 있는 방법이 있는지는 좀 더 찾아봐야 함.
        //assertEquals(result.getModelAndView().getModel().get("name"),"HITLab");
        assertNotNull(result.getModelAndView().getModel().get("page.content"));
    }
}
