<?php
require_once("CovidService.php");

$id = intval($_GET["id"]);
$service = new CovidService();
$covids = $service->listar();
$covidAtual = null;

foreach($covids as $covid) {
    if($covid->id == $id)
        $covidAtual = $covid;
}

?>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <title>COVID_19</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  </head>
  <body>
    <!-- Cabeçalho -->
    <div class="jumbotron">
    
  <div class="panel panel-default">
    <div class="panel-heading">
        <h3>Cadastro de Casos De COVID_19 </h3>
    </div>
    </div>
    <form action="update.php" method="post">
    <div class="form-group">
                <input class="form-control" type="hidden" id="id" name="id" required>

                <label for="data">Data</label>
                <input class="form-control" type="text" id="data" name="data" required value="<?=$covidAtual->data;?>">
            </div>
            
            <div class="form-group">
                <label for="sexo">Sexo</label>
                <input class="form-control" type="text" id="sexo" name="sexo" required value="<?=$covidAtual->sexo;?>">
            </div>

            <div class="form-group">
                <label for="idade">Idade</label>
                <input class="form-control" type="number" id="idade" name="idade" required value="<?=$covidAtual->idade;?>">
            </div>

            <div class="form-group">
                <label for="cidade">Cidade</label>
                <input class="form-control" type="text" id="cidade" name="cidade" value="<?=$covidAtual->cidade;?>">
            </div>
            <button type="submit" class="btn btn-primary">Salvar</button>
        </form>
         
    </div>

    <table class="table table-bordered">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Data</th>
                  <th>Sexo</th>
                  <th>Idade</th>
                  <th>Cidade</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <?php foreach($covids as $covid): ?>
                  <tr>
                    <td><?= $covid->id; ?></td>
                    <td><?= $covid->data; ?></td>1
                    <td><?= $covid->sexo; ?></td>
                    <td><?= $covid->idade; ?></td>
                    <td><?= $covid->cidade; ?></td>
                    <td>
                     
                      <a href="edit.php?id=<?= $covid->id; ?>" class="btn btn-primary btn-sm">Editar</a>
                      <a href="remover.php?id=<?= $covid->id; ?>" class="btn btn-danger btn-sm">Excluir</a>
                        
                    </td>
                  </tr>
                <?php endforeach; ?>
              </tbody>
            </table>
          </div>
        </div>  
  </body>
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>