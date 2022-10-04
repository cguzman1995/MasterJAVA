package es.uned.master.java.logactaesque;

import com.jayway.jsonpath.JsonPath;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;


// @RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest(classes = DiceConfiguration.class)
@AutoConfigureMockMvc
@WebAppConfiguration 
public class DiceControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void canRollTheYellowDice() throws Exception {
        this.mockMvc.perform(get("/dice/roll"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void rollingDiceReturnsValidNumbers() throws Exception {

        ResultActions result = this.mockMvc.perform(get("/dice/roll"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        String content = result.andReturn().getResponse().getContentAsString();

        Integer rolledNumber = JsonPath.read(content, "$.rolledNumber");
        assertThat(rolledNumber, is(oneOf(1, 2, 3, 4, 5, 6)));
    }

}