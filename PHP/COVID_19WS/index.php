<?php 
  require_once("CovidService.php");
  session_start();
  $service = new CovidService();
  
  $Covid = $service->listar();
 
 
?>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <title>Covid_19</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  </head>

  
  <body>

  <div class="jumbotron">
    
  <div class="panel panel-default">
    <div class="panel-heading">
        <h3>Cadastro de Casos De COVID_19 </h3>
    </div>
    </div>
    <form action="inserirCovid.php" method="post">
    <div class="form-group">
                <label for="data">Data</label>
                <input class="form-control" type="text" id="data" name="data" required>
            </div>
            
            <div class="form-group">
                <label for="sexo">Sexo</label>
                <input class="form-control" type="text" id="sexo" name="sexo" required>
            </div>

            <div class="form-group">
                <label for="idade">Idade</label>
                <input class="form-control" type="text" id="idade" name="idade" required>
            </div>

            <div class="form-group">
                <label for="cidade">Cidade</label>
                <input class="form-control" type="text" id="cidade" name="cidade" required>
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
                <?php foreach($Covid as $covid): ?>
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
    
  </body>
   
</html>