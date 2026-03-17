package com.cardiza.portfolio;

import com.cardiza.portfolio.controller.OrganizationController;
import com.cardiza.portfolio.dto.OrganizationDto;
import com.cardiza.portfolio.service.OrganizationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.IntStream;

import static com.cardiza.portfolio.config.ControllerNamings.ALL;
import static com.cardiza.portfolio.config.ControllerNamings.ORGANIZATION;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrganizationController.class)
class OrganizationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrganizationService organizationService;

    private List<OrganizationDto> orgList;

    @BeforeEach
    void setUp() {
        orgList = IntStream.rangeClosed(1, 15)
                .mapToObj(i -> new OrganizationDto(
                        i,
                        "Organization " + i,
                        "iconBase64_" + i
                ))
                .toList();
    }

    @Test
    void getAllOrganizations() throws Exception {
        Mockito.when(organizationService.getAllOrganizations()).thenReturn(orgList);

        mockMvc.perform(get(ORGANIZATION + ALL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(orgList.size()));
    }

    @Test
    void getAllOrganizationsPaginated() throws Exception {
        List<OrganizationDto> pageContent = orgList.subList(0, 10);
        Page<OrganizationDto> page = new PageImpl<>(pageContent, PageRequest.of(0, 10), orgList.size());

        Mockito.when(organizationService.getAllOrganizationsPaginated(anyInt(), anyInt(), anyString()))
                .thenReturn(page);

        mockMvc.perform(get(ORGANIZATION))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(pageContent.size()));
    }
}