package alisson.consumindo_APIs_Externas.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    //need to finish
}
