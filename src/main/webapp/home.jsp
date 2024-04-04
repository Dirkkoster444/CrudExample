<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>home</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<div class="container">
    <div class="row">
        <table class="table table-dark">
            <thead>
            <tr>
                <th>Naam</th>
                <th>Prijs</th>
                <th>Beschrijving</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="games">
                <tr class="table-row">
                    <td><s:property value="name"/></td>
                    <td><s:property value="price"/></td>
                    <td><s:property value="description"/></td>
                    <td class="text-center">
                        <button style="background-color: green" class="btn btn-actie" data-bs-toggle="modal" data-bs-target="#bewerken" data-bs-id="<s:property value="id" />" data-bs-name="<s:property value="name" />" data-bs-price="<s:property value="price" />" data-bs-description="<s:property value="description" />">
                            <i class="bi bi-pencil-square"></i></button>
                        <button style="background-color: red" class="btn btn-actie" data-bs-toggle="modal" data-bs-target="#deleteGame" data-bs-id="<s:property value="id"/>">
                            <i class="bi bi-trash"></i></button>
                    </td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
        <div class="col-lg">
            <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addGame">
                <i class="bi bi-plus-square-fill"></i>
            </button>
        </div>
    </div>
</div>



<div class="modal fade" id="addGame" tabindex="-1" aria-hidden="true">

    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h1 class="modal-title fs-5">Add a Game</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>


            <div class="modal-body">

                <form action="addGame" method="post">
                    <div class="form-group mt-2">
                        <label for="toevoegen-name">Titel</label>
                        <input type="text" name="game.name" id="toevoegen-name" placeholder="Titel" class="form-control">
                    </div>

                    <div class="form-group mt-2">
                        <label for="toevoegen-price">Prijs</label>
                        <input type="text" name="game.price" id="toevoegen-price" placeholder="Prijs" class="form-control">
                    </div>

                    <div class="form-group mt-2">
                        <label for="toevoegen-description">description</label>
                        <input type="text" name="game.description" id="toevoegen-description" placeholder="Description" class="form-control">
                    </div>



                    <input type="submit" value="Verzenden" class="btn btn-primary form-control mt-3">
                </form>

            </div>

        </div>
    </div>

</div>

<div class="modal verwijder-modal" tabindex="-1" id="deleteGame">
    <div class="modal-dialog">
        <div class="modal-content">

            <form action="deleteGame" method="post">

                <div class="modal-header text-center">
                    <h1>Weet u zeker dat de game wilt verwijderen?</h1>
                </div>

                <input type="hidden" name="id" id="verwijderen-id">

                <div class="modal-footer d-flex justify-content-between">
                    <button type="submit" class="btn btn-verwijderen mx-auto">
                        Verwijderen
                    </button>

                    <button type="button" data-bs-dismiss="modal" class="btn btn-annuleren mx-auto">
                        Annuleren
                    </button>
                </div>

            </form>

        </div>
    </div>
</div>

<div class="modal generic-modal" tabindex="-1" id="bewerken">
    <div class="modal-dialog">
        <div class="modal-content">

            <form action="editGame" method="post">

                <div class="modal-header">
                    <div class="col"></div>

                    <div class="col">
                        <h1>Bewerken</h1>
                    </div>

                    <div class="col d-flex justify-content-end">
                        <button type="button"data-bs-dismiss="modal">
                            X
                        </button>
                    </div>
                </div>

                <div class="modal-body">

                    <input type="hidden" name="id" id="bewerken-id">

                    <div class="form-group mt-2">
                        <label for="bewerken-name">Titel</label>
                        <input type="text" name="game.name" id="bewerken-name" placeholder="Naam" class="form-control">
                    </div>

                    <div class="form-group mt-2">
                        <label for="bewerken-price">Prijs</label>
                        <input type="text" name="game.price" id="bewerken-price" placeholder="Prijs" class="form-control">
                    </div>

                    <div class="form-group mt-2">
                        <label for="bewerken-description">description</label>
                        <input type="text" name="game.description" id="bewerken-description" placeholder="Beschrijving" class="form-control">
                    </div>

                </div>

                <div class="modal-footer d-flex justify-content-center">
                    <button type="submit" class="btn mx-auto">
                        Bewerken
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script>
    const deleteModal = document.getElementById('deleteGame');
    console.log('aap');

    deleteModal.addEventListener('show.bs.modal', (event) => {
        let button = event.relatedTarget;
        let id = button.getAttribute('data-bs-id');
        let idInput = document.getElementById('verwijderen-id');
        idInput.value = id;
        console.log(id);
    });

    const bewerken = document.getElementById('bewerken');

    bewerken.addEventListener('show.bs.modal', function (event) {
        let button = event.relatedTarget;
        let id = button.getAttribute('data-bs-id');
        let name = button.getAttribute('data-bs-name');
        let price = button.getAttribute('data-bs-price');
        let description = button.getAttribute('data-bs-description');

        let idInput = document.getElementById('bewerken-id');
        let nameInput = document.getElementById('bewerken-name');
        let priceInput = document.getElementById('bewerken-price');
        let descriptionInput = document.getElementById('bewerken-description');

        idInput.value = id;
        nameInput.value = name;
        priceInput.value = price;
        descriptionInput.value = description;
    });
</script>
</body>
</html>
