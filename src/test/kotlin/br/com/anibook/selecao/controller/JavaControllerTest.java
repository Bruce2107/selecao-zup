package br.com.anibook.selecao.controller;

import br.com.anibook.selecao.entity.Person;
import br.com.anibook.selecao.exception.ServiceException;
import br.com.anibook.selecao.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PersonController.class)
public class JavaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PersonService personService;

    @Test
    public void TestCreatePerson() throws Exception {
        Person person = new Person(1L, "Eduardo", "473", "pires", null);
        String inputJson = this.mapToJson(person);
        String URI = "/api/v1/person/";

        Mockito.when(personService.save(Mockito.any(Person.class))).thenReturn(person);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).
                accept(MediaType.APPLICATION_JSON).
                content(inputJson).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = result.getResponse().getContentAsString();
//        assertThat(outputJson).isEqualTo(inputJson);
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }


    @Test
    public void getAllTest() throws Exception {
        Person person = new Person(1L, "Eduardo", "473", "pires", null);
        Person person2 = new Person(2L, "Vitoria", "473", "pires", null);
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(person);
        listPerson.add(person2);

        Mockito.when(personService.list()).thenReturn(listPerson);
        String URI = "/api/v1/person/";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson = this.mapToJson(listPerson);
        String outputJson = result.getResponse().getContentAsString();
        assertThat(outputJson).isEqualTo(expectedJson);
    }

    @Test
    public void getByIdTest() throws Exception {
        Person person = new Person(1L, "Eduardo", "473", "pires", null);
        Mockito.when(personService.load(Mockito.anyLong())).thenReturn(person);
        String URI = "/api/v1/person/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(person);
        String outputJson = result.getResponse().getContentAsString();
        assertThat(outputJson).isEqualTo(expectedJson);
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}