package alisson.consumindo_APIs_Externas.service;

import alisson.consumindo_APIs_Externas.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
  //One way to do it ->
  // @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")

    //Better way ->
    @GetMapping("/{cep}/json/")
    Address consultarCep(@PathVariable("cep") String cep);
}
