/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofre.cucumber;

import cofre.CofrePM;
import cofre.CofrePMTest;
import cofre.Memoria;
import cofre.SensorPorta;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author rafae
 */
public class TravarSteps extends CofrePMTest {

    public TravarSteps() {
        sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);

        //porta sempre destravada
        when(sensorMock.travada())
                .thenReturn(Boolean.FALSE);
    }

    @Given("^que a porta esta aberta$")
    public void que_a_porta_esta_aberta() throws Exception {
        when(sensorMock.fechada())
                .thenReturn(Boolean.FALSE);
    }

    @Given("^que a porta esta fechada$")
    public void que_a_porta_esta_fechada() throws Exception {
        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
    }

    @Given("^eu abrir a porta$")
    public void eu_abrir_a_porta() throws Exception {
        when(sensorMock.fechada()).thenReturn(Boolean.FALSE);
    }

    @When("^eu pressionar o botao (\\d+)$")
    public void eu_pressionar_o_botao(int arg1) throws Exception {
        cofrePM.pressButton(arg1);
    }

    @When("^eu apertar ok$")
    public void eu_apertar_ok() throws Exception {
        cofrePM.ok();
    }

    @Then("^o display deve mostrar \"([^\"]*)\"$")
    public void o_display_deve_mostrar(String arg1) throws Exception {
        assertEquals(arg1, cofrePM.getDisplay());
    }

    @Then("^o cofre deve travar$")
    public void o_cofre_deve_travar() throws Exception {
        verify(sensorMock).travar();
        verify(memoriaMock).salvarSenha("123456");
    }

}
