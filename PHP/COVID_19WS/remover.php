<?php


require_once("CovidService.php");

$id = intval($_GET["id"]);

$service = new CovidService();
$service->remover($id);


header("Location: index.php");

?>