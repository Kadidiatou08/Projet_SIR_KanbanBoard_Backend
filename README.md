# Tp Sir Back-End 

Modélisation UML

![Uml](https://i.ibb.co/bvxXXyW/Kanban-Uml.jpg)


la base de donnée utiliser pour ce TP est une base de données Mysql.

- nom de la base : **boarddb**


- nom d'utilisateur : **root**

- mot de passe : ""


EndPoint Rest


Get : 

    - http://localhost:8080/user/all      pour récupperer la liste des utilisateurs
    - http://localhost:8080/card/all      pour récupperer la liste des fiches
    - http://localhost:8080/section/all   pour récupperer la liste des sections
    - http://localhost:8080/board/all     pour récupperer la liste des tableaux
    - http://localhost:8080/tag/all       pour récupperer la liste des tag
    
    - http://localhost:8080/user/{id}      pour récupperer un utilisateur selon l'id
    - http://localhost:8080/card/{id}      pour récupperer une fiche selon son l'id
    - http://localhost:8080/section/{id}   pour récupperer une section selon l'id
    - http://localhost:8080/board/{id}     pour récupperer un tableau selon l'id
    - http://localhost:8080/tag/{id}       pour récupperer un tag selon l'id

Post :

    - http://localhost:8080/user/add       pour ajouter un utilisateur

        {
            "name": "Kone Sidney Aziz Khader",
            "email": "k@gmail.com",
            "password": "asas"
        }

    - http://localhost:8080/user/login       pour connecter un utilisateur

        {
            "email": "k@gmail.com",
            "password": "asas"
        }

    -  http://localhost:8080/card/add      pour ajouter une fiche

        {
            "name": "Fiche 1",
            "noteOfExplanation": "Note d explication",
            "realizationTime": 102010,
            "location": "Localisation",
            "idUsersAssigned": [], // Spécifier les utilisateurs assignés à la fiche 1
            "idUserCreated": 1,    // Spécifier l'id de l'utilisateur qui crée la fiche 1
            "deadline": "2020-08-12", //Spécifier la deadline
            "idSection": 3 // Spécifier la section de la fiche 1
        }

    - http://localhost:8080/card/adduser         pour ajouter des utilisateurs à la fiche

        {
            "idCard": 1  //Spécifier l'id de la fiche
            "idUsersAssigned": []    //Spécifier la liste des id utilisateurs à assigner à la fiche
        }

    - http://localhost:8080/card/deleteuser      pour supprimer des utilisateurs à la fiche

        {
            "idCard": 1  //Spécifier l'id de la fiche
            "idUsersAssigned": []    //Spécifier la liste des id utilisateurs à retirer à la fiche
        }

    - http://localhost:8080/card/deleteuser      pour changer la section de la fiche

        {
            "idCard": 1  //Spécifier l'id de la fiche
            "idSection": 3    //Spécifier l'id de la section
        }


    - http://localhost:8080/section/add    pour ajouter une section

        {
            "name": "En cours"
        }

    - http://localhost:8080/board/add    pour ajouter un tableau

         {
              "name": "nom du tableau"
         }

    - http://localhost:8080/board/addsection    pour ajouter une section à un tableau

        {
            "idBoardDto": 12  //Spécifier l'id du tableau
            "idSection": 3    //Spécifier l'id de la section à ajouter au tableau
        }

     - http://localhost:8080/tag/add    pour ajouter un tag

        {
              "name": "nom du tag"
         }

Put : pour modification 
  
    - http://localhost:8080/board/update  // passer en corps de la requete l'instance pour modification en précisant l'id 
    - http://localhost:8080/card/update
        {   
            "id": 1
            "name": "Fiche 1",
            "noteOfExplanation": "Note d explication",
            "realizationTime": 102010,
            "location": "Localisation",
            "deadline": "2020-08-12", //Spécifier la deadline
           
        }
    - http://localhost:8080/user/update    // passer en corps de la requete l'instance pour modification en précisant l'id 
    - http://localhost:8080/section/update  // passer en corps de la requete l'instance pour modification en précisant l'id
    - http://localhost:8080/tag/update      // passer en corps de la requete l'instance pour modification en précisant l'id

Delete :
    
    - http://localhost:8080/board/delete/{id}   //pour supprimer un tableau il faut spécifier l' id de l'element à supprimer
    - http://localhost:8080/card/delete/{id}   //pour supprimer une fiche il faut spécifier l'id de l'element à supprimer
    - http://localhost:8080/user/delete/{id}   //pour supprimer un utilisateur il faut spécifier l' id de l'element à 
 supprimer
    - http://localhost:8080/section/delete/{id}   //pour supprimer une section il faut spécifier l' id de l'element à supprimer
    - http://localhost:8080/tag/delete/{id}       //pour supprimer un tag il faut spécifier l' id de l'element à supprimer