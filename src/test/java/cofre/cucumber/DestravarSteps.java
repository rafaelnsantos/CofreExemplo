package cofre.cucumber;

import cofre.CofrePM;
import cofre.CofrePMTest;
import cofre.Memoria;
import cofre.SensorPorta;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rafae
 */
public class DestravarSteps extends CofrePMTest {

    public DestravarSteps() {
        sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);

        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
        when(sensorMock.travada())
                .thenReturn(Boolean.TRUE);
    }

    @Given("^que a senha do cofre \"([^\"]*)\"$")
    public void que_a_senha_do_cofre(String arg1) throws Exception {
        when(memoriaMock.getSenha())
                .thenReturn(arg1);
    }

    @Given("^eu pressionei o botao (\\d+)$")
    public void eu_pressionei_o_botao(int arg1) throws Exception {
        cofrePM.pressButton(arg1);
    }

    @When("^eu apertar destravar$")
    public void eu_apertar_destravar() throws Exception {
        cofrePM.ok();
    }

    @Then("^o cofre deve destravar$")
    public void o_cofre_deve_destravar() throws Exception {
        verify(sensorMock, times(2)).destravar();
    }

    @Then("^deve aparecer no display \"([^\"]*)\"$")
    public void deve_aparecer_no_display(String arg1) throws Exception {
        assertEquals(arg1, cofrePM.getDisplay());
    }

}
