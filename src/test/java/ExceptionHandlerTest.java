import com.ysb.j2we.config.J2weApplicationContextConfig;
import com.ysb.j2we.controller.rest.PersonControllerRest;
import com.ysb.j2we.model.exception.PersonNotFoundException;
import com.ysb.j2we.model.service.IPersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {J2weApplicationContextConfig.class})
public class ExceptionHandlerTest {

    @Autowired
    private WebApplicationContext wac;

    @InjectMocks
    private PersonControllerRest personController;

    private MockMvc mockMvc;

    @Mock
    private IPersonService personService;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
            .build();
    }

    @Test
    public void msgTest() throws Exception {
        when(personService.get(4L)).thenThrow(new PersonNotFoundException("Person with id: 5 not found"));

        mockMvc.perform(post("/api/person").param("param", "4"))
            .andDo(print())
            .andExpect(status().is4xxClientError())
            .andExpect(content().string(containsString("Person with id: 4 not found")));
    }
}