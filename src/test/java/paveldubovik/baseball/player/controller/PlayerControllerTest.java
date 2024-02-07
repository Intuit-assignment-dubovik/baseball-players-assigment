package paveldubovik.baseball.player.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import paveldubovik.baseball.exception.PlayerNotFoundException;
import paveldubovik.baseball.player.dto.PlayerDto;
import paveldubovik.baseball.player.service.PlayerService;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlayerController.class)
class PlayerControllerTest {
    String playerId = "abadijo01";
    int birthYear = 1850;
    byte birthMonth = 11;
    byte birthDay = 4;
    String birthCountry = "USA";
    String birthState = "PA";
    String birthCity = "Philadelphia";
    int deathYear = 1905;
    byte deathMonth = 5;
    byte deathDay = 17;
    String deathCountry = "USA";
    String deathState = "NJ";
    String deathCity = "Pemberton";
    String nameFirst = "John";
    String nameLast = "Abadie";
    String nameGiven = "John W.";
    int weight = 192;
    int height = 72;
    char battingHand = 'R';
    char throwingHand = 'R';
    LocalDate debut = LocalDate.of(1875, 4, 26);
    LocalDate finalGame = LocalDate.of(1875, 6, 10);
    String retroID = "abadj101";
    String bbrefID = "abadijo01";
    PlayerDto expectedPlayer = new PlayerDto(playerId, birthYear, birthMonth, birthDay, birthCountry, birthState, birthCity, deathYear, deathMonth, deathDay,
            deathCountry, deathState, deathCity, nameFirst, nameLast, nameGiven, weight, height, battingHand, throwingHand, debut, finalGame,
            retroID, bbrefID);
    @Autowired
    MockMvc mockMvc;
    @MockBean
    PlayerService service;
    @Autowired
    ObjectMapper mapper;

    @Test
    @DisplayName("Controler: Get all players")
    void testGetPlayers() throws Exception {
        // Given
        String expectedAsString = mapper.writeValueAsString(List.of(expectedPlayer));
        // When
        when(service.getPlayers()).thenReturn(List.of(expectedPlayer));
        ResultActions result = mockMvc.perform(get("/api/players")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
        // Then
        String resultAsString = result
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(expectedAsString, resultAsString);
        verify(service, times(1)).getPlayers();
    }

    @Test
    void getPlayerByID() throws Exception {
        // Given
        String expectedAsString = mapper.writeValueAsString(expectedPlayer);
        // Then
        when(service.getPlayerByID(playerId)).thenReturn(expectedPlayer);
        ResultActions result = mockMvc.perform(get("/api/players/" + playerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
        // When
        String resultAsString = result
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(expectedAsString, resultAsString);
        verify(service, times(1)).getPlayerByID(any());
    }

    @Test
    void getPlayerByIDNotExist() throws Exception {
        // Given
        String wrongId = "wrongId";
        // Then
        when(service.getPlayerByID(wrongId)).thenThrow(new PlayerNotFoundException(wrongId));
        ResultActions result = mockMvc.perform(get("/api/players/" + wrongId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
        // When
        result
                .andExpect(status().is(404))
                .andReturn().getResponse().getContentAsString();
        verify(service, times(1)).getPlayerByID(any());
    }
}