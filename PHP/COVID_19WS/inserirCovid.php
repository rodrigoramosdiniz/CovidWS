<?php
require_once("CovidService.php");

$data = $_POST["data"];
$sexo = $_POST["sexo"];
$idade = $_POST["idade"];
$cidade = $_POST["cidade"];

    $covid = new StdClass();

        $covid->setData = $data;
        $covid->setSexo = $sexo;
        $covid->setIdade = $idade;
        $covid->setCidade = $cidade;

    $Service = new CovidService();

$Service->inserir($covid);

header("Location: index.php");

?>