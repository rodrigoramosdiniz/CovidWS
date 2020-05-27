<?php
require_once("CovidService.php");

$id = $_POST["id"];
$cidade = $_POST["cidade"];
$data = $_POST["data"];
$sexo = $_POST["sexo"];
$idade = $_POST["idade"];

$covid = new StdClass();
$covid->setId = $id;
$covid->setCidade = $cidade;
$covid->setData = $data;
$covid->setSexo = $sexo;
$covid->setIdade = $idade;

$service = new CovidService();
$service->alterar($covid);

header("Location: index.php");