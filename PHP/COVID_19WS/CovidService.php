
<?php

class CovidService{



   private $client;

    public function __construct()
    {
       $this->client = new SoapClient("http://localhost:8000/covid?WSDL");
    }

    public function inserir(StdClass $covid): void
    {
        $parametros = [
            "covid_19" => [
                "id" => 0,
                "data" => $covid->setData,
                "sexo" => $covid->setSexo,
                "idade" => $covid->setIdade,
                "cidade" => $covid->setCidade
            ]
        ];
        
        try {
             $this->client->__soapCall("inserir", [$parametros]);
        } catch(Exception $exception) {
            echo $exception->getMessage();
            exit;
        }
    }

    public function alterar(StdClass $covid): void
    {
        $parametros = [
            "covid_19" => [
                "id" => $covid->setId,
                "data" => $covid->setData,
                "sexo" => $covid->setSexo,
                "idade" => $covid->setIdade,
                "cidade" => $covid->setCidade
            ]
        ];
        
        try {
             $this->client->__soapCall("alterar", [$parametros]);
        } catch(Exception $exception) {
            echo $exception->getMessage();
            exit;
        }
    }

    public function listar(): array
    {
        try {
            $result = $this->client->__soapCall("listar", []);
        } catch(Exception $ex) {
            echo $ex->getMessage();exit;
        }
        return $result->return;
    }

  public function remover(int $id):void{
      $parametros = [
        "id" => $id
      ];
  }
}
    ?>

