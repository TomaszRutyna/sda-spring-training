package pl.sda.sdaspringtraining.api.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MvcMainPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    public void shouldDisplayMainView() throws Exception {
        //when
        ResultActions resultActions = mockMvc
                .perform(MockMvcRequestBuilders.get("/?branch=Warszawa")).andDo(print());
        //then
        resultActions.andExpect(model().attributeExists("now"))
                .andExpect(model().attribute("branch", "Warszawa"))
                .andExpect(content().string(containsString("Witaj")))
                .andExpect(status().is2xxSuccessful());

    }
}
