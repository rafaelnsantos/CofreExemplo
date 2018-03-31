package cofre.cucumber;

import cofre.ValidacaoHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rafae
 */
public class ValidacaoHelperSteps {

    String senha;

    @Given("^a senha entrada \"([^\"]*)\"$")
    public void a_senha_entrada(String arg1) throws Exception {
        senha = arg1;
    }

    @Then("^o retorno deve ser True$")
    public void o_retorno_deve_ser_True() throws Exception {
        Assert.assertTrue(ValidacaoHelper.ehNumero(senha));
    }

    @Then("^o retorno deve ser False$")
    public void o_retorno_deve_ser_False() throws Exception {
        Assert.assertFalse(ValidacaoHelper.ehNumero(senha));
    }

    @Then("^a senha deve True$")
    public void a_senha_deve_True() throws Exception {
        Assert.assertTrue(ValidacaoHelper.ehSenhaValida(senha));
    }

    @Then("^a senha deve False$")
    public void a_senha_deve_False() throws Exception {
        Assert.assertFalse(ValidacaoHelper.ehSenhaValida(senha));
    }

}
